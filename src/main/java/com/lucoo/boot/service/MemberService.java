package com.lucoo.boot.service;

import com.lucoo.boot.dao.ads.MemberWriteDao;
import com.lucoo.boot.dao.rds.MemberReadDao;
import com.lucoo.boot.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lucoo on 2016/10/27.
 */
@Service
public class MemberService {

    @Autowired
    private MemberWriteDao memberWriteDao;

    @Autowired
    private MemberReadDao memberReadDao;

    public Member insert(String username) {
        Member member = new Member();
        member.setUsername(username);
        memberWriteDao.insert(member);
//        memberWriteDao.insertXml(member);
        return member;
    }

    public List<Member> getAllList() {
        return memberReadDao.selectAll();
    }
}
