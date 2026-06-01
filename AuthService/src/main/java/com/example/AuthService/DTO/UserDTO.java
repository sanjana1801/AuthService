package com.example.AuthService.DTO;

public class UserDTO {

  public record RegisterRequest(String username, String password, String role) {
  }

  public record LoginRequest(String username, String password) {
  }

}
