package com.ponsun.cms.countryRegistration.domain;


import com.ponsun.cms.countryRegistration.request.AbstractCountryRegistrationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryRegistrationRepositoryWrapper extends AbstractCountryRegistrationRequest {
    private final CountryRegistrationRepository countryRegistrationRepository;
    @Transactional
    public CountryRegistration findOneWithNotFoundDetection(final Integer id){
        return this.countryRegistrationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CountryRegistration Not found" + id));
    }
    @Transactional
    public List<CountryRegistration> findCmsIdNotFoundDetection(final Integer cmsId){
        return this.countryRegistrationRepository.findByCmsId(cmsId);
    }

    @Override
    public String toString(){ return super.toString();}
}
