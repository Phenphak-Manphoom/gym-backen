package com.project.gym.gymbackend.managerImp;

import com.project.gym.gymbackend.dao.GymDao;
import com.project.gym.gymbackend.dao.SportsManDao;
import com.project.gym.gymbackend.dao.WorktimeDao;
import com.project.gym.gymbackend.dto.SportsManDto;
import com.project.gym.gymbackend.dto.WorktimeDto;
import com.project.gym.gymbackend.manager.WorktimeManangerService;
import com.project.gym.gymbackend.model.Gym;
import com.project.gym.gymbackend.model.OrikaBeanMapper;
import com.project.gym.gymbackend.model.SportsMan;
import com.project.gym.gymbackend.model.Worktime;
import com.project.gym.gymbackend.service.WorktimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class WorktimeManangerServiceImpl implements WorktimeManangerService {
    @Autowired
    private OrikaBeanMapper orikaBeanMapper;

    @Autowired
    private WorktimeDao worktimeDao;

    @Autowired
    private WorktimeService worktimeService;

    @Autowired
    private GymDao gymDao;

    @Autowired
    private SportsManDao sportsManDao;

    @Override
    public void addSportsManForWork(long idSprtsMan, long idWorktime) {
        SportsMan sportsMan = sportsManDao.findById(idSprtsMan).orElse(null);
        Worktime worktime = worktimeDao.findById(idWorktime).orElse(null);
        worktime.addSportsManForWork(sportsMan);
    }

    @Override
    public WorktimeDto addWorktimeForGym(WorktimeDto worktimeDto, long idGym) {
        Gym gym = gymDao.findById(idGym).orElse(null);
        Worktime worktime = orikaBeanMapper.map(worktimeDto, Worktime.class);
        return orikaBeanMapper.convertDTO(worktimeService.addWorktimeForGym(worktime, gym), WorktimeDto.class);
    }

    @Override
    public WorktimeDto editWorktime(WorktimeDto worktimeDto, Long id, long idGym) {
        Worktime worktime = orikaBeanMapper.map(worktimeDto, Worktime.class);
        Worktime existsWorktime = worktimeDao.findById(id).orElse(null);
        Gym gym = gymDao.findById(idGym).orElse(null);
        return orikaBeanMapper.convertDTO(worktimeService.editWorktime(worktime, existsWorktime, gym), WorktimeDto.class);
    }

    @Override
    public void deleteWorktime(Long id) {
        Worktime existsWorktime = worktimeDao.findById(id).orElse(null);
        worktimeDao.delete(existsWorktime);
    }

    @Override
    public WorktimeDto findWorktimeById(Long id) {
        return orikaBeanMapper.convertDTO(worktimeDao.findById(id).orElse(null), WorktimeDto.class);
    }

    @Override
    public List<WorktimeDto> findWorktimesForGym(Long idGym) {
        Gym gym = gymDao.findById(idGym).orElse(null);
        List<Worktime> worktimes = gym.getWorktimes();
        return orikaBeanMapper.convertListDTO(worktimes, WorktimeDto.class);
    }

    @Override
    public List<SportsManDto> findSportsManForWorktime(Long idWorktime) {
        Worktime worktime = worktimeDao.findById(idWorktime).orElse(null);
        List<SportsMan> sportsMans = worktime.getSportsMans();
        return orikaBeanMapper.convertListDTO(sportsMans, SportsManDto.class);
    }
}
