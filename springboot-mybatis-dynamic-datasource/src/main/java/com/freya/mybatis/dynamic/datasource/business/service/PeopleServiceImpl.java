package com.freya.mybatis.dynamic.datasource.business.service;

import com.freya.mybatis.dynamic.datasource.annotation.DS;
import com.freya.mybatis.dynamic.datasource.business.dto.PeopleDto;
import com.freya.mybatis.dynamic.datasource.business.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 15:13
 */
@Service
public class PeopleServiceImpl implements PeopleService {
	@Autowired
	private PeopleMapper mapper;

	@DS("db-slave")
	@Override
	public List<PeopleDto> getPeopleList() {
		return mapper.getPeopleList();
	}

	@DS("db-slave")
	@Override
	public PeopleDto save(PeopleDto dto) {
		mapper.save(dto);
		return dto;
	}
}
