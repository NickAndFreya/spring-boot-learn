package com.freya.mybatis.plus.multi.mapper;


import java.util.List;
import java.util.Map;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/9 21:19
 */
public interface DeptMapper {
	List<Map<String,Object>> getDeptList();
}
