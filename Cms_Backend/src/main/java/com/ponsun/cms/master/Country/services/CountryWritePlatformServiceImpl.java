package com.ponsun.cms.master.Country.services;

import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.master.Country.data.CountryDataValidator;
import com.ponsun.cms.master.Country.domain.Country;
import com.ponsun.cms.master.Country.domain.CountryRepository;
import com.ponsun.cms.master.Country.domain.CountryRepositoryWrapper;
import com.ponsun.cms.master.Country.request.CreateCountryRequest;
import com.ponsun.cms.master.Country.request.UpdateCountryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryWritePlatformServiceImpl implements CountryWritePlatformService {

    private final CountryRepository countryRepository;
    private final CountryRepositoryWrapper countryRepositoryWrapper;
    private final CountryDataValidator countryDataValidator;


    @Transactional
    public Response createCountry(CreateCountryRequest createCountryRequest) {
        try {
            this.countryDataValidator.validateSaveCountry(createCountryRequest);
            final Country country = Country.create(createCountryRequest);
            this.countryRepository.saveAndFlush(country);
            return Response.of(Long.valueOf(country.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateCountry(Integer id, UpdateCountryRequest updateCountryRequest) {
        try {
            this.countryDataValidator.validateUpdateCountry(updateCountryRequest);
            final Country country = this.countryRepositoryWrapper.findOneWithNotFoundDetection(id);
            country.update(updateCountryRequest);
            this.countryRepository.saveAndFlush(country);
            return Response.of(Long.valueOf(country.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
 @Override
 @Transactional
 public  Response blockCountry(Integer id){
        try {
            final Country country = this.countryRepositoryWrapper.findOneWithNotFoundDetection(id);
            country.setStatus(Status.DELETE);
            country.setUpdatedAt(LocalDateTime.now());
            this.countryRepository.saveAndFlush(country);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
 }
@Override
    @Transactional
    public Response unblockCountry(Integer id){
        try {
            final Country country = this.countryRepositoryWrapper.findOneWithNotFoundDetection(id);
            country.setStatus(Status.ACTIVE);
            country.setUpdatedAt(LocalDateTime.now());
            this.countryRepository.saveAndFlush(country);
            return Response.of(Long.valueOf(id));
        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
}
}
