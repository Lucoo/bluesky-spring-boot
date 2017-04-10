package com.lucoo.boot.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by lucoo on 2016/11/28.
 */

@Component
public class RedisCacheUtils<T> {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 缓存对象
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> ValueOperations<String, T> setObjCache(String key, T value) {
        ValueOperations<String, T> operations = redisTemplate.opsForValue();
        operations.set(key, value);
        return operations;
    }

    /**
     * 获取缓存对象
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getObjCache(String key) {
        ValueOperations<String, T> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * 缓存List
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> ListOperations<String, List<T>> setListCache(String key, List<T> value) {
        ListOperations operations = redisTemplate.opsForList();
        operations.leftPushAll(key, value);
        return operations;
    }

    /**
     * 获取缓存List
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> List<T> getListCache(String key) {
        List<T> dataList = new ArrayList<T>();
        ListOperations<String, T> operations = redisTemplate.opsForList();
        Long length = operations.size(key);
        for (int i = 0; i < length; i++) {
            dataList.add(operations.leftPop(key));
        }
        return dataList;
    }

    /**
     * 缓存set
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> BoundSetOperations<String, Set<T>> setSetCache(String key, Set<T> value) {
        BoundSetOperations boundSetOperations = redisTemplate.boundSetOps(key);
        Iterator<T> iterator = value.iterator();
        while (iterator.hasNext()) {
            boundSetOperations.add(iterator.next());
        }
        return boundSetOperations;
    }

    /**
     * 获取set
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> Set<T> getSetCache(String key) {
        Set<T> set = new HashSet<T>();
        BoundSetOperations<String, Set<T>> boundSetOperations = redisTemplate.boundSetOps(key);
        return boundSetOperations.pop();
    }

    /**
     * 缓存map
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> HashOperations<String, String, T> setCacheMap(String key, HashMap<String, T> value) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        if (value != null) {
            for (Map.Entry<String, T> map : value.entrySet()) {
                hashOperations.put(key, map.getKey(), map.getValue());
            }
        }
        return hashOperations;
    }

    /**
     * 获取map
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> Map<String, T> getCacheMap(String key) {
        Map<String, T> map = redisTemplate.opsForHash().entries(key);
        return map;
    }
}

