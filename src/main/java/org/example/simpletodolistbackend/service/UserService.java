package org.example.simpletodolistbackend.service;

import org.example.simpletodolistbackend.dto.UserLoginDto;
import org.example.simpletodolistbackend.dto.UserSignupDto;
import org.example.simpletodolistbackend.entity.User;
import org.example.simpletodolistbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    final private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 유저 회원가입 메소드
     *
     * @param userSignupDto
     * @return 등록된 유저 정보 (비밀번호 제외)
     */
    public User register(UserSignupDto userSignupDto) {
        if (userRepository.findByEmail(userSignupDto.getEmail()).isPresent()) {
            // 이메일 중복 시 409 상태 코드 반환
            throw new ResponseStatusException(HttpStatus.CONFLICT, "이미 사용 중인 이메일입니다.");
        }
        User user = new User();
        user.setEmail(userSignupDto.getEmail());
        user.setPassword(userSignupDto.getPassword()); // 비밀번호 보안 처리 필요
        return userRepository.save(user);
    }


    /**
     * 유저 로그인 메소드
     *
     * @param userLoginDto
     * @return 로그인 성공 시 해당 유저 객체 (비밀번호 제외)
     */
    public User login(UserLoginDto userLoginDto) {
        return userRepository.findByEmail(userLoginDto.getEmail())
                .filter(user -> user.getPassword().equals(userLoginDto.getPassword()))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "잘못된 이메일 또는 비밀번호입니다."
                )); // 로그인 실패 시 401 상태 코드 반환
    }
}
