package com.project.octopus.core.repositories.base;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.project.octopus.core.domain.base.BaseEntity;

@Repository
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, UUID>, JpaSpecificationExecutor<E> {

	default Optional<E> findOneByCodeAndEnabled(Long code, Boolean enabled) {
		return this.findOne(
					(root, query, builder) -> builder.and(
									builder.equal(root.get("code"), code), 
									builder.equal(root.get("enabled"), enabled))
			    );
	}

}
