package com.freya.druid.multi.mapper.master;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/9 21:19
 */
@Repository
public interface DeptMapper {
	List<Map<String,Object>> getDeptList();
}
