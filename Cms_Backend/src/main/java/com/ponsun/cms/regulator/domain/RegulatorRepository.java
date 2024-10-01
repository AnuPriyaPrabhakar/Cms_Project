package com.ponsun.cms.regulator.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegulatorRepository extends JpaRepository<Regulator,Integer> {
    Optional<Regulator> findById(Integer id);
}
