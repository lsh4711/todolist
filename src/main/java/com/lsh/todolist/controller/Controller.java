package com.lsh.todolist.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsh.todolist.dto.Dto;
import com.lsh.todolist.entity.Entity;
import com.lsh.todolist.mapper.Mapper;
import com.lsh.todolist.service.Service;

@RestController
@Validated
public class Controller {
	private Service service;
	private Mapper mapper;

	public Controller(Service service, Mapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@PostMapping
	public ResponseEntity post(@RequestBody @Valid Dto dto) {
		Entity entity = mapper.dtoToEntity(dto);
		Entity savedEntity = service.createTodo(entity);
		return new ResponseEntity<>(savedEntity, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity get() {
		return null;
	}

	@PatchMapping
	public ResponseEntity patch() {
		return null;
	}

	@DeleteMapping
	public ResponseEntity delete() {
		return null;
	}
}
