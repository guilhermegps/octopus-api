package com.project.octopus.test.controllers;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@ActiveProfiles("test")
@WebMvcTest
public abstract class BaseTestController {
	
    @Autowired
    protected MockMvc mockMvc;
    protected ObjectMapper objectMapper = JsonMapper.builder()
												.addModule(new JavaTimeModule())
    											.disable(MapperFeature.USE_ANNOTATIONS)
    											.defaultDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
    											.serializationInclusion(Include.NON_NULL)
    											.build();
    public abstract String getUrl();
    
    protected MockHttpServletRequestBuilder reqStandardHeaders(MockHttpServletRequestBuilder reqBuilder) {
    	return reqBuilder
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

}
