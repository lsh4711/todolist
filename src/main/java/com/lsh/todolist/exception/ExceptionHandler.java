package com.lsh.todolist.exception;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	// @org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity ExceptionHandler(HttpMessageNotReadableException e) {
		// Map<String, String> map = e.getBindingResult().getAllErrors().stream()
		// 		.collect(Collectors.toMap(
		// 				error ->((FieldError)error).getField(),
		// 				error -> error.getDefaultMessage())
		// 		);
		// return ResponseEntity.badRequest().body(map);
		return null;
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity methodArgumentNotValidExceptionHandler(
			MethodArgumentNotValidException e) {
		Map<String, String> map = e.getBindingResult().getAllErrors().stream()
				.collect(Collectors.toMap(
						error ->((FieldError)error).getField(),
						error -> error.getDefaultMessage())
				);
		return ResponseEntity.badRequest().body(map);
	}

}
