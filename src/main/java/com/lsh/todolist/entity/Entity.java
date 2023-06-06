package com.lsh.todolist.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@javax.persistence.Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private int todoOrder;
	private boolean completed;
}
