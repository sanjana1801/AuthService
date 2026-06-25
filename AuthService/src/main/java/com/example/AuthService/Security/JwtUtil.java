package com.example.AuthService.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String generateJwtToken(String username) {

    return Jwts.builder()
        .subject(username)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 3600000))
        .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
        .compact();
  }

  public String extractUsername(String token) {

      return Jwts.parser()
              .verifyWith(getKey())
              .build()
              .parseSignedClaims(token)
              .getPayload()
              .getSubject();
  }

  public boolean validateToken(String username, String token) {

      return extractUsername(token).equals(username);
  }

  private SecretKey getKey() {

      return Keys.hmacShaKeyFor(
              secret.getBytes()
      );
  }
}
