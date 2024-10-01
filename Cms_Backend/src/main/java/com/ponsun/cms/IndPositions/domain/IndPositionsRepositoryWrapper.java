package com.ponsun.cms.IndPositions.domain;


import com.ponsun.cms.IndPositions.request.AbstractIndPositionsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndPositionsRepositoryWrapper extends AbstractIndPositionsRequest {
    private final IndPositionsRepository indPositionsRepository;


    @Transactional
    public IndPositions findOneWithNotFoundDetection(final Integer id){
        return this.indPositionsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("IndPositions Not found" + id));
    }
    @Transactional
    public List<IndPositions> findCmsIdNotFoundDetection(final Integer cmsId){
        return this.indPositionsRepository.findByCmsId(cmsId);
    }

    @Override
    public String toString(){ return super.toString();}
}
