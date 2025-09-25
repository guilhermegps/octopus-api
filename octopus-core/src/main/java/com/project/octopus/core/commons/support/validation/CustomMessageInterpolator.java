package com.project.octopus.core.commons.support.validation;

import java.util.Locale;

import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.validation.MessageInterpolator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomMessageInterpolator implements MessageInterpolator {
	
	private final ResourceBundleMessageInterpolator defaultInterpolator;
	
	@Override
	public String interpolate(String messageTemplate, Context context) {
		return interpolate(messageTemplate, context, LocaleContextHolder.getLocale());
	}
	
	@Override
	public String interpolate(String messageTemplate, Context context, Locale locale) {
		String interpolatedMessage = defaultInterpolator.interpolate(messageTemplate, context, locale);

        return interpolatedMessage.replace("{fieldName}", getPropertyName(context))
        		.replace("{value}", context.getValidatedValue().toString());
	}
	
	private String getPropertyName(Context context) {
        if(context instanceof MessageInterpolatorContext mic) {
        	 return mic.getPropertyPath().toString();
        } else if (context.getConstraintDescriptor().getAttributes().containsKey("propertyName")) {
        	return String.valueOf(context.getConstraintDescriptor().getAttributes().get("propertyName"));
        }

        return "unknown";
    }

}
