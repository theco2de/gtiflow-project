package com.sparta.gitflow.project.schedule.controller;

import com.sparta.gitflow.project.schedule.dto.request.ScheduleSaveRequestDto;
import com.sparta.gitflow.project.schedule.dto.response.ScheduleSaveResponseDto;
import com.sparta.gitflow.project.schedule.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponseDto> save(
            Long userId,
            @Valid @RequestBody ScheduleSaveRequestDto dto
    ) {
        return ResponseEntity.ok(scheduleService.save(userId, dto));
    }

}
