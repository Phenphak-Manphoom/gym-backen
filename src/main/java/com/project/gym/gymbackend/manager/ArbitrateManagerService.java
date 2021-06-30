package com.project.gym.gymbackend.manager;

import com.project.gym.gymbackend.dto.ArbitrateDto;

import java.util.List;

public interface ArbitrateManagerService {
    void addArbitrateForSport(long idArbitrate,long idSport);
    ArbitrateDto addArbitrateForGym(ArbitrateDto arbitrateDto,long idGym);
    ArbitrateDto editArbitrate(ArbitrateDto arbitrateDto, long id);
    void deleteArbitrate(long id);
    ArbitrateDto findArbitrateById(long id);
    List<ArbitrateDto> findArbitratesForSport(long idSport);
    List<ArbitrateDto> findArbitratesForGym(long id);
    List<ArbitrateDto> findAllArbitrates();
}
