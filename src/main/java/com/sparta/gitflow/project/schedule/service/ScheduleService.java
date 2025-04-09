package com.sparta.gitflow.project.schedule.service;


import com.sparta.gitflow.project.schedule.dto.request.ScheduleSaveRequestDto;
import com.sparta.gitflow.project.schedule.dto.response.ScheduleSaveResponseDto;
import com.sparta.gitflow.project.schedule.entity.Schedule;
import com.sparta.gitflow.project.schedule.repository.ScheduleRepository;
import com.sparta.gitflow.project.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveResponseDto save(Long userId, ScheduleSaveRequestDto dto) {
        User user = User.of(userId);
        Schedule schedule = new Schedule(user, dto.getTitle(), dto.getContent());
        scheduleRepository.save(schedule);
        return new ScheduleSaveResponseDto(
                schedule.getId(),
                user.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }
}
