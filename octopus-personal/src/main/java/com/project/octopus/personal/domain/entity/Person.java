package com.project.octopus.personal.domain.entity;

import java.time.LocalDate;

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
@Table(schema = "PERSONAL")
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity {
	
	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 11, nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private LocalDate dtBirth;

	@Column
	private Character sex;
	
	@Column(length = 50, nullable = false)
	private String email;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_address")
//	private Address address;

}
