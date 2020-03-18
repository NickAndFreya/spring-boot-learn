package com.freya.springboot.jpa.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/18 14:43
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
	private int code;
	private String message;
	private T data;
}
