package com.project.octopus.core.commons.messages;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.project.octopus.core.domain.enumerations.ValidationEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@RequiredArgsConstructor
public class MessageManager {
	
    private final MessageSource messageSource;
    @Getter
    @Setter
    private Locale locale = Locale.ENGLISH;
    
    public String get(String key, Object ... arguments) {
    	return messageSource.getMessage(key, arguments, locale);
    }
    
    public String get(String key) {
    	return messageSource.getMessage(key, null, locale);
    }
    
    public String get(String key, List<Object> arguments) {
    	var args = !CollectionUtils.isEmpty(arguments) ? arguments.toArray() : null;
    	return messageSource.getMessage(key, args, locale);
    }
    
    public String get(ObjectError oe) {
    	var params = Arrays.asList(oe.getArguments()).stream()
    			.map(p -> (p instanceof DefaultMessageSourceResolvable dm) ? dm.getCode() : p )
    			.toList();
    	var rejected = (oe instanceof FieldError fe) ? fe.getRejectedValue() : null;
    	var clazz = (rejected!=null) ? rejected.getClass() : oe.getClass();
		var valEnum = ValidationEnum.getBy(oe.getCode(), clazz);
		
		return get(valEnum.getKeyMessage(), params);
    }

}
