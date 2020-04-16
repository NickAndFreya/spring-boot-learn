package com.freya.mybatis.dynamic.datasource.business.service;

import com.freya.mybatis.dynamic.datasource.business.dto.PeopleDto;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 14:58
 */
public interface PeopleService {
	List<PeopleDto> getPeopleList();

	PeopleDto save(PeopleDto dto);
}
