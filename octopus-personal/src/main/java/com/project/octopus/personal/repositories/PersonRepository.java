package com.project.octopus.personal.repositories;

import org.springframework.stereotype.Repository;

import com.project.octopus.core.repositories.base.BaseRepository;
import com.project.octopus.personal.domain.entity.Person;

@Repository
public interface PersonRepository extends BaseRepository<Person> {

}
