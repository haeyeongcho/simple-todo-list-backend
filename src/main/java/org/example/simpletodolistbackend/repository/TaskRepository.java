package org.example.simpletodolistbackend.repository;

import org.example.simpletodolistbackend.entity.Task;
import org.example.simpletodolistbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
