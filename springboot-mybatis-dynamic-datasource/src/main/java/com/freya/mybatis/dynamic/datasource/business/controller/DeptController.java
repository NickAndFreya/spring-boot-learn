package com.freya.mybatis.dynamic.datasource.business.controller;

import com.freya.mybatis.dynamic.datasource.business.dto.DeptDto;
import com.freya.mybatis.dynamic.datasource.business.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 14:56
 */
@RestController
@RequestMapping("dept")
public class DeptController {
	@Autowired
	private DeptService service;


	@GetMapping("list")
	public List<DeptDto> getDeptList() {
		return service.getDeptList();
	}
}
