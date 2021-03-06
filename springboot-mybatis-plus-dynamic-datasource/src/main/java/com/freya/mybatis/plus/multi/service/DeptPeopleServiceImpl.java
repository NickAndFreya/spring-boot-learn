package com.freya.mybatis.plus.multi.service;

import com.freya.mybatis.plus.multi.mapper.DeptMapper;
import com.freya.mybatis.plus.multi.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/9 21:27
 */
@Service
public class DeptPeopleServiceImpl implements DeptPeopleService {
	@Autowired
	private DeptMapper deptMapper;

	@Autowired
	private PeopleMapper peopleMapper;


	@Override
	public List<Map<String, Object>> getDeptList() {
		return deptMapper.getDeptList();
	}

	@Override
	public List<Map<String, Object>> getPeopleList() {
		return peopleMapper.getPeopleList();
	}

}
