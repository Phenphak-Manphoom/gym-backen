package com.project.gym.gymbackend.managerImp;

import com.project.gym.gymbackend.dao.GymDao;
import com.project.gym.gymbackend.dto.GymDto;
import com.project.gym.gymbackend.manager.GymManagerService;
import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.model.OrikaBeanMapper;
import com.project.gym.gymbackend.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class GymManagerServiceImpl implements GymManagerService {
    @Autowired
    private OrikaBeanMapper orikaBeanMapper;

    @Autowired
    private GymService gymService;

    @Autowired
    private GymDao gymDao;

    @Override
    public GymDto addGym(GymDto gymDto) {
        Gym gym = orikaBeanMapper.map(gymDto,Gym.class);
        return orikaBeanMapper.convertDTO(gymService.addGym(gym), GymDto.class);
    }

    @Override
    public GymDto editGym(GymDto gymDto, Long id) {
        Gym gym = orikaBeanMapper.map(gymDto,Gym.class);
        Gym existsGym=gymDao.findById(id).orElse(null);
        return orikaBeanMapper.convertDTO(gymService.editGym(gym, existsGym), GymDto.class);
    }

    @Override
    public void deleteGym(Long id) {
         Gym exists=gymDao.findById(id).orElse(null);
         gymDao.delete(exists);
    }

    @Override
    public GymDto findGymById(Long id) {
        return orikaBeanMapper.convertDTO(gymDao.findById(id).orElse(null),GymDto.class);
    }

    @Override
    public List<GymDto> findAllGyms() {
        List<Gym>gyms=gymDao.findAll();
        return orikaBeanMapper.convertListDTO(gyms,GymDto.class);
    }
}
