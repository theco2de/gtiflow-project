package com.sparta.gitflow.project.user.repository;

import com.sparta.gitflow.project.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
