package com.lsh.todolist.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {
	TEST_EXCEPTION(000, "test"),
	Not_FOUND(404, "등록된 일정이 없습니다"),
	EXISTS(409, "동일한 이름의 일정이 존재합니다");

	private int status;
	private String message;

	ExceptionCode(int status, String message) {
		this.status = status;
		this.message = message;
	}
}
