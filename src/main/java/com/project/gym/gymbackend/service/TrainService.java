package com.project.gym.gymbackend.service;

import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.model.Train;

public interface TrainService {
    Train addTrainForGym(Train train, Gym gym);

    Train editTrain(Train train, Train existsTrain);
}
