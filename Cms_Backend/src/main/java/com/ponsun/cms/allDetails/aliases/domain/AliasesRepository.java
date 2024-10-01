package com.ponsun.cms.allDetails.aliases.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AliasesRepository extends JpaRepository<Aliases,Integer> {
    Optional<Aliases> findById(Integer id);
}
