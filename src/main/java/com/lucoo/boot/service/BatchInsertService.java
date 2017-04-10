package com.lucoo.boot.service;

import com.lucoo.boot.dao.ads.TMemberWriteMapper;
import com.lucoo.boot.entity.TMember;
import com.lucoo.boot.utils.idwork.IdWorker;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @lucoo
 * @JDK1.8
 */
@Service
public class BatchInsertService {
    private Logger logger = Logger.getLogger(BatchInsertService.class);
    @Autowired
    private TMemberWriteMapper tMemberWriteMapper;

    @Autowired
    @Qualifier("adsDataSource")
    private DataSource adsDataSource;

    public void batchInsertRecord() {
        long generatorStartTime = System.currentTimeMillis();
        List<TMember> list = new LinkedList<>();
        IdWorker idWorker = new IdWorker(0, 0);
        int count = 30000;
        for (int j = 0; j < count; j++) {
            TMember tMember = new TMember();
            tMember.setId(idWorker.concurrentNextId());
            list.add(tMember);
        }
        logger.info("批量生成" + count + "万id用时：" + (System.currentTimeMillis() - generatorStartTime) + "ms");
        long insertStartTime = System.currentTimeMillis();
        tMemberWriteMapper.batchInsertRecord(list);
        logger.info("批量插入" + count + "条记录用时：" + (System.currentTimeMillis() - insertStartTime) + "ms");
    }

    public void batchInsertOriginal() {
        long generatorStartTime = System.currentTimeMillis();
        List<TMember> list = new LinkedList<>();
        IdWorker idWorker = new IdWorker(0, 0);
        int count = 30000;
        for (int i = 0; i < count; i++) {
            TMember tMember = new TMember();
            tMember.setId(idWorker.concurrentNextId());
            list.add(tMember);
        }
        logger.info("批量生成" + count + "万id用时：" + (System.currentTimeMillis() - generatorStartTime) + "ms");
        String prefix = "insert into t_member (id, username,age) values";
        Connection connection = null;
        PreparedStatement pst = null;
        long insertStartTime = System.currentTimeMillis();
        try {
            StringBuffer sb = new StringBuffer();
            connection = adsDataSource.getConnection();
            connection.setAutoCommit(false);
            pst = connection.prepareStatement("");
            //外层循环总事务提交数
            for (TMember tMember : list) {
                sb.append("(" + tMember.getId() + "," + tMember.getUsername() + "," + tMember.getAge() + "),");
            }
            String sql = prefix + sb.substring(0, sb.length() - 1);
            pst.addBatch(sql);
            pst.executeBatch();
            connection.commit();
            sb = new StringBuffer();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("批量插入" + count + "条记录用时：" + (System.currentTimeMillis() - insertStartTime) + "ms");
    }


}
