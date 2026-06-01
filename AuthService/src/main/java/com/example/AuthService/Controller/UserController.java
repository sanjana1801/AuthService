package com.example.AuthService.Controller;

import com.example.AuthService.DTO.UserDTO.LoginRequest;
import com.example.AuthService.DTO.UserDTO.RegisterRequest;
import com.example.AuthService.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class UserController {

  private final AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

    return ResponseEntity.ok(authService.registerUser(request));
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginRequest request) {

    return ResponseEntity.ok(authService.login(request));
  }
}
