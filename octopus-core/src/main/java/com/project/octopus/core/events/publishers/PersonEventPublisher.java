package com.project.octopus.core.events.publishers;

import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.project.octopus.core.domain.dtos.event.PersonEvent;
import com.project.octopus.core.events.personal.CreatePersonEvent;
import com.project.octopus.core.events.personal.UpdatePersonEvent;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Validated
@Component
@RequiredArgsConstructor
public class PersonEventPublisher {

	private final ApplicationEventPublisher eventPublisher;

	@Transactional
	public UUID createPerson(@Valid PersonEvent personEvent) {
		var event = new CreatePersonEvent(this, personEvent);
		eventPublisher.publishEvent(event);
		
		return event.getResponseData();
	}

	@Transactional
	public Boolean updatePerson(@NotNull UUID id, @Valid PersonEvent personEvent) {
		var event = new UpdatePersonEvent(this, id, personEvent);
		eventPublisher.publishEvent(event);
		
		return event.getResponseData();
	}

}
