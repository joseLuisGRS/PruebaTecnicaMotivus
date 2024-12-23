package com.prueba.authentication.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.authentication.model.dto.UserDto;
import com.prueba.authentication.model.entity.User;
import com.prueba.authentication.services.JwtService;
import com.prueba.authentication.services.UserInfoService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private JwtService jwtService;
	private AuthenticationManager authenticationManager;
	private UserInfoService userInfoService;
	
	
	public AuthController(JwtService JwtService, AuthenticationManager authenticationManager, 
			UserInfoService userInfoService , PasswordEncoder encoder) {
		this.jwtService = JwtService;
		this.authenticationManager = authenticationManager;
		this.userInfoService = userInfoService;
	}
	
	@PostMapping("/addNewUser")
	public String addNewUser(@RequestBody UserDto user) {
		return this.userInfoService.addUser(new User(
				user.getUserName(),
				user.getRoles(),
				user.getPassword(),
				user.getUserInfo()
				));
	}
	
	@PostMapping("/generateToken")
	public ResponseEntity<String> authenticateAndGetToken(@RequestBody UserDto authRequest){
		Authentication authentication = this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(),
						authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Bearer ", this.jwtService.generateToken(authRequest.getUserName()));
			return ResponseEntity.ok().headers(responseHeaders).body("");
		} else {
			throw new UsernameNotFoundException("Invalid user request");
		}
	}
	
}
