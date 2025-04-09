package com.sparta.gitflow.project.user.service;

import com.sparta.gitflow.project.user.dto.request.UserSaveRequestDto;
import com.sparta.gitflow.project.user.dto.response.UserResponseDto;
import com.sparta.gitflow.project.user.entity.User;
import com.sparta.gitflow.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto save(UserSaveRequestDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("해당 이메일은 이미 사용중입니다.");
        }

        User user = new User(dto.getUserName(), dto.getEmail(), dto.getPassword());
        userRepository.save(user);
        return new UserResponseDto(user);
    }
}
