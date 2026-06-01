package com.example.AuthService.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

  private final String SECRET = "my-secret-key-my-secret-key-my-secret-key";

  public String generateJwtToken(String username) {

    return Jwts.builder()
        .subject(username)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 3600000))
        .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
        .compact();
  }
}
