package com.ponsun.cms.SearchDetails.Search.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SearchRepository extends JpaRepository<Search, Integer> {
    Optional<Search> findById(Integer id);
}
