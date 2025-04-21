package com.project.octopus.core.domain.enumerations;

import java.util.List;
import java.util.UUID;

import com.project.octopus.core.domain.entity.EventType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventTypeEnum {
	INCLUSION(UUID.fromString("359478a8-f1f6-486e-bdc2-504bbead5fbc"), 1L, "Record inclusion"),
	UPDATE(UUID.fromString("e2f4f40c-0340-4404-ad32-1a14692de709"), 2L, "Record update"),
	DISABLING(UUID.fromString("d3320a32-b803-40f9-ab35-13c29833f214"), 3L, "Record disabling"),
	REMOVAL(UUID.fromString("a6c4efd6-0407-4bfb-9400-dd6618b0b069"), 4L, "Record removal"),
	VIEW(UUID.fromString("ca359094-7080-4d4e-b3b6-fd64f5ca7a71"), 5L, "View"),
	AUTHENTICATION(UUID.fromString("7fc34510-0501-4768-beca-bd9345683a93"), 6L, "Authentication"),
	AUTHENTICATION_FAIL(UUID.fromString("3e2f3d03-42c5-4ae2-a240-114d5b332b4c"), 7L, "Fail during authentication"),
	ACCESS_DENIED(UUID.fromString("eb37a61c-ce15-4b88-87f0-68b75911239f"), 8L, "Access attempt denied"),
	FILE_GENERATED(UUID.fromString("8d8d76b8-b78b-407b-92c9-d5c452713c65"), 9L, "File generated")
	;
	
	private UUID id;
	private Long code;
	private String description;
	
	public EventType toEntity() {
		return new EventType(id);
	}
	
	public static EventTypeEnum valueOf(Long code) {
		return code != null ? List.of(values()).stream().filter(e -> e.getCode().equals(code)).findFirst().orElse(null) : null;
	}
	
	public static EventTypeEnum valueOf(UUID id) {
		return id != null ? List.of(values()).stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null) : null;
	}
}
