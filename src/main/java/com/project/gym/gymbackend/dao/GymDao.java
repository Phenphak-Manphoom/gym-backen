package com.project.gym.gymbackend.dao;

import com.project.gym.gymbackend.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymDao extends JpaRepository<Gym,Long> {
}
