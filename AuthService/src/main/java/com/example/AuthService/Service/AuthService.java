package com.example.AuthService.Service;

import com.example.AuthService.DTO.UserDTO.LoginRequest;
import com.example.AuthService.DTO.UserDTO.RegisterRequest;
import com.example.AuthService.Entity.User;
import com.example.AuthService.Repository.UserRepository;
import com.example.AuthService.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtUtil jwtUtil;

  public String registerUser(RegisterRequest request) {
    User user = new User();
    user.setUsername(request.username());
    user.setPassword(passwordEncoder.encode(request.password()));
    user.setRole(request.role());

    userRepository.save(user);

    return "User registered successfully";
  }

  public String login(LoginRequest request) {

    User existingUser = userRepository.findByUsername(request.username());
    if(existingUser == null) {
      return "User not found";
    }

    boolean matches = passwordEncoder.matches(request.password(), existingUser.getPassword());
    if(!matches) {
      return "Wrong password";
    }

    return jwtUtil.generateJwtToken(existingUser.getUsername());
  }

}
