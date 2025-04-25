package com.project.octopus.auth.domain.entity;

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
@Table(schema = "AUTH")
@AllArgsConstructor
@NoArgsConstructor
public class UserApp extends BaseEntity {
	
	@Column(length = 50, nullable = false)
	private String username;
	
	@Column(length = 60, nullable = false)
	private String password;
	
	@Column(name = "person_id", nullable = false)
	private UUID personId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_id")
	private Profile profile;

}
