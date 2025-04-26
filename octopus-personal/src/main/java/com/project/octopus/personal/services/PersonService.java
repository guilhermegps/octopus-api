package com.project.octopus.personal.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.octopus.core.services.base.BaseCRUDService;
import com.project.octopus.personal.domain.dtos.PersonDto;
import com.project.octopus.personal.domain.entity.Person;
import com.project.octopus.personal.domain.mappers.PersonMapper;
import com.project.octopus.personal.repositories.PersonRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Validated
@Service
@RequiredArgsConstructor
public class PersonService extends BaseCRUDService<Person, PersonDto> {
	
	@Getter
	private final PersonRepository repository;
	@Getter
	private final PersonMapper mapper;
	@Getter
	private String entityName = "Person";

}
