package com.project.octopus.core.services.base;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.project.octopus.core.domain.base.BaseDto;
import com.project.octopus.core.domain.base.BaseEntity;

import jakarta.validation.constraints.NotNull;

@Validated
@Component
public abstract class BaseCRUDService<E extends BaseEntity, D extends BaseDto> extends BaseService<E, D> {

    public ValidationInterface<D> validation() { return null; }

	@Transactional
	public E create(@NotNull D input) {
		if (Objects.nonNull(validation()))
			validation().create(input);

		var entity = getMapper().convert(input);
		entity.setId(null);
		entity.setEnabled(Boolean.TRUE);

		return getRepository().save(entity);
	}

	@Transactional
	public E update(@NotNull Long code, @NotNull D input){
		if (Objects.nonNull(validation()))
			validation().update(code, input);

		var entity = findByCode(code);
		
		var upEntity = getMapper().convert(input);
		BeanUtils.copyProperties(upEntity, entity, "id", "code", "enabled" );
		
		return getRepository().save(entity);
	}

	@Transactional
	public E disable(@NotNull Long code){
		var entity = findByCode(code);
		entity.setEnabled(Boolean.FALSE);
		
		return getRepository().save(entity);
	}

	@Transactional
	public Long remove(@NotNull Long code) {
		var entity = findByCode(code);
		getRepository().delete(entity);

		return code;
	}

}
