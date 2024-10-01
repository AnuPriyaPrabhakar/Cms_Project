package com.ponsun.cms.IndOrg.positions.domain;


import com.ponsun.cms.IndOrg.positions.request.AbstractPositionsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PositionsRepositoryWrapper extends AbstractPositionsRequest {
    private final PositionsRepository positionsRepository;


    @Transactional
    public Positions findOneWithNotFoundDetection(final Integer id){
        return this.positionsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Positions Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
