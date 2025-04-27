package com.project.octopus.core.services.base;


public interface ValidationInterface<D> {
	
    public void create(D dto);

    public void update(Long code, D dto);

}
