package com.project.gym.gymbackend.impl;

import com.project.gym.gymbackend.dao.TrainDao;
import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.model.Train;
import com.project.gym.gymbackend.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainDao trainDao;

    @Override
    public Train addTrainForGym(Train train, Gym gym) {
        gym.addTrain(train);
        return trainDao.save(train);
    }

    @Override
    public Train editTrain(Train train, Train existTrain) {
        existTrain.setName(train.getName());
        return trainDao.save(existTrain);
    }
}
