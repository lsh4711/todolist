package com.lsh.todolist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lsh.todolist.entity.Entity;
import com.lsh.todolist.exception.CustomException;
import com.lsh.todolist.exception.ExceptionCode;
import com.lsh.todolist.repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	private Repository repository;

	public Service(Repository repository) {
		this.repository = repository;
	}

	public Entity saveTodo(Entity entity) {
		verifyExistsId(entity.getId());

		return repository.save(entity);
	}

	public Entity findTodo(Long id) {
		Optional<Entity> optionalEntity = repository.findById(id);

		return optionalEntity.orElseThrow(() ->
				new CustomException(ExceptionCode.Not_FOUND)
		);
	}

	public List<Entity> findAllTodo() {
		List<Entity> entities = new ArrayList<>();

		repository.findAll().forEach(entities::add);

		return entities;
	}

	public Entity updateTodo(Entity entity) {
		Entity findEntity = findTodo(entity.getId());

		if (entity.getTitle() != null && !entity.getTitle().equals(findEntity.getTitle())) {
			verifyExistsEmail(entity.getTitle());
		}
		Optional.ofNullable(entity.getTitle()).ifPresent(findEntity::setTitle);
		Optional.ofNullable(entity.getTodoOrder()).ifPresent(findEntity::setTodoOrder);
		Optional.ofNullable(entity.getCompleted()).ifPresent(findEntity::setCompleted);

	  	return repository.save(findEntity);
	}

	public void deleteTodo(long id) {
		repository.deleteById(id);
	}

	public void deleteAllTodo() {
		repository.deleteAll();
	}

	public void verifyExistsId(long id) {
		Entity entity = repository.findById(id);

		if (entity != null) {
			throw new CustomException(ExceptionCode.EXISTS);
		}

	}

	public void verifyExistsEmail(String title) {
		Entity optionalEntity = repository.findByTitle(title);

		if (optionalEntity != null) {
			throw new CustomException(ExceptionCode.EXISTS);
		}

	}

}
