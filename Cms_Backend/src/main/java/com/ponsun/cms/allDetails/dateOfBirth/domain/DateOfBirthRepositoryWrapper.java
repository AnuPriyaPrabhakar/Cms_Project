package com.ponsun.cms.allDetails.dateOfBirth.domain;

import com.ponsun.cms.allDetails.dateOfBirth.request.AbstractDateOfBirthRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DateOfBirthRepositoryWrapper extends AbstractDateOfBirthRequest {
    private final com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirthRepository DateOfBirthRepository;
    @Transactional
    public DateOfBirth findOneWithNotFoundDetection(final Integer id){
        return this.DateOfBirthRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("DateOfBirth Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
