package org.example.simpletodolistbackend.controller;

import org.example.simpletodolistbackend.dto.UserLoginDto;
import org.example.simpletodolistbackend.dto.UserResponseDto;
import org.example.simpletodolistbackend.dto.UserSignupDto;
import org.example.simpletodolistbackend.entity.User;
import org.example.simpletodolistbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 유저 회원가입 API
     *
     * @param userSignupDto
     * @return 회원가입 성공 시 이메일 정보와 함께 응답
     */
    @PostMapping("/signup") // 회원가입 요청 처리
    public ResponseEntity<UserResponseDto> signup(@RequestBody UserSignupDto userSignupDto) {
        User user = userService.register(userSignupDto);
        UserResponseDto userResponseDto = new UserResponseDto(user.getEmail());
        return ResponseEntity.status(201).body(userResponseDto);
    }

    /**
     * 유저 로그인 API
     *
     * @param userLoginDto
     * @return 로그인 성공 시 이메일 정보와 함께 응답
     */
    @PostMapping("/login") // 로그인 요청 처리
    public ResponseEntity<UserResponseDto> login(@RequestBody UserLoginDto userLoginDto) {
        User user = userService.login(userLoginDto);
        UserResponseDto userResponseDto = new UserResponseDto(user.getEmail());
        return ResponseEntity.ok(userResponseDto);
    }
}
