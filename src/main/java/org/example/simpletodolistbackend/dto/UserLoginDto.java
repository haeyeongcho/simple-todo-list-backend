package org.example.simpletodolistbackend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginDto {
    private String email;
    private String password;
}