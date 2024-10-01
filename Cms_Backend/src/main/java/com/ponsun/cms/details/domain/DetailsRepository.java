package com.ponsun.cms.details.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetailsRepository extends JpaRepository<Details,Integer> {
    Optional<Details> findById(Integer id);
}
