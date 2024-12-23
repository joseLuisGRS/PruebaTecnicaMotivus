package com.prueba.authentication.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.prueba.authentication.model.entity.User;

@Repository
public interface IUserRepository {

	Optional<User> findByUserName(String username);
	void save(User user);
}
