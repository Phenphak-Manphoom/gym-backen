package com.project.gym.gymbackend.service;

import com.project.gym.gymbackend.model.SportsMan;

public interface SportsManService {
    SportsMan addSportsMan(SportsMan sportsMan);

    SportsMan editSportsMan(SportsMan sportsMan, SportsMan existSportsMan);
}
