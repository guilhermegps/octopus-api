package com.project.octopus.application.configs;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MessageSourceResourceBundleLocator;

import com.project.octopus.core.commons.support.validation.CustomMessageInterpolator;

@Configuration
public class MessageSourceConfig {

	@Bean
	MessageSource messageSource() {
		var source = new ResourceBundleMessageSource();
		source.setBasenames("messages/messages", "messages/validation-messages");
		source.setDefaultEncoding("UTF-8");
		source.setUseCodeAsDefaultMessage(false);

		return source;
	}
	
	@Bean
    LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource);
        validator.setMessageInterpolator(new CustomMessageInterpolator(new ResourceBundleMessageInterpolator(new MessageSourceResourceBundleLocator(messageSource))));
        return validator;
    }

}