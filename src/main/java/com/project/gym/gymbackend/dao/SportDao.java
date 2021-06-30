package com.project.gym.gymbackend.dao;

import com.project.gym.gymbackend.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportDao extends JpaRepository<Sport,Long> {
}
