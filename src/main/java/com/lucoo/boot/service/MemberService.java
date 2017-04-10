package com.lucoo.boot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lucoo.boot.common.page.BlueSkyPage;
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

    public BlueSkyPage<TMember> getListByExample() {
        TMemberExample tMemberExample = new TMemberExample();
        TMemberExample.Criteria criteria = tMemberExample.createCriteria();
        criteria.andUsernameEqualTo("lucoo2");
        tMemberExample.or().andIdEqualTo(new Long(1));
        tMemberExample.setOrderByClause(" username desc");
        Page<TMember> page = PageHelper.startPage(1, 5);
        tMemberMapper.selectByExample(tMemberExample);
        BlueSkyPage<TMember> blueSkyPage = new BlueSkyPage<>();
        blueSkyPage.setTotalCount(page.getTotal());
        blueSkyPage.setData(page.getResult());
        return blueSkyPage;
    }

    public TMember insert(String name, Integer age) {
        TMember tMember = new TMember();
        tMember.setUsername(name);
        tMember.setAge(age);
        tMemberWriteMapper.insertSelective(tMember);
        return tMember;
    }

    public List<TMember> getListByCache() {
        return null;
    }
}
