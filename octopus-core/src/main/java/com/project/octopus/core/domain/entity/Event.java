package com.project.octopus.core.domain.entity;

import java.time.LocalDateTime;
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
@Table(schema = "APP")
@AllArgsConstructor
@NoArgsConstructor
public class Event extends BaseEntity {
	
	@Column(nullable = false)
	private String description;

	@Column(name = "ip_user")
	private String ipUser;

	@Column(name = "id_user", nullable = false)
	private UUID idUser;

	@Column(name = "dt_event", nullable = false)
	private LocalDateTime dtEvent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_evento", nullable = false)
	private EventType type;
	

}
