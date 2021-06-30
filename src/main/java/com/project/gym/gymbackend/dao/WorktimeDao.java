package com.project.gym.gymbackend.dao;

import com.project.gym.gymbackend.model.Worktime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorktimeDao extends JpaRepository<Worktime,Long> {
}
