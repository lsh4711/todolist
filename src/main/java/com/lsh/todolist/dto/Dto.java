package com.lsh.todolist.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class Dto {
	@NotBlank(message = "asdasdads")
	private String title;
	private int todoOrder;
	private boolean completed;
}
