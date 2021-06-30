package com.project.gym.gymbackend.dao;

import com.project.gym.gymbackend.model.Arbitrate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbitrateDao extends JpaRepository<Arbitrate,Long> {
}
