package com.lucoo.boot.controller;

import com.lucoo.boot.entity.Member;
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

    @RequestMapping(value = "/{username}")
    @ResponseBody
    public Member insert(@PathVariable("username") String username) {
        return memberService.insert(username);
    }

    @RequestMapping(value = "/list.json")
    @ResponseBody
    public List<Member> getAllList() {
        return memberService.getAllList();
    }
}
