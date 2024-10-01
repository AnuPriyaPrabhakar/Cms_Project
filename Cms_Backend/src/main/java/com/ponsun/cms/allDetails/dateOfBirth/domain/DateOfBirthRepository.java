package com.ponsun.cms.allDetails.dateOfBirth.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DateOfBirthRepository extends JpaRepository<DateOfBirth,Integer> {
    Optional<DateOfBirth> findById(Integer id);
}
