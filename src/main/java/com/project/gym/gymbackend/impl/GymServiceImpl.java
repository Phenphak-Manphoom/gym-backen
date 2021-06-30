package com.project.gym.gymbackend.impl;

import com.project.gym.gymbackend.dao.GymDao;
import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GymServiceImpl implements GymService {
    @Autowired
    private GymDao gymDao;

    @Override
    public Gym addGym(Gym gym) {
        return gymDao.save(gym);
    }

    @Override
    public Gym editGym(Gym gym, Gym existGym) {
        existGym.setName(gym.getName());
        existGym.setAddress(gym.getAddress());
        existGym.setArea(gym.getArea());
        existGym.setCity((gym.getCity()));
        existGym.setLogo(gym.getLogo());
        return  gymDao.save(existGym);
    }
}
