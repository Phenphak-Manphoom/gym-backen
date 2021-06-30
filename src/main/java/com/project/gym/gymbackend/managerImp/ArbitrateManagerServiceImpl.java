package com.project.gym.gymbackend.managerImp;

import com.project.gym.gymbackend.dao.ArbitrateDao;
import com.project.gym.gymbackend.dao.GymDao;
import com.project.gym.gymbackend.dao.SportDao;
import com.project.gym.gymbackend.dto.ArbitrateDto;
import com.project.gym.gymbackend.manager.ArbitrateManagerService;
import com.project.gym.gymbackend.model.Arbitrate;
import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.model.OrikaBeanMapper;
import com.project.gym.gymbackend.model.Sport;
import com.project.gym.gymbackend.service.ArbitrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ArbitrateManagerServiceImpl implements ArbitrateManagerService {

    @Autowired
    private OrikaBeanMapper orikaBeanMapper;

    @Autowired
    private ArbitrateService arbitrateService;

    @Autowired
    private SportDao sportDao;

    @Autowired
    private ArbitrateDao arbitrateDao;

    @Autowired
    private GymDao gymDao;

    @Override
    public void addArbitrateForSport(long idArbitrate, long idSport) {
        Sport sport=sportDao.findById(idSport).orElse(null);
        Arbitrate arbitrate=arbitrateDao.findById(idArbitrate).orElse(null);
        sport.addArbitrate(arbitrate);

    }

    @Override
    public ArbitrateDto addArbitrateForGym(ArbitrateDto arbitrateDto, long idGym) {
        Gym gym=gymDao.findById(idGym).orElse(null);
        Arbitrate arbitrate=orikaBeanMapper.map(arbitrateDto,Arbitrate.class);
        return orikaBeanMapper.convertDTO(arbitrateService.addArbitrateForGym(arbitrate,gym),ArbitrateDto.class);
    }

    @Override
    public ArbitrateDto editArbitrate(ArbitrateDto arbitrateDto, long id) {
        Arbitrate existsArbitrate=arbitrateDao.findById(id).orElse(null);
        Arbitrate arbitrate=orikaBeanMapper.map(arbitrateDto,Arbitrate.class);
        return orikaBeanMapper.convertDTO(arbitrateService.editArbitrate(arbitrate,existsArbitrate),ArbitrateDto.class);
    }

    @Override
    public void deleteArbitrate(long id) {
        Arbitrate existsArbitrate=arbitrateDao.findById(id).orElse(null);
        arbitrateDao.delete(existsArbitrate);
    }

    @Override
    public ArbitrateDto findArbitrateById(long id) {
        return orikaBeanMapper.convertDTO(arbitrateDao.findById(id).orElse(null) ,ArbitrateDto.class);
    }

    @Override
    public List<ArbitrateDto> findArbitratesForSport(long idSport) {
        Sport sport=sportDao.findById(idSport).orElse(null);
        List<Arbitrate>arbitrates=sport.getArbitrates();
        return orikaBeanMapper.convertListDTO(arbitrates,ArbitrateDto.class);
    }

    @Override
    public List<ArbitrateDto> findArbitratesForGym(long idGym) {
        Gym gym=gymDao.findById(idGym).orElse(null);
        List<Arbitrate>arbitrates=gym.getArbitrates();
        return orikaBeanMapper.convertListDTO(arbitrates,ArbitrateDto.class);

    }

    @Override
    public List<ArbitrateDto> findAllArbitrates() {
        List<Arbitrate>arbitrates=arbitrateDao.findAll();
        return orikaBeanMapper.convertListDTO(arbitrates,ArbitrateDto.class);
    }
}
