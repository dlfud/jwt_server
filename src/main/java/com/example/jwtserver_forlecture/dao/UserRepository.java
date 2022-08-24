package com.example.jwtserver_forlecture.dao;

import com.example.jwtserver_forlecture.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
