package org.example.simpletodolistbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto {
    private Long taskId;
    private Long userId;
    private String title;
    private String description;
    private Boolean isComplete;
}
