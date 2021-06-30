package com.project.gym.gymbackend.service;

import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.model.Worktime;

public interface WorktimeService {
    Worktime addWorktimeForGym(Worktime worktime, Gym gym);

    Worktime editWorktime(Worktime worktime, Worktime existWorktime, Gym gym);
}
