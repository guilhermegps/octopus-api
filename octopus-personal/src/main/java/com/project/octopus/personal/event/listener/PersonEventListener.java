package com.project.octopus.personal.event.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.project.octopus.core.events.personal.CreatePersonEvent;
import com.project.octopus.core.events.personal.UpdatePersonEvent;
import com.project.octopus.personal.services.PersonService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonEventListener {
	
	private final PersonService service;

	@EventListener
    @Transactional
	public void handleEvent(CreatePersonEvent event) {
		var personEvent = event.getRequestData();
		
		var dto = service.getMapper().convert(personEvent);
		var entity = service.create(dto);
		
		event.setResponseData(entity.getId());
	}

	@EventListener
    @Transactional
	public void handleEvent(UpdatePersonEvent event) {
		var personEvent = event.getRequestData();
		
		var dto = service.getMapper().convert(personEvent);
		var entity = service.update(null, null);
		
		event.setResponseData(Boolean.TRUE);
	}
	
}
