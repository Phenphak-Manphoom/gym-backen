package com.project.gym.gymbackend.controller;

import com.project.gym.gymbackend.dto.GymDto;
import com.project.gym.gymbackend.manager.GymManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = " http://localhost:4200")
public class GymController {

    @Autowired
    private GymManagerService gymManagerService;

    @PostMapping("/addGym")
    GymDto addGym(@RequestBody GymDto gymDto){
        return gymManagerService.addGym(gymDto);
    }

    @PutMapping("/editGym/{id}")
    GymDto editGym(@RequestBody GymDto  gymDto,@PathVariable long id){
        return gymManagerService.editGym(gymDto,id);
    }

    @DeleteMapping("/deleteGym/{id}")
    void deleteGym(@PathVariable Long id) {
        gymManagerService.deleteGym(id);
    }

    @GetMapping("/findGymById/{id}")
    GymDto findGymById(@PathVariable Long id){
        return gymManagerService.findGymById(id);
    }

    @GetMapping("/findAllGym")
    List<GymDto> findAllGym(){
        return gymManagerService.findAllGyms();
    }
}
