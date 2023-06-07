package com.lsh.todolist.exception;

import java.util.HashMap;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity methodArgumentNotValidExceptionHandler(
			BindException e) {
		log.error("error: ", e);
		HashMap<String, String> map = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(
				error -> {
					String field = ((FieldError)error).getField();
					String message = error.getDefaultMessage();
					String value = map.putIfAbsent(field, message);
					if (value != null) {
						map.put(field, value + ", " + message);
					}
				}
		);

		// return ResponseEntity.badRequest().body(map);
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity constraintViolationExceptionHander(ConstraintViolationException e) {
		HashMap<String, String> map = new HashMap<>();
		e.getConstraintViolations().forEach(
				error -> {
					String field = error.getPropertyPath().toString();
					field = field.replaceAll(".+(?=(?<=\\.).)", "");
					String message = error.getMessage();
					String value = map.putIfAbsent(field, message);
					if (value != null) {
						map.put(field, value + ", " + message);
					}
				}
		);

		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity customExceptionHandler(CustomException customException) {
		int status = customException.getStatus();
		String message = customException.getMessage();

		return new ResponseEntity<>(message, HttpStatus.valueOf(status));
	}

}
