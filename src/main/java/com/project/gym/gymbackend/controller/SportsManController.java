package com.project.gym.gymbackend.controller;

import com.project.gym.gymbackend.dto.SportsManDto;
import com.project.gym.gymbackend.manager.SportsManManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = " http://localhost:4200")
public class SportsManController {

    @Autowired
    private SportsManManagerService sportsManManagerService;

    @PostMapping("/addSportsMan/{id}")
    SportsManDto addSportsMan(@RequestBody SportsManDto sportsMan) {
        return sportsManManagerService.addSportsMan(sportsMan);
    }

    @PutMapping("/editSportsMan/{id}")
    SportsManDto editSportsMan(@RequestBody SportsManDto sportsMan, @PathVariable Long id) {
        return sportsManManagerService.editSportsMan(sportsMan, id);
    }

    @DeleteMapping("/deleteSportsMan/{id}")
    void deleteSportsMan(@PathVariable Long id) {
        sportsManManagerService.deleteSportsMan(id);
    }

    @GetMapping("/findSportsManById/{id}")
    SportsManDto findSportsManById(@PathVariable Long id) {
        return sportsManManagerService.findSportsManById(id);
    }

    @GetMapping("/findAllSportsMans")
    List<SportsManDto> findAllSportsMans() {
        return sportsManManagerService.findAllSportsMans();
    }
}
