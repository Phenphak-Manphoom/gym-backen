package com.project.gym.gymbackend.dao;

import com.project.gym.gymbackend.model.SportsMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsManDao extends JpaRepository<SportsMan,Long> {
}
