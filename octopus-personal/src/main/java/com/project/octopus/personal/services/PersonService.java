package com.project.octopus.personal.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.octopus.core.services.base.BaseCRUDService;
import com.project.octopus.core.services.base.ValidationInterface;
import com.project.octopus.personal.domain.dtos.PersonDto;
import com.project.octopus.personal.domain.entity.Person;
import com.project.octopus.personal.domain.mappers.PersonMapper;
import com.project.octopus.personal.repositories.PersonRepository;

import jakarta.transaction.Transactional;
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
	
	@Override
	public ValidationInterface<PersonDto> validation() {
		return new ValidationInterface<PersonDto>() {
			public void create(PersonDto dto) {
				findEnabledByCpf(dto.getCpf())
						.ifPresent(p -> uniqueFieldEx("cpf"));
			}

		    public void update(Long code, PersonDto dto) {}
		};
	}
    
    private Optional<Person> findEnabledByCpf(String cpf) {
    	return repository.findFirstByCpfAndEnabled(cpf, Boolean.TRUE);
    }

    @Transactional
	public Person update(UUID id, PersonDto dto) {
		var code = findById(id).orElseThrow().getCode();
		
		return update(code, dto);
	}

}
