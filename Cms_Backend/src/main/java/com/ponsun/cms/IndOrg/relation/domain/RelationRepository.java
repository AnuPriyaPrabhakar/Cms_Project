package com.ponsun.cms.IndOrg.relation.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RelationRepository extends JpaRepository<Relation,Integer> {
    Optional<Relation> findById(Integer id);
}
