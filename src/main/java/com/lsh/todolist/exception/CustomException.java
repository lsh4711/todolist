package com.lsh.todolist.exception;

import lombok.Getter;

public class CustomException extends RuntimeException {
	@Getter
	private int status;

	public CustomException(ExceptionCode exceptionCode) {
		super(exceptionCode.getMessage());
		this.status = exceptionCode.getStatus();
	}

}
