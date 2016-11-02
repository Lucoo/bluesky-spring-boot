package com.lucoo.boot.service;

import com.lucoo.boot.dao.ads.TMemberWriteMapper;
import com.lucoo.boot.dao.rds.TMemberMapper;
import com.lucoo.boot.entity.TMember;
import com.lucoo.boot.entity.TMemberExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lucoo on 2016/10/27.
 */
@Service
public class MemberService {
    @Autowired
    private TMemberMapper tMemberMapper;
    @Autowired
    private TMemberWriteMapper tMemberWriteMapper;

    public List<TMember> getListByExample() {
        TMemberExample tMemberExample = new TMemberExample();
        TMemberExample.Criteria criteria = tMemberExample.createCriteria();
        criteria.andUsernameEqualTo("lucoo2");
        return tMemberMapper.selectByExample(tMemberExample);
    }

    public TMember insert(String name, Integer age) {
        TMember tMember = new TMember();
        tMember.setUsername(name);
        tMember.setAge(age);
        tMemberWriteMapper.insertSelective(tMember);
        return tMember;
    }
}
