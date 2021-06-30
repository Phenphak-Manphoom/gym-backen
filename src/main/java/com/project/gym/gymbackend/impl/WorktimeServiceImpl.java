package com.project.gym.gymbackend.impl;

import com.project.gym.gymbackend.dao.WorktimeDao;
import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.model.Worktime;
import com.project.gym.gymbackend.service.WorktimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorktimeServiceImpl  implements WorktimeService {
    @Autowired
    private WorktimeDao worktimeDao;

    @Override
    public Worktime addWorktimeForGym(Worktime worktime, Gym gym) {
        gym.addWorktime(worktime);
        return worktimeDao.save(worktime);
    }

    @Override
    public Worktime editWorktime(Worktime worktime, Worktime existWorktime, Gym gym) {
        existWorktime.setDay(worktime.getDay());
        existWorktime.setTimetable(worktime.getTimetable());
        existWorktime.setEnd(worktime.getEnd());
        existWorktime.setStart(worktime.getStart());
        gym.addWorktime(existWorktime);
        return worktimeDao.save(existWorktime);
    }
}
