package com.ponsun.cms.IndPositions.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IndPositionsRepository extends JpaRepository<IndPositions,Integer> {
    Optional<IndPositions> findById(Integer id);
    List<IndPositions> findByCmsId(Integer cmsId);
}