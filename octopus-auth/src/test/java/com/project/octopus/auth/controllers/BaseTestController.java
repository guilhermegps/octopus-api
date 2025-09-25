package com.project.octopus.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.project.octopus.core.domain.base.BaseDto;
import com.project.octopus.core.domain.base.BaseEntity;

public abstract class BaseTestController<E extends BaseEntity, D extends BaseDto> {
	
    @Autowired
    protected MockMvc mockMvc;
    protected ObjectMapper objectMapper = JsonMapper.builder().disable(MapperFeature.USE_ANNOTATIONS).build();
    
    public abstract String getUrl();
    
    protected MockHttpServletRequestBuilder reqStandardHeaders(MockHttpServletRequestBuilder reqBuilder) {
    	return reqBuilder
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }
    
    protected MockHttpServletRequestBuilder reqDetail(Long id) {
    	return reqStandardHeaders( MockMvcRequestBuilders.get(getUrl().concat("/{id}"), id) );
    }
    
    protected MockHttpServletRequestBuilder reqCreate(Object content) throws JsonProcessingException {
    	return reqStandardHeaders( MockMvcRequestBuilders
    			.post(getUrl())
    			.content(objectMapper.writeValueAsString(content)) );
    }

}
