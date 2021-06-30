package com.project.gym.gymbackend.manager;

import com.project.gym.gymbackend.dto.TrainDto;

import java.util.List;

public interface TrainManagerService {
    TrainDto addTrainForGym(TrainDto trainDto, long idGym);

    void addTrainForSport(long idTrain, long idSport);

    TrainDto editTrain(TrainDto trainDto, long id);

    void deleteTrain(long id);

    TrainDto findTrainById(long id);

    List<TrainDto> findAllTrains();

    List<TrainDto> findTrainsForSport(long idSport);

    List<TrainDto> findTrainsForGym(long idGym);
}
