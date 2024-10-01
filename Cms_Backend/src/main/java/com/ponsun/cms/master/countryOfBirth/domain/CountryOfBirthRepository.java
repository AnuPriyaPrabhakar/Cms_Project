package com.ponsun.cms.master.countryOfBirth.domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryOfBirthRepository extends JpaRepository<CountryOfBirth, Integer> {
    Optional<CountryOfBirth> findById(Integer id);
}
