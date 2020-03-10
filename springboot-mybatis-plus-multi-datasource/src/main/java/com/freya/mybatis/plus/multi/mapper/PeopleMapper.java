package com.freya.mybatis.plus.multi.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;

import java.util.List;
import java.util.Map;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/9 21:19
 */
@DS("db1")
public interface PeopleMapper {
	List<Map<String, Object>> getPeopleList();
}
