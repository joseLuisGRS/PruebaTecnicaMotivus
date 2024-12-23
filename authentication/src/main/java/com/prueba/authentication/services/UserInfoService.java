package com.prueba.authentication.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.prueba.authentication.model.entity.User;
import com.prueba.authentication.repository.IUserRepository;

@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userDetail = this.userRepository.findByUserName(username);		
		return userDetail.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
	}
	 
	public String addUser(User userInfo) {
		userInfo.setPassword(this.encoder.encode(userInfo.getPassword()));
		this.userRepository.save(userInfo);
		return "User added Successfully";
	}
	
}
