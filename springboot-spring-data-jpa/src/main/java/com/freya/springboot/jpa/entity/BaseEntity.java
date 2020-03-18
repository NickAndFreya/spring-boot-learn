package com.freya.springboot.jpa.entity;

import lombok.Data;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/18 16:07
 */
@Data
public abstract class BaseEntity {
	private Integer pageNum;

	private Integer pageSize;


	public void validate() {
		if (pageNum == null || pageNum <= 0) {
			pageNum = 0;
		}
		if (pageSize == null || pageSize < 1) {
			pageSize = 10;
		}
	}

}
