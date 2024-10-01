package com.ponsun.cms.countryHq.domain;


import com.ponsun.cms.countryHq.request.AbstractCountryHqRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class CountryHqRepositoryWrapper extends AbstractCountryHqRequest {
    private final CountryHqRepository countryHqRepository;
    @Transactional
    public CountryHq findOneWithNotFoundDetection(final Integer id){
        return this.countryHqRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CountryHq Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
