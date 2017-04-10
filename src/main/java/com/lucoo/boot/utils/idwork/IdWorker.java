package com.example.utils.key;

/**
 * snowflake
 *
 * @lucoo
 * @JDK1.8
 */
public class IdWorker {
    //唯一时间，这是一个避免重复的随机量，自行设定不要大于当前时间戳
    private final long twepoch = 1288834974657L;
    //机器标识位
    private final long workerIdBits = 5L;
    //数据中心标识位
    private final long datacenterIdBits = 5L;
    //机器ID最大值(异或运算示例：【4^6】4为0100 ，6为0110，0100^0100 结果为0010，所以十进制输出结果为2)
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    //数据中心ID最大值
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    //序列号(毫秒内自增位)
    private final long sequenceBits = 12L;
    //机器ID左移12位
    private final long workerIdShift = sequenceBits;
    // 数据中心ID左移17位
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    // 时间毫秒左移22位
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public IdWorker(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public long nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            //当前毫秒内+1
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 当前毫秒内计数满了，则等待下一秒
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;

        //ID偏移组合生成最终的ID
        return ((timestamp - twepoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    public synchronized long concurrentNextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            //当前毫秒内+1
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 当前毫秒内计数满了，则等待下一秒
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;

        //ID偏移组合生成最终的ID
        return ((timestamp - twepoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    public static void main(String[] args) {
        IdWorker idWorker = new IdWorker(0, 0);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            System.out.println(idWorker.nextId());
        }
        System.out.println("测试用时：" + (System.currentTimeMillis() - start) + "ms");
    }
}
