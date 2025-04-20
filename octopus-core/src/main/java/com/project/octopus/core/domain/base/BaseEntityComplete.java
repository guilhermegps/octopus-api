package com.project.octopus.core.domain.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntityComplete extends BaseEntity {

	@Column(nullable = false, insertable = false, updatable = false, columnDefinition="serial", unique = true)
	protected Long codigo;

}
