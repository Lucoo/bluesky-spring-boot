package com.lucoo.boot.controller;

import com.lucoo.boot.service.BatchInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试批量生产id批量插入mysql
 *
 * @lucoo
 * @JDK1.8
 */
@Controller
public class BatchInsertController {

    @Autowired
    private BatchInsertService batchInsertService;

    @RequestMapping("/batchInsert")
    public void batchInsertRecord() {
        batchInsertService.batchInsertRecord();
    }
}
