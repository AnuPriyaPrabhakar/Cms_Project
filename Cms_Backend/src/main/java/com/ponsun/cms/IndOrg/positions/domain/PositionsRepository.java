package com.ponsun.cms.IndOrg.positions.domain;

import com.ponsun.cms.IndOrg.positions.data.PositionsData;
import com.ponsun.cms.common.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PositionsRepository extends JpaRepository<Positions, Integer> {
    Optional<Positions> findById(Integer id);

    // Add recordTypeId parameter to the method
    //List<PositionsData> findByCmsId(@Param("cmsId") Integer cmsId);

    List<PositionsData> findByCmsIdAndStatus(Integer cmsId, Status status);
}
