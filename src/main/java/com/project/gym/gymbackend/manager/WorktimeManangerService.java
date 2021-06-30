package com.project.gym.gymbackend.manager;

import com.project.gym.gymbackend.dto.SportsManDto;
import com.project.gym.gymbackend.dto.WorktimeDto;

import java.util.List;

public interface WorktimeManangerService {
    void addSportsManForWork(long idSprtsMan, long idWorktime);

    WorktimeDto addWorktimeForGym(WorktimeDto worktimeDto, long idGym);

    WorktimeDto editWorktime(WorktimeDto worktimeDto, Long id, long idGym);

    void deleteWorktime(Long id);

    WorktimeDto findWorktimeById(Long id);

    List<WorktimeDto> findWorktimesForGym(Long idGym);

    List<SportsManDto> findSportsManForWorktime(Long idWorktime);
}
