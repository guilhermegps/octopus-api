package com.project.octopus.personal.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.octopus.core.domain.base.BaseMapper;
import com.project.octopus.core.domain.dtos.event.PersonEvent;
import com.project.octopus.personal.domain.dtos.PersonDto;
import com.project.octopus.personal.domain.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper extends BaseMapper<Person, PersonDto> {
	
	@Mapping(target = "code", ignore = true)
	@Mapping(target = "enabled", ignore = true)
	PersonDto convert(PersonEvent eventData);

}
