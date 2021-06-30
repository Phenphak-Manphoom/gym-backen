package com.project.gym.gymbackend.manager;

import com.project.gym.gymbackend.dto.GymDto;

import java.util.List;

public interface GymManagerService {
    GymDto addGym(GymDto gymDto);

    GymDto editGym(GymDto gymDto, Long id);

    void deleteGym(Long id);

    GymDto findGymById(Long id);

    List<GymDto> findAllGyms();
}
