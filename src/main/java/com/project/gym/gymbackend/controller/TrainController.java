package com.project.gym.gymbackend.controller;

import com.project.gym.gymbackend.dto.TrainDto;
import com.project.gym.gymbackend.manager.TrainManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = " http://localhost:4200")
public class TrainController {

    @Autowired
    private TrainManagerService trainManagerService;

    @PostMapping("/addTrainForGym/{idGym}")
    TrainDto addTrainForGym(@RequestBody TrainDto train, @PathVariable long idGym) {
        return trainManagerService.addTrainForGym(train, idGym);
    }

    @PostMapping("/addTrainForSport/{idTrain}/{idSport}")
    void addTrainForSport(@PathVariable long idTrain, @PathVariable long idSport) {
        trainManagerService.addTrainForSport(idTrain, idSport);
    }

    @PutMapping("/editTrain/{id}")
    TrainDto editTrain(@RequestBody TrainDto train, @PathVariable long id) {
        return trainManagerService.editTrain(train, id);
    }

    @DeleteMapping("/deleteTrain/{id}")
    void deleteTrain(@PathVariable long id) {
        trainManagerService.deleteTrain(id);
    }

    @GetMapping("/findTrainById/{id}")
    TrainDto findTrainById(@PathVariable long id) {
        return trainManagerService.findTrainById(id);
    }

    @GetMapping("/findAllTrains")
    List<TrainDto> findAllTrains() {
        return trainManagerService.findAllTrains();
    }

    @GetMapping("/findTrainsForSport/{idSport}")
    List<TrainDto> findTrainsForSport(@PathVariable long idSport) {
        return trainManagerService.findTrainsForSport(idSport);
    }

    @GetMapping("/findTrainsForGym/{idGym}")
    List<TrainDto> findTrainsForGym(@PathVariable long idGym) {
        return trainManagerService.findTrainsForGym(idGym);
    }
}
