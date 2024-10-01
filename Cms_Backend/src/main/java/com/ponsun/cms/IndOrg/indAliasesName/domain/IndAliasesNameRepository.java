package com.ponsun.cms.IndOrg.indAliasesName.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndAliasesNameRepository extends JpaRepository<IndAliasesName,Integer> {
    Optional<IndAliasesName> findById(Integer id);
}
