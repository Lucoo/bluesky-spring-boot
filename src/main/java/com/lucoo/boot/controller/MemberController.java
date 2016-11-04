package com.lucoo.boot.controller;

import com.lucoo.boot.common.page.BlueSkyPage;
import com.lucoo.boot.entity.TMember;
import com.lucoo.boot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lucoo on 2016/10/27.
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/getList.json")
    @ResponseBody
    public BlueSkyPage<TMember> getListByCondition() {
        return memberService.getListByExample();
    }

    @RequestMapping(value = "/insert/{name}/{age}")
    @ResponseBody
    public TMember insert(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        return memberService.insert(name, age);
    }
}
