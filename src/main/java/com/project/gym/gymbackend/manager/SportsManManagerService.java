package com.project.gym.gymbackend.manager;

import com.project.gym.gymbackend.dto.SportsManDto;

import java.util.List;

public interface SportsManManagerService {

    SportsManDto addSportsMan(SportsManDto sportsManDto);

    SportsManDto editSportsMan(SportsManDto sportsManDto, Long id);

    void deleteSportsMan(Long id);

    SportsManDto findSportsManById(Long id);

    List<SportsManDto> findAllSportsMans();
}
