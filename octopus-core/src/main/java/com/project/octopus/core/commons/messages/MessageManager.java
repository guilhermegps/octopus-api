package com.project.octopus.core.commons.messages;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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

}
