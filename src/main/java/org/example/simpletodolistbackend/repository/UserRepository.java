package org.example.simpletodolistbackend.repository;

import org.example.simpletodolistbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
