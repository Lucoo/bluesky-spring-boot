package com.lucoo.boot;

import com.lucoo.boot.service.BatchInsertService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @lucoo
 * @JDK1.8
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BatchInsertTest {
    @Autowired
    private BatchInsertService batchInsertService;

    @Test
    public void testBatchInsert() {
        batchInsertService.batchInsertRecord();
    }

    @Test
    public void testBatchOriginal() {
        batchInsertService.batchInsertOriginal();
    }
}
