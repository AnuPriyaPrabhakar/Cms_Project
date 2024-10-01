package com.ponsun.cms.company.companyDetails.services;


import com.ponsun.cms.company.commondto.dto.CompanyDetailsDTO;
import com.ponsun.cms.company.companyDetails.data.CompanyDetailsDataValidator;
import com.ponsun.cms.company.companyDetails.domain.CompanyDetails;
import com.ponsun.cms.company.companyDetails.domain.CompanyDetailsRepository;
import com.ponsun.cms.company.companyDetails.domain.CompanyDetailsRepositoryWrapper;
import com.ponsun.cms.company.companyDetails.request.CreateCompanyDetailsRequest;
import com.ponsun.cms.company.companyDetails.rowmapper.CompanyDetailsRowMapper;
import com.ponsun.cms.company.companyDetails.request.UpdateCompanyDetailsRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyDetailsWritePlatFormServiceImpl implements CompanyDetailsWritePlatFormService {

    private final CompanyDetailsRepository companyDetailsRepository;
    private final CompanyDetailsRepositoryWrapper companyDetailsRepositoryWrapper;
    private final CompanyDetailsDataValidator companyDetailsDataValidator;
    private final CompanyDetailsRowMapper companyDetailsRowMapper;
    private final JdbcTemplate jdbcTemplate;


    public Response createCompanyDetails(CreateCompanyDetailsRequest createCompanyDetailsRequest) {
        try {
            final CompanyDetails companyDetails = CompanyDetails.create(createCompanyDetailsRequest);
            this.companyDetailsRepository.saveAndFlush(companyDetails);
            return Response.of(companyDetails.getUid());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateCompanyDetails(Integer id, UpdateCompanyDetailsRequest updateCompanyDetailsRequest) {
        try {
            this.companyDetailsDataValidator.validateUpdateCompanyDetailsData(updateCompanyDetailsRequest);
            final CompanyDetails companyDetails = this.companyDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            companyDetails.update(updateCompanyDetailsRequest);
            this.companyDetailsRepository.saveAndFlush(companyDetails);
            return Response.of(Long.valueOf(companyDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<CompanyDetailsDTO> fetchAllCompanyDetailsData(Integer cmsId) {
        final CompanyDetailsRowMapper rowMapper = new CompanyDetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE company.cmsId = ?  AND company.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<CompanyDetailsDTO> companyDetailsDTOList = jdbcTemplate.query(Qry, companyDetailsRowMapper,
                new Object[] {cmsId}
        );
        return companyDetailsDTOList;
    }

    @Override
    @Transactional
    public Response deActivate(Integer cmsId , Integer euid){
        try {

            Response response = null;
            updateCompanyDetail(cmsId ,euid);
            updateCompanyAliases(cmsId,euid);
            return response;

        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    public void updateCompanyDetail(Integer cmsId ,Integer euid) {
        String updateQuery = "UPDATE cms_company_details SET STATUS = 'D' , euid= ? , updated_at = NOW() WHERE cmsId = ? ";
        this.jdbcTemplate.update(updateQuery, euid, cmsId);
    }

    private Integer getCompanyId(Integer cmsId ) {
        String selectQuery = "SELECT id FROM cms_company_details WHERE cmsId=? AND STATUS = 'A' LIMIT 1";
        try {
            return this.jdbcTemplate.queryForObject(selectQuery, Integer.class, cmsId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public void updateCompanyAliases(Integer cmsId, Integer euid) {
        Integer companyId = getCompanyId(cmsId);
        String updateQuery = "UPDATE cms_company_aliases SET STATUS = 'D' , euid= ? , updated_at = NOW() WHERE cmsId = ? AND companyId = ? ";
        this.jdbcTemplate.update(updateQuery, euid, cmsId,companyId);
    }
}