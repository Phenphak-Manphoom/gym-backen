package com.project.gym.gymbackend.controller;

import com.project.gym.gymbackend.dto.SportsManDto;
import com.project.gym.gymbackend.dto.WorktimeDto;
import com.project.gym.gymbackend.manager.WorktimeManangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = " http://localhost:4200")
public class WorktimeController {

    @Autowired
    private WorktimeManangerService worktimeManangerService;

    @PostMapping("/addSportsManForWork/{idSprtsMan}/{idWorktime}")
    void addSportsManForWork(@PathVariable long idSprtsMan, @PathVariable long idWorktime) {
        worktimeManangerService.addSportsManForWork(idSprtsMan, idWorktime);
    }

    @PostMapping("/addWorktimeForGym/{idGym}")
    WorktimeDto addWorktimeForGym(@RequestBody WorktimeDto worktime, @PathVariable long idGym) {
        return worktimeManangerService.addWorktimeForGym(worktime, idGym);
    }

    @PutMapping("/editWorktime/{id}/{idGym}")
    WorktimeDto editWorktime(@RequestBody WorktimeDto worktime, @PathVariable Long id, @PathVariable long idGym) {
        return worktimeManangerService.editWorktime(worktime, id, idGym);
    }

    @DeleteMapping("/deleteWorktime/{id}")
    void deleteWorktime(@PathVariable Long id) {
        worktimeManangerService.deleteWorktime(id);
    }

    @GetMapping("/findWorktimeById/{id}")
    WorktimeDto findWorktimeById(@PathVariable Long id) {
        return worktimeManangerService.findWorktimeById(id);
    }

    @GetMapping("/findWorktimesForGym/{idGym}")
    List<WorktimeDto> findWorktimesForGym(@PathVariable Long idGym) {
        return worktimeManangerService.findWorktimesForGym(idGym);
    }

    @GetMapping("/findSportsManForWorktime/{idWorktime}")
    List<SportsManDto> findSportsManForWorktime(@PathVariable Long idWorktime) {
        return worktimeManangerService.findSportsManForWorktime(idWorktime);
    }
}
