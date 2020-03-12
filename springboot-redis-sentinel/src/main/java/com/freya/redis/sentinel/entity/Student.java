package com.freya.redis.sentinel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 11:22
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {
	private static final long serialVersionUID = -2522160368682505599L;
	private Long id;
	private String name;
	private Integer age;
	private String email;
	private String address;

}
