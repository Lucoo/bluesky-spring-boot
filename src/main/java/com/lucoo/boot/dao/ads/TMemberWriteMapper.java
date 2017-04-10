package com.lucoo.boot.dao.ads;

import com.lucoo.boot.common.mapper.CommonMapperDao;
import com.lucoo.boot.entity.TMember;

import java.util.List;

public interface TMemberWriteMapper extends CommonMapperDao<TMember> {
    void batchInsertRecord(List<TMember> list);
}