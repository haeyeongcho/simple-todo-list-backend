package org.example.simpletodolistbackend.controller;

import org.example.simpletodolistbackend.dto.TaskDto;
import org.example.simpletodolistbackend.entity.Task;
import org.example.simpletodolistbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    final private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // 작업 추가
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.addTask(taskDto));
    }

    // 특정 유저의 작업 목록 조회
    @GetMapping("/{userId}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.getTasksByUser(userId));
    }

    // 특정 작업 수정
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        taskDto.setTaskId(taskId); // taskId 설정
        return ResponseEntity.ok(taskService.updateTask(taskDto));
    }

    // 특정 작업 삭제
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build(); // 삭제 후 204 상태 반환
        }
}