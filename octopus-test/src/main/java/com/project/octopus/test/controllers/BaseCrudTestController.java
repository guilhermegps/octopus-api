package com.project.octopus.test.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.BeanUtils;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.octopus.core.domain.base.BaseDto;
import com.project.octopus.core.domain.base.BaseEntity;
import com.project.octopus.core.services.base.BaseCRUDService;
import com.project.octopus.test.utils.RandomValueUtils;

public abstract class BaseCrudTestController<E extends BaseEntity, D extends BaseDto> extends BaseTestController {

	protected abstract BaseCRUDService<E, D> getService();
    
    @SuppressWarnings("unchecked")
    private Class<E> getEntityClass() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return (Class<E>) parameterizedType.getActualTypeArguments()[0];
    }
    
    protected MockHttpServletRequestBuilder reqDetail(Long id) {
    	return reqStandardHeaders( MockMvcRequestBuilders.get(getUrl().concat("/{id}"), id) );
    }
    
    protected MockHttpServletRequestBuilder reqCreate(Object content) throws JsonProcessingException {
    	return reqStandardHeaders( MockMvcRequestBuilders
    			.post(getUrl())
    			.content(objectMapper.writeValueAsString(content)) );
    }
    
    protected void whenCreate(D input, D expected) throws Exception {
    	var entityClass = getEntityClass();
    	var entity = entityClass.getDeclaredConstructor().newInstance();
    	when(getService().create(any())).thenReturn(entity);
        when(getService().convert(any(entityClass))).thenAnswer(i -> {
        	BeanUtils.copyProperties(input, expected);
    		expected.setCode(RandomValueUtils.randomLong());
    		expected.setEnabled(Boolean.TRUE);
    		
    		return expected;
        });
    }

}
