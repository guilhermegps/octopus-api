package com.project.octopus.core.controllers.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.octopus.core.domain.base.BaseDto;
import com.project.octopus.core.domain.base.BaseEntity;
import com.project.octopus.core.services.base.BaseCRUDService;

@RestControllerAdvice
public abstract class BaseCRUDController<E extends BaseEntity, D extends BaseDto> extends BaseController<E, D> {

	@Override
	protected abstract BaseCRUDService<E, D> getService();
	
	protected ResponseEntity<D> create(D input){
		  var entity = getService().create(input);
		  
	    return ResponseEntity.ok(getService().convert(entity));
	}

	protected ResponseEntity<String> update(Long code, D input) {
		getService().update(code, input);

	    return getSucess();
	}

	protected ResponseEntity<String> disable(Long code) {
		getService().disable(code);

	    return getSucess();
	}

	protected ResponseEntity<String> remove(Long code) {
		getService().remove(code);

	    return getSucess();
	}
	
}
