package com.ponsun.cms.countryHq.services;


import com.ponsun.cms.countryHq.data.CountryHqDataValidator;
import com.ponsun.cms.countryHq.domain.CountryHq;
import com.ponsun.cms.countryHq.domain.CountryHqRepository;
import com.ponsun.cms.countryHq.domain.CountryHqRepositoryWrapper;
import com.ponsun.cms.countryHq.request.CreateCountryHqRequest;
import com.ponsun.cms.countryHq.request.UpdateCountryHqRequest;
import com.ponsun.cms.countryHq.rowmapper.CountryHqRowMapper;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryHqWritePlatformServiceImpl implements CountryHqWritePlatformService {
    private final CountryHqRepository countryHqRepository;
    private final CountryHqRepositoryWrapper countryHqRepositoryWrapper;
    private final CountryHqDataValidator countryHqDataValidator;
    private final CountryHqRowMapper countryHqRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public Response createCountryHq(CreateCountryHqRequest createCountryHqRequest) {
        try {
            this.countryHqDataValidator.validateSaveCountryHqData(createCountryHqRequest);
            final CountryHq countryHq = CountryHq.create(createCountryHqRequest);
            this.countryHqRepository.saveAndFlush(countryHq);
            return Response.of(Long.valueOf(countryHq.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateCountryHq(Integer id, UpdateCountryHqRequest updateCountryHqRequest) {
        try {
            this.countryHqDataValidator.validateUpdateCountryHqData(updateCountryHqRequest);
            final CountryHq countryHq = this.countryHqRepositoryWrapper.findOneWithNotFoundDetection(id);
            countryHq.update(updateCountryHqRequest);
            this.countryHqRepository.saveAndFlush(countryHq);
            return Response.of(Long.valueOf(countryHq.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}


