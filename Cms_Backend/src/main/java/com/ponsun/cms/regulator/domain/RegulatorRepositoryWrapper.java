package com.ponsun.cms.regulator.domain;

import com.ponsun.cms.regulator.request.AbstractRegulatorRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegulatorRepositoryWrapper extends AbstractRegulatorRequest {
    private final RegulatorRepository regulatorRepository;
    @Transactional
    public Regulator findOneWithNotFoundDetection(final Integer id){
        return this.regulatorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Regulator Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
