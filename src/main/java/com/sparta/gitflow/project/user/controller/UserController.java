package com.sparta.gitflow.project.user.controller;

import com.sparta.gitflow.project.user.dto.request.UserSaveRequestDto;
import com.sparta.gitflow.project.user.dto.response.UserResponseDto;
import com.sparta.gitflow.project.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/signup")
    public ResponseEntity<UserResponseDto> signup(@Valid @RequestBody UserSaveRequestDto dto) {
        return ResponseEntity.ok(userService.save(dto));
    }
}
