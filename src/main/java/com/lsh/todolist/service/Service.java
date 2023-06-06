package com.lsh.todolist.service;

import com.lsh.todolist.entity.Entity;
import com.lsh.todolist.repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	private Repository repository;

	public Service(Repository repository) {
		this.repository = repository;
	}

	public Entity createTodo(Entity entity) {
		return repository.save(entity);
	}
}
