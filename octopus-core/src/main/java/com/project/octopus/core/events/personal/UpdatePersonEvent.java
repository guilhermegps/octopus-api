package com.project.octopus.core.events.personal;

import java.util.UUID;

import com.project.octopus.core.domain.dtos.event.PersonEvent;
import com.project.octopus.core.events.base.BaseEvent;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatePersonEvent extends BaseEvent<PersonEvent, Boolean> {
	
    private static final long serialVersionUID = 7914043096187875422L;

	private final UUID id;
    
    public UpdatePersonEvent(Object source, UUID id, PersonEvent requestData) {
        super(source, requestData);
        this.id = id;
    }
}
