package com.project.gym.gymbackend.manager;

import com.project.gym.gymbackend.dto.SportDto;

import java.util.List;

public interface SportManagerService {
    SportDto addSportForGym(SportDto sportDto, Long idGym);

    void addSportForSportsMan(long idSport, long idSportsMan);

    SportDto editSport(SportDto sportDto, Long id);

    void deleteSport(Long id);

    SportDto findSportById(Long id);

    List<SportDto> findSportsForSportsMan(Long idSportsMan);

    List<SportDto> findSportsForGym(Long idGym);
}
