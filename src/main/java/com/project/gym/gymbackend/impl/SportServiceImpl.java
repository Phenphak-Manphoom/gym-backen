package com.project.gym.gymbackend.impl;

import com.project.gym.gymbackend.dao.SportDao;
import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.model.Sport;
import com.project.gym.gymbackend.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SportServiceImpl implements SportService {

    @Autowired
    private SportDao sportDao;

    @Override
    public Sport addSport(Sport sport, Gym gym) {
        gym.addSportForGym(sport);
        return sportDao.save(sport);
    }

    @Override
    public Sport editSport(Sport sport, Sport existSport) {
        existSport.setName(sport.getName());
        existSport.setDescription(sport.getDescription());
        existSport.setPhoto(sport.getPhoto());
        return sportDao.save(existSport);
    }
}
