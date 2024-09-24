package org.example.simpletodolistbackend.service;

import org.example.simpletodolistbackend.dto.TaskDto;
import org.example.simpletodolistbackend.entity.Task;
import org.example.simpletodolistbackend.entity.User;
import org.example.simpletodolistbackend.repository.TaskRepository;
import org.example.simpletodolistbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    final private TaskRepository taskRepository;
    final private UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    // 작업 추가 메소드
    public Task addTask(TaskDto taskDto) {
        User user = userRepository.findById(taskDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setIsComplete(taskDto.getIsComplete());
        task.setUser(user);
        return taskRepository.save(task);
    }

    // 특정 유저의 모든 작업 조회 메소드
    public List<Task> getTasksByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));
        return taskRepository.findByUser(user);
    }

    // 작업 업데이트 메소드
    public Task updateTask(TaskDto taskDto) {
        Task task = taskRepository.findById(taskDto.getTaskId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 작업입니다."));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setIsComplete(taskDto.getIsComplete());
        return taskRepository.save(task);
    }

    // 작업 삭제 메소드
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 작업입니다."));
        taskRepository.delete(task);
    }
}