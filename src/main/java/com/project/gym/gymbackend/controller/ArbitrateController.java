package com.project.gym.gymbackend.controller;

import com.project.gym.gymbackend.dto.ArbitrateDto;
import com.project.gym.gymbackend.manager.ArbitrateManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = " http://localhost:4200")
public class ArbitrateController {

    @Autowired
    private ArbitrateManagerService arbitrateManagerService;

    @PostMapping("/addArbitrateForGym/{idGym}")
    ArbitrateDto addArbitrateForGym(@RequestBody ArbitrateDto arbitrate,@PathVariable long idGym){
        return arbitrateManagerService.addArbitrateForGym(arbitrate,idGym);
    }

    @PostMapping("/addArbitrateForSport/{idArbitrate}/{idSport}")
    void addArbitrateForSport(@PathVariable long idArbitrate,@PathVariable long idSport){
        arbitrateManagerService.addArbitrateForSport(idArbitrate,idSport);
    }

    @PutMapping("/editArbitrate/{id}")
    ArbitrateDto editArbitrate(@RequestBody ArbitrateDto arbitrate,@PathVariable long id){
        return arbitrateManagerService.editArbitrate(arbitrate,id);
    }

    @DeleteMapping("/deleteArbitrate/{id}")
    void deleteArbitrate(@PathVariable long id){
        arbitrateManagerService.deleteArbitrate(id);
    }

    @GetMapping("/findAllArbitrates")
    List<ArbitrateDto>arbitrates(){
        return  arbitrateManagerService.findAllArbitrates();
    }

    @GetMapping("/findArbitrateById/{id}")
    ArbitrateDto findArbitrateById(@PathVariable long  id){
        return arbitrateManagerService.findArbitrateById(id);
    }

    @GetMapping("/findArbitratesForSport/{id}")
    List<ArbitrateDto>arbitrateDtos(@PathVariable long id){
        return arbitrateManagerService.findArbitratesForSport(id);
    }

    @GetMapping("/findArbitratesForGym/{idGym}")
    List<ArbitrateDto> findArbitratesForGym(@PathVariable long idGym) {
        return arbitrateManagerService.findArbitratesForGym(idGym);
    }
}
