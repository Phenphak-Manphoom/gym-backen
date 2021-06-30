package com.project.gym.gymbackend.impl;

import com.project.gym.gymbackend.dao.SportDao;
import com.project.gym.gymbackend.dao.SportsManDao;
import com.project.gym.gymbackend.model.SportsMan;
import com.project.gym.gymbackend.service.SportsManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SportsManImpl implements SportsManService {
    @Autowired
    private SportsManDao sportsManDao;

    @Override
    public SportsMan addSportsMan(SportsMan sportsMan) {
        return sportsManDao.save(sportsMan);
    }

    @Override
    public SportsMan editSportsMan(SportsMan sportsMan, SportsMan existSportsMan) {
        existSportsMan.setFirstName(sportsMan.getFirstName());
        existSportsMan.setLastName(sportsMan.getLastName());
        existSportsMan.setAge(sportsMan.getAge());
        existSportsMan.setSex(sportsMan.getSex());
        existSportsMan.setAvatar(sportsMan.getAvatar());
        return sportsManDao.save(existSportsMan);
    }
}
