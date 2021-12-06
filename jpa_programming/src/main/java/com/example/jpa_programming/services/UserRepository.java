package com.example.jpa_programming.services;

import com.example.jpa_programming.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
