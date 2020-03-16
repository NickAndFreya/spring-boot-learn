package com.freya.mybatis.dynamic.datasource.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 15:01
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class DeptDto {

	private int deptNo;

	private String deptName;

	private String location;
}
