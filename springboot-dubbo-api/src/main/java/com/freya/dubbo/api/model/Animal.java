package com.freya.dubbo.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/14 21:59
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Animal implements Serializable {
	private static final long serialVersionUID = 4878025500697692487L;

	private Integer id;

	private String name;
}
