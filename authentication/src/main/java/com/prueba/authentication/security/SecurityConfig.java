package com.prueba.authentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.prueba.authentication.services.UserInfoService;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

	private JwtAuthFilter authFilter;
	
	public SecurityConfig (JwtAuthFilter authFilter) {
		this.authFilter = authFilter;
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserInfoService();
	}

	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(customizer ->
				customizer.requestMatchers(antMatcher("/auth/**")).permitAll()
			    .anyRequest().authenticated());
		http.csrf(csfr -> csfr.disable());
		http.sessionManagement(customaizer ->
		customaizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.authenticationProvider(authenticationProvider());
		http.addFilterBefore(this.authFilter, UsernamePasswordAuthenticationFilter.class);;
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = 
				new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(this.userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
}
