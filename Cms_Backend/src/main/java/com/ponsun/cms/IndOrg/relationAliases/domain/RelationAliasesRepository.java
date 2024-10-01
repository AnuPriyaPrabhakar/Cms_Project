package com.ponsun.cms.IndOrg.relationAliases.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RelationAliasesRepository extends JpaRepository<RelationAliases,Integer> {
    Optional<RelationAliases> findById(Integer id);
}
