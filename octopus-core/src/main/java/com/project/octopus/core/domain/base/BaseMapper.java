package com.project.octopus.core.domain.base;

import java.util.List;

import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

public interface BaseMapper <E extends BaseEntity, D extends BaseDto> {
	
	D convert(E entity);
	
	@Mapping(target = "code", ignore = true)
	@Mapping(target = "enabled", ignore = true)
	E convert(D dto);

	List<D> convert(List<E> list);

	List<E> convertDTO(List<D> list);
	
	default Page<D> convert(Page<E> pageEntity) { 
		return pageEntity.map(this::convert);
	}

}
