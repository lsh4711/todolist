package com.lsh.todolist.mapper;

import com.lsh.todolist.dto.Dto;
import com.lsh.todolist.entity.Entity;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
	Entity dtoToEntity(Dto dto);
}
