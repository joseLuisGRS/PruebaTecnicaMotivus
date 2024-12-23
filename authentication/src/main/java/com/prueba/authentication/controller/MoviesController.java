package com.prueba.authentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MoviesController {

	@GetMapping("")
	public String getMovies() {
		return "movies list";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String getMoviesAdmin() {
		return "movies list ADMIN";
	}
	
	@PreAuthorize("hasRole('SUPER')")
	@GetMapping("/super")
	public String getMoviesSuper() {
		return "movies list SUPER";
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user")
	public String getMoviesUser() {
		return "movies list USER";
	}
}
