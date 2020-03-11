package com.freya.springboothikaricp.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/11 14:43
 */
public interface UserMapper {
	List<Map<String,String>> getUserList();
}
