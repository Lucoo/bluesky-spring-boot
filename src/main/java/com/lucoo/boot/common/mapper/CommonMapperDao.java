package com.lucoo.boot.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by lucoo on 2016/10/27.
 */
public interface CommonMapperDao<T> extends Mapper<T>, MySqlMapper<T> {
}
