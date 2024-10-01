package com.ponsun.cms.master.idNumber.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdNumberRepository extends JpaRepository<IdNumber, Integer> {
    Optional<IdNumber> findById(Integer id);
}