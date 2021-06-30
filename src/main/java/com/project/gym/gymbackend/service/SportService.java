package com.project.gym.gymbackend.service;

import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.model.Sport;

public interface SportService {
    Sport addSport(Sport sport, Gym gym);

    Sport editSport(Sport sport, Sport existSport);
}
