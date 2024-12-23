package com.prueba.authentication.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.prueba.authentication.model.dto.UserInfoDto;
import com.prueba.authentication.model.entity.User;
import com.prueba.authentication.repository.IUserRepository;

@Component
public class UserRepositoryImpl implements IUserRepository {

	private List<User> users = new ArrayList<>();
	
	public UserRepositoryImpl() {
		PasswordEncoder encoder =  new BCryptPasswordEncoder();
		UserInfoDto info1 = new UserInfoDto("Mexico", "pedro@gmail.com");
		User user1 = new User(1, "pedro", "ROLE_ADMIN" , encoder.encode("password"), info1, 1);
		UserInfoDto info2 = new UserInfoDto("Mexico", "pablo@gmail.com");
		User user2 = new User(1, "pablo", "ROLE_USER" , encoder.encode("password"), info2, 1);
		UserInfoDto info3 = new UserInfoDto("Mexico", "juan@gmail.com");
		User user3 = new User(1, "juan", "ROLE_SUPER" , encoder.encode("password"), info3, 1);
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}
	
	@Override
	public Optional<User> findByUserName(String username) {
		 return users.stream()
	                .filter(user -> user.getUserName().equals(username))
	                .findFirst();
	}

	@Override
	public void save(User user) {
		users.add(user);
	}

}
