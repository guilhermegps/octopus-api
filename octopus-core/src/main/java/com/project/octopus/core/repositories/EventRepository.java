package com.project.octopus.core.repositories;

import org.springframework.stereotype.Repository;

import com.project.octopus.core.domain.entity.Event;
import com.project.octopus.core.repositories.base.BaseRepository;

@Repository
public interface EventRepository extends BaseRepository<Event> {

}
