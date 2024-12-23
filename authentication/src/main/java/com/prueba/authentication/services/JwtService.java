package com.prueba.authentication.services;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

	public static final String SECRET = "ZXN0YSBlcyBwYWxhYnJhIGRlIGxsYXZlIGRlIHNlZ3VyaWRhZCBwYXJhIGxhIGNvbmZpZ3VyYWNpb24gZGUgand0IDEyMyEiIw==";
	private UserInfoService userInfoService;
	
	public JwtService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		List<String> roles = new ArrayList<>();
		UserDetails userDetails = this.userInfoService.loadUserByUsername(userName);
		userDetails.getAuthorities().forEach(user -> roles.add(user.getAuthority()));
		roles.stream().map(SimpleGrantedAuthority::new).toList();
		claims.put("Role", roles);
		return createToken(claims, userName);
	}

	private String createToken(Map<String, Object> claims, String userName) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userName)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	}
	
	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public String extractUserName(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
		return (Claims) Jwts
				.parserBuilder()
				.setSigningKey(getSignKey())
				.build()
				.parse(token)
				.getBody();
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String userName = extractUserName(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
}
