package com.ponsun.cms.regulatorList.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegulatorListRepository extends JpaRepository<RegulatorList,Integer> {
    Optional<RegulatorList> findById(Integer id);
}
