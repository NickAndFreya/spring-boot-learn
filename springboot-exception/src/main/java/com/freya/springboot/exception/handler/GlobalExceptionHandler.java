package com.freya.springboot.exception.handler;

import com.freya.springboot.exception.exception.ErrorMessage;
import com.freya.springboot.exception.exception.IllegalPropertiesException;
import com.freya.springboot.exception.exception.NullOrEmptyException;
import com.freya.springboot.exception.exception.SessionNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 11:03
 */
@RestControllerAdvice(basePackages = "com.freya.springboot.exception.controller")
public class GlobalExceptionHandler {
	@ExceptionHandler(SessionNotFoundException.class)
	public ErrorMessage<String> sessionNotFoundExceptionHandler(HttpServletRequest request, SessionNotFoundException exception) throws Exception {
		return handleErrorInfo(request, exception.getMessage(), exception);
	}

	@ExceptionHandler(NullOrEmptyException.class)
	public ErrorMessage<String> nullOrEmptyExceptionHandler(HttpServletRequest request, NullOrEmptyException exception) throws Exception {
		return handleErrorInfo(request, exception.getMessage(), exception);
	}

	@ExceptionHandler(IllegalPropertiesException.class)
	public ErrorMessage<String> illegalPropExceptionHandler(HttpServletRequest request, IllegalPropertiesException exception) throws Exception {
		return handleErrorInfo(request, exception.getMessage(), exception);
	}

	@ExceptionHandler(Exception.class)
	public ErrorMessage<String> exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		return handleErrorInfo(request, exception.getMessage(), exception);
	}

	private ErrorMessage<String> handleErrorInfo(HttpServletRequest request, String message, Exception exception) {
		ErrorMessage<String> errorMessage = new ErrorMessage<>();
		errorMessage.setMessage(message);
		errorMessage.setCode(ErrorMessage.ERROR);
		errorMessage.setData(message);
		errorMessage.setUrl(request.getRequestURL().toString());
		return errorMessage;
	}
}
