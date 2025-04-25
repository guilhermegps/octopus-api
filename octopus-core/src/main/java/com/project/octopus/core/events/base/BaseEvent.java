package com.project.octopus.core.events.base;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseEvent<T, E> extends ApplicationEvent {
	
	private static final long serialVersionUID = 6015375565995867207L;
	
	private final T requestData;
    private E responseData;    

    protected BaseEvent(Object source, T requestData) {
        super(source);
        this.requestData = requestData;
    }
}
