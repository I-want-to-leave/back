package com.example.i_want_to_leave.login.repository;

import com.example.i_want_to_leave.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
