package com.ponsun.cms.company.commondto.services;


import com.ponsun.cms.IndOrg.positions.data.PositionsData;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.company.commondto.dto.CompanyAliasesDTO;
import com.ponsun.cms.company.commondto.dto.CompanyCombineDTO;
import com.ponsun.cms.company.commondto.dto.CompanyDetailsDTO;
import com.ponsun.cms.company.companyAliases.services.CompanyAliasesWriteService;
import com.ponsun.cms.company.companyDetails.data.CompanyDetailsData;
import com.ponsun.cms.company.companyDetails.domain.CompanyDetails;
import com.ponsun.cms.company.companyDetails.domain.CompanyDetailsRepository;
import com.ponsun.cms.company.companyDetails.request.CreateCompanyDetailsRequest;
import com.ponsun.cms.company.companyDetails.services.CompanyDetailsWritePlatFormService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CommonDtoReadServiceImpl implements CommonDtoReadService {

    private final CompanyDetailsWritePlatFormService companyDetailsWritePlatFormService;
    private final CompanyAliasesWriteService companyAliasesWriteService;
    private final CompanyDetailsRepository companyDetailsRepository;

    @Override
    @Transactional
    public List<CompanyCombineDTO> getCompanyDetails(Integer cmsId) {
        List<CompanyDetails> companyDetailsList = companyDetailsRepository.findByCmsIdAndStatus(cmsId, Status.ACTIVE);
        ModelMapper modelMapper = new ModelMapper();
        List<CompanyCombineDTO> companyCombineDTOList = new ArrayList<>();

        for (CompanyDetails companyDetails : companyDetailsList) {
            CompanyDetailsDTO companyDetailsDTO = modelMapper.map(companyDetails, CompanyDetailsDTO.class);
            Integer companyId = companyDetailsDTO.getId();

            List<CompanyAliasesDTO> companyAliasesDTOList = companyAliasesWriteService.fetchAllCompanyAliasesData(cmsId, companyId);

            CompanyCombineDTO companyCombineDTO = new CompanyCombineDTO();
            companyCombineDTO.setCompanyDetailsDTOS(companyDetailsDTO);
            companyCombineDTO.setCompanyAliasesDTOS(companyAliasesDTOList);

            companyCombineDTOList.add(companyCombineDTO);
        }

        return companyCombineDTOList;
    }
}