package com.project.octopus.core.controllers.base;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.octopus.core.domain.base.BaseDto;
import com.project.octopus.core.domain.base.BaseEntity;
import com.project.octopus.core.services.base.BaseService;

@RestControllerAdvice
public abstract class BaseController<E extends BaseEntity, D extends BaseDto> {
	
	protected abstract BaseService<E, D> getService();
	
//	protected MessageManager getMessages() {
//		return getService().getMessages();
//	}
	
	public ResponseEntity<D> detail(Long code){
		var entity = getService().findByCode(code);
		
		return toResponse(entity);
	}
	
	protected ResponseEntity<String> getSucess(){		  
//		var msg = getMessages().get("sys.info.sucess");
		var msg = "";
		  
	    return ResponseEntity.ok(msg);
	}
	
	protected ResponseEntity<D> toResponse(E entity){
		return toResponse(getService().convert(entity));
	}
	
	protected ResponseEntity<D> toResponse(D dto){
		var response = Optional.ofNullable(dto).map(ResponseEntity::ok).orElseThrow(NoSuchElementException::new);
		
//		regEvento(TipoEventoEnum.VISUALIZACAO, "log.alert.registro", getService().getEntityName(), dto.getcode());
		return response;
	}
	
	protected ResponseEntity<List<D>> toResponse(List<E> list){
		var response = ResponseEntity.ok(getService().convert(list));
		
//		regEvento(TipoEventoEnum.VISUALIZACAO, "log.alert.listgem", getService().getEntityName());
		return response;
	}
	
	protected ResponseEntity<Page<D>> toResponse(Page<E> page){
		var response = ResponseEntity.ok(getService().convert(page));
		
//		regEvento(TipoEventoEnum.VISUALIZACAO, "log.alert.listgem", getService().getEntityName());
		return response;
	}
	
//	protected void regEvento(TipoEventoEnum tipo, String keyMsg, Object... params) {
//		getService().regEvento(tipo, getMessages().get(keyMsg, params));
//	}
}
