package com.project.octopus.personal.domain.entity;

import java.util.UUID;

import com.project.octopus.core.domain.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(schema = "PERSONAL")
@AllArgsConstructor
@NoArgsConstructor
public class Phone extends BaseEntity {

	@Column(length = 30, nullable = false)
	private String number;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person person;

	public Phone(UUID id) {
		this.id = id;
	}

}
