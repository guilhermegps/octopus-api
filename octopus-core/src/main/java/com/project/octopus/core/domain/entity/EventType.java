package com.project.octopus.core.domain.entity;

import java.util.UUID;

import com.project.octopus.core.domain.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@Setter
@Entity
@Table(schema = "APP")
@AllArgsConstructor
@NoArgsConstructor
public class EventType extends BaseEntity {

	@Column(length = 50, nullable = false)
	private String description;
	
	public EventType(UUID id) {
		this.id = id;
	}

}
