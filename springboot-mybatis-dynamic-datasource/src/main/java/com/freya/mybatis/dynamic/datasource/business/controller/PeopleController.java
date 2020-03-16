package com.freya.mybatis.dynamic.datasource.business.controller;

import com.freya.mybatis.dynamic.datasource.business.dto.PeopleDto;
import com.freya.mybatis.dynamic.datasource.business.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 14:57
 */
@RestController
@RequestMapping("people")
public class PeopleController {
	@Autowired
	private PeopleService service;

	@GetMapping("list")
	public List<PeopleDto> getPeopleList() {
		return service.getPeopleList();
	}
}
