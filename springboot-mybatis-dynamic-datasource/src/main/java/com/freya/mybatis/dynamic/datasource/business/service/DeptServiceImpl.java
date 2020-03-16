package com.freya.mybatis.dynamic.datasource.business.service;

import com.freya.mybatis.dynamic.datasource.annotation.DS;
import com.freya.mybatis.dynamic.datasource.business.dto.DeptDto;
import com.freya.mybatis.dynamic.datasource.business.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 15:13
 */
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper mapper;

	@DS
	@Override
	public List<DeptDto> getDeptList() {
		return mapper.getDeptList();
	}
}
