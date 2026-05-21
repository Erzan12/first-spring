package com.erzan.first_spring.repository;

import com.erzan.first_spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
