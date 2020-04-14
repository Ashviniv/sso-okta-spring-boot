package com.demo.repository;

import com.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<com.demo.models.User, Integer> {
    User findByEmail(final String email);
}

