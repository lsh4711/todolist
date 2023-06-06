package com.lsh.todolist.repository;

import org.springframework.data.repository.CrudRepository;

import com.lsh.todolist.entity.Entity;

public interface Repository extends CrudRepository<Entity, Long> {

}
