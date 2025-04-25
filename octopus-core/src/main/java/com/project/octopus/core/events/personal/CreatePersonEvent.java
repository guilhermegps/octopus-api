package com.project.octopus.core.events.personal;

import java.util.UUID;

import com.project.octopus.core.domain.dtos.event.PersonEvent;
import com.project.octopus.core.events.base.BaseEvent;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatePersonEvent extends BaseEvent<PersonEvent, UUID> {
	
    private static final long serialVersionUID = 7914043096187875422L;
    
    public CreatePersonEvent(Object source, PersonEvent requestData) {
        super(source, requestData);
    }
}
