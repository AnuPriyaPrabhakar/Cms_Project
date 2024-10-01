package com.ponsun.cms.IndOrg.detailsAboutRelation.domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetailsAboutRelationRepository extends JpaRepository<DetailsAboutRelation,Integer> {
    Optional<DetailsAboutRelation> findById(Integer id);
}