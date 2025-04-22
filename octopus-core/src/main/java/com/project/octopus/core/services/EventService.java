package com.project.octopus.core.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.project.octopus.core.commons.support.SessionContext;
import com.project.octopus.core.domain.entity.Event;
import com.project.octopus.core.domain.enumerations.EventTypeEnum;
import com.project.octopus.core.repositories.EventRepository;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Validated
@Service
@RequiredArgsConstructor
public class EventService {

	@Getter
	private final EventRepository repository;
	
	public void register(@NotNull EventTypeEnum typeEnum, String descricao) {
		register(typeEnum, descricao, SessionContext.sessionUser().getIdUser());
	}
	
	public void register(@NotNull EventTypeEnum typeEnum, String description, @NotNull UUID idUser) {
		var event = Event.builder()
				.type(typeEnum.toEntity())
				.description(description)
				.idUser(idUser)
				.dtEvent(LocalDateTime.now())
				.ipUser(getRequestIp())
				.enabled(Boolean.TRUE)
				.build();
		
		repository.save(event);
	}

	public static String getRequestIp() {
		var sra = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes());
		
		if(sra!=null) {
			var request = sra.getRequest();
			var remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (StringUtils.isBlank(remoteAddr))
				remoteAddr = request.getRemoteAddr();
			
			return remoteAddr;
		}
		
		return null;
    }

}
