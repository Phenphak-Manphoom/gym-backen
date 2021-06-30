package com.project.gym.gymbackend.managerImp;

import com.project.gym.gymbackend.dao.SportsManDao;
import com.project.gym.gymbackend.dto.SportsManDto;
import com.project.gym.gymbackend.manager.SportsManManagerService;
import com.project.gym.gymbackend.model.OrikaBeanMapper;
import com.project.gym.gymbackend.model.SportsMan;
import com.project.gym.gymbackend.service.SportsManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SportsManManagerServiceImpl implements SportsManManagerService {

    @Autowired
    private OrikaBeanMapper orikaBeanMapper;

    @Autowired
    private SportsManDao sportsManDao;

    @Autowired
    private SportsManService sportsManService;


    @Override
    public SportsManDto addSportsMan(SportsManDto sportsManDto) {
        SportsMan sportsMan = orikaBeanMapper.map(sportsManDto,SportsMan.class);
        return orikaBeanMapper.convertDTO(sportsManService.addSportsMan(sportsMan),SportsManDto.class);
    }

    @Override
    public SportsManDto editSportsMan(SportsManDto sportsManDto, Long id) {
        SportsMan sportsMan= orikaBeanMapper.map(sportsManDto,SportsMan.class);
        SportsMan existsSportsMan= sportsManDao.findById(id).orElse(null);
        return orikaBeanMapper.convertDTO(sportsManService.editSportsMan(sportsMan,existsSportsMan),SportsManDto.class);
    }

    @Override
    public void deleteSportsMan(Long id) {
       SportsMan existsSportsMan = sportsManDao.findById(id).orElse(null);
       sportsManDao.delete(existsSportsMan);
    }

    @Override
    public SportsManDto findSportsManById(Long id) {
        return orikaBeanMapper.convertDTO(sportsManDao.findById(id).orElse(null),SportsManDto.class);
    }

    @Override
    public List<SportsManDto> findAllSportsMans() {
        List<SportsMan>sportsMans = sportsManDao.findAll();
        return orikaBeanMapper.convertListDTO(sportsMans,SportsManDto.class);
    }
}
