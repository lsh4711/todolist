package com.lsh.todolist.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class Response {
	private long id;
	private String title;
	private int todoOrder;
	private boolean completed;
}
