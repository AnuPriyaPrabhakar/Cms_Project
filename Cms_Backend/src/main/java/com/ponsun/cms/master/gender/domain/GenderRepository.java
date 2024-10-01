package com.ponsun.cms.master.gender.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
    Optional<Gender> findById(Integer id);
}
