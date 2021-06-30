package com.project.gym.gymbackend.dao;

import com.project.gym.gymbackend.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainDao extends JpaRepository<Train,Long> {
}
