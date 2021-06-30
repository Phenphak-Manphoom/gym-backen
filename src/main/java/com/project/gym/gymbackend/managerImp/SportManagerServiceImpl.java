package com.project.gym.gymbackend.managerImp;

import com.project.gym.gymbackend.dao.GymDao;
import com.project.gym.gymbackend.dao.SportDao;
import com.project.gym.gymbackend.dao.SportsManDao;
import com.project.gym.gymbackend.dto.SportDto;
import com.project.gym.gymbackend.manager.SportManagerService;
import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.model.OrikaBeanMapper;
import com.project.gym.gymbackend.model.Sport;
import com.project.gym.gymbackend.model.SportsMan;
import com.project.gym.gymbackend.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SportManagerServiceImpl implements SportManagerService {
    @Autowired
    private OrikaBeanMapper orikaBeanMapper;

    @Autowired
    private SportDao sportDao;

    @Autowired
    private SportService sportService;

    @Autowired
    private SportsManDao sportsManDao;

    @Autowired
    private GymDao gymDao;

    @Override
    public SportDto addSportForGym(SportDto sportDto, Long idGym) {
        Sport sport = orikaBeanMapper.map(sportDto,Sport.class);
        Gym gym = gymDao.findById(idGym).orElse(null);
        return orikaBeanMapper.convertDTO(sportService.addSport(sport,gym),SportDto.class);
    }

    @Override
    public void addSportForSportsMan(long idSport, long idSportsMan) {
        Sport existsSport = sportDao.findById(idSport).orElse(null);
        SportsMan sportsMan =sportsManDao.findById(idSportsMan).orElse(null);
        sportsMan.addSport(existsSport);


    }

    @Override
    public SportDto editSport(SportDto sportDto, Long id) {
        Sport sport= orikaBeanMapper.map(sportDto,Sport.class);
        Sport existsSport =sportDao.findById(id).orElse(null);
        return orikaBeanMapper.convertDTO(sportService.editSport(sport,existsSport),SportDto.class);
    }

    @Override
    public void deleteSport(Long id) {
         Sport sport = sportDao.findById(id).orElse(null);
         sportDao.delete(sport);
    }

    @Override
    public SportDto findSportById(Long id) {
        return orikaBeanMapper.convertDTO(sportDao.findById(id).orElse(null),SportDto.class);
    }

    @Override
    public List<SportDto> findSportsForSportsMan(Long idSportsMan) {
        SportsMan sportsMan=sportsManDao.findById(idSportsMan).orElse(null);
        List<Sport>sports= sportsMan.getSports();
        return orikaBeanMapper.convertListDTO(sports,SportDto.class);
    }

    @Override
    public List<SportDto> findSportsForGym(Long idGym) {
        Gym gym =gymDao.findById(idGym).orElse(null);
        List<Sport>sports=gym.getSports();
        return orikaBeanMapper.convertListDTO(sports,SportDto.class);
    }
}
