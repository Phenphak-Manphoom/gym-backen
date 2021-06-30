package com.project.gym.gymbackend.managerImp;

import com.project.gym.gymbackend.dao.GymDao;
import com.project.gym.gymbackend.dao.SportDao;
import com.project.gym.gymbackend.dao.TrainDao;
import com.project.gym.gymbackend.dto.TrainDto;
import com.project.gym.gymbackend.manager.TrainManagerService;
import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.model.OrikaBeanMapper;
import com.project.gym.gymbackend.model.Sport;
import com.project.gym.gymbackend.model.Train;
import com.project.gym.gymbackend.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class TrainManagerServiceImpl implements TrainManagerService {

    @Autowired
    private OrikaBeanMapper orikaBeanMapper;

    @Autowired
    private TrainDao trainDao;

    @Autowired
    private TrainService trainService;

    @Autowired
    private SportDao sportDao;

    @Autowired
    private GymDao gymDao;

    @Override
    public TrainDto addTrainForGym(TrainDto trainDto, long idGym) {
        Gym gym =gymDao.findById(idGym).orElse(null);
        Train train=orikaBeanMapper.map(trainDto,Train.class);
        return orikaBeanMapper.convertDTO(trainService.addTrainForGym(train,gym),TrainDto.class);
    }

    @Override
    public void addTrainForSport(long idTrain, long idSport) {
        Sport sport=sportDao.findById(idSport).orElse(null);
        Train train =trainDao.findById(idTrain).orElse(null);
        sport.addTrain(train);
    }

    @Override
    public TrainDto editTrain(TrainDto trainDto, long id) {
        Train train = orikaBeanMapper.map(trainDto,Train.class);
        Train existsTrain = trainDao.findById(id).orElse(null);
        return orikaBeanMapper.convertDTO(trainService.editTrain(train,existsTrain),TrainDto.class);
    }

    @Override
    public void deleteTrain(long id) {
        Train existsTrain =trainDao.findById(id).orElse(null);
        trainDao.delete(existsTrain);
    }

    @Override
    public TrainDto findTrainById(long id) {
        return orikaBeanMapper.convertDTO(trainDao.findById(id).orElse(null),TrainDto.class);
    }

    @Override
    public List<TrainDto> findAllTrains() {
        List<Train>trains= trainDao.findAll();
        return orikaBeanMapper.convertListDTO(trains,TrainDto.class);
    }

    @Override
    public List<TrainDto> findTrainsForSport(long idSport) {
        Sport  sport=sportDao.findById(idSport).orElse(null);
        List<Train>trains=sport.getTrains();
        return orikaBeanMapper.convertListDTO(trains,TrainDto.class);
    }

    @Override
    public List<TrainDto> findTrainsForGym(long idGym) {
        Gym gym = gymDao.findById(idGym).orElse(null);
        List<Train> trains = gym.getTrains();
        return orikaBeanMapper.convertListDTO(trains, TrainDto.class);
    }
}
