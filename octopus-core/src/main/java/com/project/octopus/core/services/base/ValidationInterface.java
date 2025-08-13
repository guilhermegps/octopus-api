package com.project.octopus.core.services.base;


public interface ValidationInterface<D> {
	
	default void create(D dto) {}

    default void update(Long code, D dto) {}

}
