package com.ponsun.cms.master.countryOfFlag.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryOfFlagRepository extends JpaRepository<CountryOfFlag, Integer> {
    Optional<CountryOfFlag> findById(Integer id);
}