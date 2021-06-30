package com.project.gym.gymbackend.service;

import com.project.gym.gymbackend.model.Gym;


public interface GymService {
    Gym addGym(Gym gym);

    Gym editGym(Gym gym, Gym existsGym);
}
