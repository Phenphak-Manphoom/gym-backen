package com.project.gym.gymbackend.service;

import com.project.gym.gymbackend.model.Arbitrate;
import com.project.gym.gymbackend.model.Gym;


public interface ArbitrateService {
    Arbitrate addArbitrateForGym(Arbitrate arbitrate, Gym gym);

    Arbitrate editArbitrate(Arbitrate arbitrate, Arbitrate existsArbitrate);
}
