package com.project.octopus.personal.event.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.project.octopus.core.events.personal.CreatePersonEvent;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonEventListener {

	@EventListener
    @Transactional
	public void handleCreatePersonEvent(CreatePersonEvent event) {
		
		var personEvent = event.getRequestData();
		
	}
	
}
