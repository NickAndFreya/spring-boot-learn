package com.freya.druid.multi.service;

import java.util.List;
import java.util.Map;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/9 21:26
 */
public interface TestService {
	List<Map<String, Object>> getDeptList();

	List<Map<String, Object>> getPeopleList();
}
