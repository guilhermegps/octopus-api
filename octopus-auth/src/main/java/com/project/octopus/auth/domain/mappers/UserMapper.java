package com.project.octopus.auth.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.octopus.auth.domain.dtos.UserDto;
import com.project.octopus.auth.domain.entity.UserApp;
import com.project.octopus.core.domain.base.BaseMapper;
import com.project.octopus.core.domain.dtos.event.PersonEvent;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserApp, UserDto> {
	
	@Mapping(target = "password", ignore = true)
	@Mapping(target = "profile", expression = "java( ProfileEnum.valueOf(entity.getProfile().getId()))")
	UserDto convert(UserApp entity);

	PersonEvent convertToEvent(UserDto dto);
}
