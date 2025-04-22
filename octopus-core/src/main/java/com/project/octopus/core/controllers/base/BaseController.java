package com.project.octopus.core.controllers.base;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.octopus.core.commons.messages.MessageManager;
import com.project.octopus.core.domain.base.BaseDto;
import com.project.octopus.core.domain.base.BaseEntity;
import com.project.octopus.core.domain.enumerations.EventTypeEnum;
import com.project.octopus.core.services.base.BaseService;

@RestControllerAdvice
public abstract class BaseController<E extends BaseEntity, D extends BaseDto> {
	
	protected abstract BaseService<E, D> getService();
	
	protected MessageManager getMessages() {
		return getService().getMessages();
	}
	
	public ResponseEntity<D> toDetail(Long code){
		var entity = getService().findByCode(code);
		
		return toResponse(entity);
	}
	
	protected ResponseEntity<String> getSucess(){		  
		var msg = getMessages().get("sys.info.success");
		  
	    return ResponseEntity.ok(msg);
	}
	
	protected ResponseEntity<D> toResponse(E entity){
		return toResponse(getService().convert(entity));
	}
	
	protected ResponseEntity<D> toResponse(D dto){
		var response = toResponse(dto, getService().getDtoClass());
		
		eventIn(EventTypeEnum.VIEW, "log.alert.record_details", getService().getEntityName(), dto.getCode());
		return response;
	}
	
	protected <T> ResponseEntity<T> toResponse(T obj, Class<T> clazz){
		return Optional.ofNullable(obj).map(ResponseEntity::ok).orElseThrow(NoSuchElementException::new);
	}
	
	protected ResponseEntity<List<D>> toResponse(List<E> list){
		var response = ResponseEntity.ok(getService().convert(list));
		
		eventIn(EventTypeEnum.VIEW, "log.alert.list_records", getService().getEntityName());
		return response;
	}
	
	protected ResponseEntity<Page<D>> toResponse(Page<E> page){
		var response = ResponseEntity.ok(getService().convert(page));
		
		eventIn(EventTypeEnum.VIEW, "log.alert.list_records", getService().getEntityName());
		return response;
	}
	
	protected void eventIn(EventTypeEnum type, String keyMsg, Object... params) {
		getService().eventIn(type, getMessages().get(keyMsg, params));
	}
}
