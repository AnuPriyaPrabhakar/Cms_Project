package com.ponsun.cms.details.domain;

import com.ponsun.cms.details.request.AbstractDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DetailsRepositoryWrapper extends AbstractDetailsRequest {
    private final com.ponsun.cms.details.domain.DetailsRepository DetailsRepository;
    @Transactional
    public Details findOneWithNotFoundDetection(final Integer id){
        return this.DetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Details Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
