package com.project.octopus.personal.event.listener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.octopus.core.domain.dtos.event.PersonEvent;
import com.project.octopus.core.events.personal.CreatePersonEvent;
import com.project.octopus.core.events.publishers.PersonEventPublisher;
import com.project.octopus.personal.domain.dtos.PersonDto;
import com.project.octopus.personal.domain.entity.Person;
import com.project.octopus.personal.domain.mappers.PersonMapper;
import com.project.octopus.personal.services.PersonService;

@ExtendWith(MockitoExtension.class)
class PersonEventListenerTest {
    @Mock
	private PersonMapper mapper;
    @Mock
    private PersonService service;
    @Mock
    private PersonEventPublisher source;

    @InjectMocks
    private PersonEventListener listener;
    
    @BeforeEach
    private void beforeEach() {
        when(service.getMapper()).thenReturn(mapper);
    }

    @Test
    void handleEvent_create_returnPersonId() {
        // given
    	var name = "Richard";
    	var dto = PersonDto.builder()
    			.name(name)
    			.build();
    	var expected = UUID.randomUUID();
        var event = new CreatePersonEvent(source, new PersonEvent());

        // when
        when(mapper.convert(any(PersonEvent.class))).thenReturn(dto);
        when(service.create(dto)).thenReturn(new Person(expected));
        listener.handleEvent(event);

        // then
        verify(service).create(argThat(input -> name.equals(input.getName())));
        assertEquals(expected, event.getResponseData());
    }

}
