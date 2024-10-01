package com.ponsun.cms.countryRegistration.services;

import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.countryRegistration.data.CountryRegistrationData;
import com.ponsun.cms.countryRegistration.data.CountryRegistrationDataValidator;
import com.ponsun.cms.countryRegistration.domain.CountryRegistration;
import com.ponsun.cms.countryRegistration.domain.CountryRegistrationRepository;
import com.ponsun.cms.countryRegistration.domain.CountryRegistrationRepositoryWrapper;
import com.ponsun.cms.countryRegistration.request.CreateCountryRegistrationRequest;
import com.ponsun.cms.countryRegistration.request.UpdateCountryRegistrationRequest;
import com.ponsun.cms.countryRegistration.rowmapper.CountryRegistrationRowMapper;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryRegistrationWritePlatformServiceImpl implements CountryRegistrationWritePlatformService {
    private final CountryRegistrationRepository countryRegistrationRepository;
    private final CountryRegistrationRepositoryWrapper countryRegistrationRepositoryWrapper;
    private final CountryRegistrationDataValidator countryRegistrationDataValidator;
    private final CountryRegistrationRowMapper countryRegistrationRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Override
    @Transactional
    public Response createCountryRegistration(CreateCountryRegistrationRequest createCountryRegistrationRequest){
        try{
            this.countryRegistrationDataValidator.validateSaveCountryRegistrationData(createCountryRegistrationRequest);
            final CountryRegistration countryRegistration = CountryRegistration.create(createCountryRegistrationRequest);
            this.countryRegistrationRepository.saveAndFlush(countryRegistration);
            return Response.of(countryRegistration.getId());
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateCountryRegistration(Integer id, UpdateCountryRegistrationRequest updateCountryRegistrationRequest) {
        try {
            this.countryRegistrationDataValidator.validateUpdateCountryRegistrationData(updateCountryRegistrationRequest);
            final CountryRegistration countryRegistration = this.countryRegistrationRepositoryWrapper.findOneWithNotFoundDetection(id);
            countryRegistration.update(updateCountryRegistrationRequest);
            this.countryRegistrationRepository.saveAndFlush(countryRegistration);
            return Response.of(Long.valueOf(countryRegistration.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    public List<CountryRegistrationData> fetchAllCountryRegistrationData(Integer cmsId) {
        final CountryRegistrationRowMapper rowMapper = new CountryRegistrationRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE cd.cmsId = ?  AND cd.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<CountryRegistrationData> countryRegistrationDataList  = jdbcTemplate.query(Qry,countryRegistrationRowMapper,
                new Object[] {cmsId}
        );
        return countryRegistrationDataList;
    }

    @Override
    @Transactional
    public Response deactive(Integer cmsId, Integer euid){
        try{
            List<CountryRegistration> countryRegistrations = this.countryRegistrationRepositoryWrapper.findCmsIdNotFoundDetection(cmsId);
            Response response = null;
            for (CountryRegistration countryRegistration : countryRegistrations) {
                countryRegistration.setEuid(euid);
                countryRegistration.setStatus(Status.DELETE);
                countryRegistration.setUpdatedAt(LocalDateTime.now());
                response = Response.of(countryRegistration.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}
