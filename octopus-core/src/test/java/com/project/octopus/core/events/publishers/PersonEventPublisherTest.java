package com.project.octopus.core.events.publishers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import com.project.octopus.core.domain.dtos.event.PersonEvent;
import com.project.octopus.core.events.personal.CreatePersonEvent;

@ExtendWith(MockitoExtension.class)
class PersonEventPublisherTest {

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private PersonEventPublisher personPublisher;
    
    @Test
    void createPerson_returnId() {
        // given
    	var name = "Richard";
    	var expected = UUID.randomUUID();
        var person = PersonEvent.builder()
        				.name(name)
        				.build();

        // when
        doAnswer(i -> {
        	((CreatePersonEvent) i.getArgument(0)).setResponseData(expected);
        	
        	return i;
        }).when(eventPublisher).publishEvent(any(CreatePersonEvent.class));
        UUID result = personPublisher.createPerson(person);

        // then
        verify(eventPublisher).publishEvent(argThat(event -> 
            event instanceof CreatePersonEvent 
            && name.equals(((CreatePersonEvent) event).getRequestData().getName())
        ));
        assertEquals(expected, result);
    }

}
