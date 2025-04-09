package com.sparta.gitflow.project.schedule.repository;

import com.sparta.gitflow.project.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
