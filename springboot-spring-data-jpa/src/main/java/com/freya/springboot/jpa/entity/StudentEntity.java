package com.freya.springboot.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/18 14:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity(name = "student")
public class StudentEntity {
	@Id
	@GeneratedValue
	@Column(name = "id", length = 32)
	private Long id;
	@Column(length = 50)
	private String name;
	@Column(length = 3)
	private Integer age;

}
