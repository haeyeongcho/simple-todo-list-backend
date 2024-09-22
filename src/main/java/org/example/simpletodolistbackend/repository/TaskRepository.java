package org.example.simpletodolistbackend.repository;

import org.example.simpletodolistbackend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
