package com.lsh.todolist.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lsh.todolist.dto.Dto;
import com.lsh.todolist.entity.Entity;
import com.lsh.todolist.mapper.Mapper;
import com.lsh.todolist.service.Service;


@RestController
@Validated
@CrossOrigin("*")
public class Controller {
	private Service service;
	private Mapper mapper;

	public Controller(Service service, Mapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@PostMapping
	public ResponseEntity post(@RequestBody @Valid Dto.Post postDto) {
		Entity entity = mapper.postDtoToEntity(postDto);
		Entity savedEntity = service.saveTodo(entity);

		return new ResponseEntity<>(savedEntity, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") @Min(1) long id) {
		Entity findEntity = service.findTodo(id);

		return new ResponseEntity<>(findEntity, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity getAll() {
		List<Entity> findEntities = service.findAllTodo();

		return new ResponseEntity<>(findEntities, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity patch(@PathVariable("id") @Min(1) long id,
			@RequestBody @Valid Dto.Patch patchDto) {
		patchDto.setId(id);
		Entity entity = mapper.patchDtoToEntity(patchDto);
		Entity updatedEntity = service.updateTodo(entity);

		return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll(@PathVariable("id") @Min(1) long id) {
		service.deleteTodo(id);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete() {
		service.deleteAllTodo();
	}

}
