package com.lucoo.boot.service;

import com.lucoo.boot.dao.ads.MemberWriteDao;
import com.lucoo.boot.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lucoo on 2016/10/27.
 */
@Service
public class MemberService {

    @Autowired
    private MemberWriteDao memberWriteDao;

    public Member insert(String username) {
        Member member = new Member();
        member.setUsername(username);
        memberWriteDao.insertSelective(member);
        return member;
    }
}
