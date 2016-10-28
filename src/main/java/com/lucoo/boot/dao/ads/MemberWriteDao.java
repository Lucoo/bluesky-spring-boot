package com.lucoo.boot.dao.ads;

import com.lucoo.boot.common.mapper.CommonMapperDao;
import com.lucoo.boot.entity.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lucoo on 2016/10/27.
 */
@Repository
public interface MemberWriteDao extends CommonMapperDao<Member> {
    void insertXml(@Param("member") Member member);
}
