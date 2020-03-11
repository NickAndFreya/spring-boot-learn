package com.freya.springboothikaricp.service;

import com.freya.springboothikaricp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/11 14:43
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;

	@Override
	public List<Map<String, String>> getUserList() {
		return mapper.getUserList();
	}
}
