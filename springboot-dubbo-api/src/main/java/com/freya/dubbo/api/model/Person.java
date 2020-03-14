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
 * @date 2020/3/14 16:56
 */
@Accessors(chain = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
	private static final long serialVersionUID = 62232038586861883L;

	private Integer id;

	private String behavior;
}
