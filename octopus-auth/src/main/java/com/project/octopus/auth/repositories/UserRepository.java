package com.project.octopus.auth.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.project.octopus.auth.domain.entity.UserApp;
import com.project.octopus.core.repositories.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<UserApp> {

	Optional<UserApp> findOneByUsernameAndEnabled(String username, Boolean enabled);

}
