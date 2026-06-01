package com.example.AuthService.Repository;

import com.example.AuthService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

  public User findByUsername(String username);
}
