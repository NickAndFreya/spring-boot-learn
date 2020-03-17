package com.freya.springboot.exception.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @param <T>
 * @author yuanchengpin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage<T> {

	public static final Integer OK = 0;
	public static final Integer ERROR = 100;

	private Integer code;
	private String message;
	private String url;
	private T data;

}
