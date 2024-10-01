package com.ponsun.cms.company.commondto.services;

import com.ponsun.cms.company.commondto.dto.CompanyAliasesDTO;
import com.ponsun.cms.company.commondto.dto.CompanyCombineDTO;
import com.ponsun.cms.company.companyAliases.domain.CompanyAliases;
import com.ponsun.cms.company.companyAliases.domain.CompanyAliasesRepository;
import com.ponsun.cms.company.companyAliases.request.CreateCompanyAliasesRequest;
import com.ponsun.cms.company.companyDetails.domain.CompanyDetails;
import com.ponsun.cms.company.companyDetails.domain.CompanyDetailsRepository;
import com.ponsun.cms.company.companyDetails.request.CreateCompanyDetailsRequest;
import com.ponsun.cms.company.companyDetails.services.CompanyDetailsWritePlatFormService;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class CommonDtoWriteServiceImpl implements CommonDtoWriteService {

    private final CompanyDetailsRepository companyDetailsRepository;
    private final CompanyAliasesRepository companyAliasesRepository;
    private final CompanyDetailsWritePlatFormService companyDetailsWritePlatFormService;

    @Override
    @Transactional
    public Response createCompanyDetails(Integer cmsId, List<CompanyCombineDTO> companyCombineDTO) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();
            for (CompanyCombineDTO dto : companyCombineDTO) {

                CreateCompanyDetailsRequest request = modelMapper.map(dto.getCompanyDetailsDTOS(), CreateCompanyDetailsRequest.class);

                CompanyDetails companyDetails = CompanyDetails.create(request);
                companyDetails.setCmsId(cmsId);
                this.companyDetailsRepository.save(companyDetails);
                int companyId = companyDetails.getId();
                response = Response.of(companyDetails.getId());

                for (CompanyAliasesDTO companyAliasesDTO : dto.getCompanyAliasesDTOS()) {
                    CreateCompanyAliasesRequest createCompanyAliasesRequest = modelMapper.map(companyAliasesDTO, CreateCompanyAliasesRequest.class);
                    createCompanyAliasesRequest.setCompanyId(companyId);
                    createCompanyAliasesRequest.setCmsId(cmsId);
                    CompanyAliases companyAliases = CompanyAliases.create(createCompanyAliasesRequest);
                    this.companyAliasesRepository.save(companyAliases);
                }
            }

            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Response updateCompanyDetails(Integer cmsId, Integer euid, List<CompanyCombineDTO> companyCombineDTO) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();
            this.companyDetailsWritePlatFormService.deActivate(cmsId, euid);
            for (CompanyCombineDTO dto : companyCombineDTO) {
                CreateCompanyDetailsRequest request = modelMapper.map(dto.getCompanyDetailsDTOS(), CreateCompanyDetailsRequest.class);
                final CompanyDetails companyDetails = CompanyDetails.create(request);
                companyDetails.setCmsId(cmsId);
                this.companyDetailsRepository.save(companyDetails);
                int companyId = companyDetails.getId();
                response = Response.of(companyDetails.getId());

                for (CompanyAliasesDTO companyAliasesDTO : dto.getCompanyAliasesDTOS()) {
                    CreateCompanyAliasesRequest createCompanyAliasesRequest = modelMapper.map(companyAliasesDTO, CreateCompanyAliasesRequest.class);
                    createCompanyAliasesRequest.setCompanyId(companyId);
                    createCompanyAliasesRequest.setCmsId(cmsId);
                    final CompanyAliases companyAliases = CompanyAliases.create(createCompanyAliasesRequest);
                    this.companyAliasesRepository.save(companyAliases);
                }
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}
