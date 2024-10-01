package com.ponsun.cms.regulatorList.domain;

import com.ponsun.cms.regulatorList.request.AbstractRegulatorListRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegulatorListRepositoryWrapper extends AbstractRegulatorListRequest {
    private final RegulatorListRepository regulatorListRepository;
    @Transactional
    public RegulatorList findOneWithNotFoundDetection(final Integer id){
        return this.regulatorListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("RegulatorList Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
