package com.ponsun.cms.countryHq.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryHqRepository  extends JpaRepository<CountryHq,Integer> {
    Optional<CountryHq> findById(Integer id);
}
