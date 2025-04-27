package com.project.octopus.auth.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.project.octopus.auth.domain.dtos.AccessTokenDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
	
    @Value("${security.jwt.secret-key}")
    private String secretKey;
    @Value("${security.jwt.expiration-time}")
    private Long jwtExpiration;

    public String extractUsername(String token) {
        return isTokenValid(token) ? extractClaim(token, Claims::getSubject) : null;
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token) {
        return StringUtils.isBlank(token) || extractExpiration(token).before(new Date());
    }

    public AccessTokenDto generateToken(UserDetails userDetails) {
    	var token = createToken(new HashMap<>(), userDetails.getUsername());
    	
        return AccessTokenDto.builder()
        		.token(token.compact())
        		.expiresIn(jwtExpiration)
        		.tokenType("Bearer")
        		.build();
    }

    private JwtBuilder createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS256, secretKey);
    }

    public boolean isTokenValid(String token) {
		return !isTokenExpired(token);
    }

    public boolean isValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return StringUtils.isNotBlank(username) && username.equals(userDetails.getUsername()) && isTokenValid(token);
    }
}
