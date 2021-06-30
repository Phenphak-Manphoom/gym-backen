package com.project.gym.gymbackend.impl;

import com.project.gym.gymbackend.dao.ArbitrateDao;
import com.project.gym.gymbackend.model.Arbitrate;
import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.service.ArbitrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArbitrateServiceImpl implements ArbitrateService {

    @Autowired
    private ArbitrateDao arbitrateDao;

    @Override
    public Arbitrate addArbitrateForGym(Arbitrate arbitrate, Gym gym) {
        gym.addArbitrate(arbitrate);
        return arbitrateDao.save(arbitrate);
    }

    @Override
    public Arbitrate editArbitrate(Arbitrate arbitrate, Arbitrate existArbitrate) {
        existArbitrate.setName((arbitrate.getName()));
        return  arbitrateDao.save(existArbitrate);
    }
}
