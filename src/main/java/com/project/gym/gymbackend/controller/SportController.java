package com.project.gym.gymbackend.controller;

import com.project.gym.gymbackend.dto.SportDto;
import com.project.gym.gymbackend.manager.SportManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = " http://localhost:4200")
public class SportController {

    @Autowired
    private SportManagerService sportManagerService;

    @PostMapping("/addSportForGym/{idGym}")
    SportDto addSportForGym(@RequestBody SportDto sport, @PathVariable Long idGym) {
        return sportManagerService.addSportForGym(sport, idGym);
    }

    @PostMapping("/addSportForSportsMan/{idSport}/{idSportsMan}")
    void addSportForSportsMan(@PathVariable long idSport, @PathVariable long idSportsMan) {
        sportManagerService.addSportForSportsMan(idSport, idSportsMan);
    }

    @PutMapping("/editSport/{id}")
    SportDto editSport(@RequestBody SportDto sport, @PathVariable Long id) {
        return sportManagerService.editSport(sport, id);
    }

    @DeleteMapping("/deleteSport/{id}")
    void deleteSport(@PathVariable Long id) {
        sportManagerService.deleteSport(id);
    }

    @GetMapping("/findSportById/{id}")
    SportDto findSportById(@PathVariable Long id) {
        return sportManagerService.findSportById(id);
    }

    @GetMapping("/findSportsForSportsMan/{idSportsMan}")
    List<SportDto> findSportsForSportsMan(@PathVariable Long idSportsMan) {
        return sportManagerService.findSportsForSportsMan(idSportsMan);
    }

    @GetMapping("/findSportsForGym/{idGym}")
    List<SportDto> findSportsForGym(@PathVariable Long idGym) {
        return sportManagerService.findSportsForGym(idGym);
    }
}
