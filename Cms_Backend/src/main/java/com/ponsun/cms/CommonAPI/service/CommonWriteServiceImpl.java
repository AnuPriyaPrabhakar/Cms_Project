package com.ponsun.cms.CommonAPI.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ponsun.cms.CommonAPI.DetailsReadDTO;
import com.ponsun.cms.CommonAPI.DetailsWriteDTO;
import com.ponsun.cms.CommonAPI.service.dto.UpdateCheckingData;
import com.ponsun.cms.FilesStorage.service.FileStorageWritePlatformService;
import com.ponsun.cms.IndCaseDetails.data.IndCaseDetailsData;
import com.ponsun.cms.IndCaseDetails.request.CreateIndCaseDetailsRequest;
import com.ponsun.cms.IndCaseDetails.services.IndCaseDetailsWritePlatFormService;
import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.IndOrgCommonDTO;
import com.ponsun.cms.IndOrg.IndOrgCommonService.service.IndOrgCommonReadPlatformService;
import com.ponsun.cms.IndOrg.IndOrgCommonService.service.IndOrgCommonWritePlatformService;
import com.ponsun.cms.IndPositions.data.IndPositionsData;
import com.ponsun.cms.IndPositions.request.CreateIndPositionsRequest;
import com.ponsun.cms.IndPositions.services.IndPositionsWritePlatformService;
import com.ponsun.cms.allDetails.CombinedServices.service.DetailsCombinedReadService;
import com.ponsun.cms.allDetails.CombinedServices.service.DetailsCombinedWriteService;
import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DetailsCombineDTO;
import com.ponsun.cms.bankDetails.data.BankDetailsData;
import com.ponsun.cms.bankDetails.request.CreateBankDetailsRequest;
import com.ponsun.cms.bankDetails.services.BankDetailsWritePlatFormService;
import com.ponsun.cms.caseDetails.data.CaseDetailsData;
import com.ponsun.cms.caseDetails.request.CreateCaseDetailsRequest;
import com.ponsun.cms.caseDetails.services.CaseDetailsWritePlatFormService;
import com.ponsun.cms.company.commondto.dto.CompanyCombineDTO;
import com.ponsun.cms.company.commondto.services.CommonDtoReadService;
import com.ponsun.cms.company.commondto.services.CommonDtoWriteService;
import com.ponsun.cms.company.companyAliases.data.CompanyAliasesData;
import com.ponsun.cms.company.companyAliases.request.CreateCompanyAliasesRequest;
import com.ponsun.cms.company.companyAliases.services.CompanyAliasesWriteService;
import com.ponsun.cms.company.companyDetails.data.CompanyDetailsData;
import com.ponsun.cms.company.companyDetails.request.CreateCompanyDetailsRequest;
import com.ponsun.cms.company.companyDetails.services.CompanyDetailsWritePlatFormService;
import com.ponsun.cms.countryRegistration.data.CountryRegistrationData;
import com.ponsun.cms.countryRegistration.request.CreateCountryRegistrationRequest;
import com.ponsun.cms.countryRegistration.services.CountryRegistrationWritePlatformService;
import com.ponsun.cms.details.domain.Details;
import com.ponsun.cms.details.request.CreateDetailsRequest;
import com.ponsun.cms.details.request.UpdateDetailsRequest;
import com.ponsun.cms.details.services.DetailsReadPlatformService;
import com.ponsun.cms.details.services.DetailsWritePlatformService;
import com.ponsun.cms.infrastructure.utils.Response;

import com.ponsun.cms.taskReassign.services.TaskReassignWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class CommonWriteServiceImpl implements CommonWriteService {
    private final CountryRegistrationWritePlatformService countryRegistrationWritePlatformService;
    private final CaseDetailsWritePlatFormService caseDetailsWritePlatFormService;
    private final DetailsWritePlatformService detailsWritePlatformService;
    private final DetailsCombinedWriteService detailsCombinedWriteService;
    private final IndOrgCommonWritePlatformService indOrgCommonWritePlatformService;
    private final IndPositionsWritePlatformService indPositionsWritePlatformService;
    private final IndCaseDetailsWritePlatFormService indCaseDetailsWritePlatFormService;
    private final BankDetailsWritePlatFormService bankDetailsWritePlatFormService;
    private final CommonDtoWriteService commonDtoWriteService;
    private final TaskReassignWritePlatformService taskReassignWritePlatformService;


    private final DetailsReadPlatformService detailsReadPlatformService;
    private final DetailsCombinedReadService detailsCombinedReadService;
    private final CommonDtoReadService commonDtoReadService;
    private final IndOrgCommonReadPlatformService indOrgCommonReadPlatformService;
    private final FileStorageWritePlatformService fileStorageWritePlatformService;




    @Override
    @Transactional
    public Response saveDetails(String detailsDTO, MultipartFile[] documentfiles, Integer[] pathId, Integer imgName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        try {
            DetailsWriteDTO detailsWriteDTO = objectMapper.readValue(detailsDTO, DetailsWriteDTO.class);
            CreateDetailsRequest createDetailsRequest = detailsWriteDTO.getCreateDetailsRequest();
            List<DetailsCombineDTO> detailsCombineDTO = detailsWriteDTO.getDetailsCombineDTO();
            List<CreateCountryRegistrationRequest> createCountryRegistrationRequest = detailsWriteDTO.getCreateCountryRegistrationRequest();
            List<IndOrgCommonDTO> indOrgCommonDTO = detailsWriteDTO.getIndOrgCommonDTO();
            List<CreateCaseDetailsRequest> createCaseDetailsRequest = detailsWriteDTO.getCreateCaseDetailsRequest();
            List<CreateIndPositionsRequest> createIndPositionsRequests = detailsWriteDTO.getCreateIndPositionsRequests();
            List<CreateIndCaseDetailsRequest> createIndCaseDetailsRequests = detailsWriteDTO.getCreateIndCaseDetailsRequests();
            List<CreateBankDetailsRequest> createBankDetailsRequests = detailsWriteDTO.getCreateBankDetailsRequests();
            List<CompanyCombineDTO> companyCombineDTO = detailsWriteDTO.getCompanyCombineDTO();


            Response response = this.detailsWritePlatformService.createDetails(createDetailsRequest);
            Integer cmsId = (Integer) response.getId();


            this.taskReassignWritePlatformService.createTaskAssign(cmsId, createDetailsRequest.getUid());

            if (!indOrgCommonDTO.isEmpty()) {
                this.indOrgCommonWritePlatformService.createIndOrgDetails(cmsId, indOrgCommonDTO);
            }

            if (!detailsCombineDTO.isEmpty()) {
                this.detailsCombinedWriteService.createDetail(cmsId, detailsCombineDTO);
            }

            if (!companyCombineDTO.isEmpty()) {
                this.commonDtoWriteService.createCompanyDetails(cmsId, companyCombineDTO);
                System.out.println("companyCombineDTO:"+companyCombineDTO);
            }

            for (CreateCountryRegistrationRequest dto : createCountryRegistrationRequest) {
                dto.setCmsId(cmsId);
                this.countryRegistrationWritePlatformService.createCountryRegistration(dto);
            }

            if (!createCaseDetailsRequest.isEmpty()) {
                for (CreateCaseDetailsRequest dto : createCaseDetailsRequest) {
                    dto.setCmsId(cmsId);
                    this.caseDetailsWritePlatFormService.createCaseDetails(dto);
                }
            }

            if (!createIndPositionsRequests.isEmpty()) {
                for (CreateIndPositionsRequest dto : createIndPositionsRequests) {
                    dto.setCmsId(cmsId);
                    this.indPositionsWritePlatformService.createIndPositions(dto);
                }
            }


            if (!createIndCaseDetailsRequests.isEmpty()) {
                for (CreateIndCaseDetailsRequest dto : createIndCaseDetailsRequests) {
                    dto.setCmsId(cmsId);
                    this.indCaseDetailsWritePlatFormService.createIndCaseDetails(dto);
                }
            }


            if (!createBankDetailsRequests.isEmpty()) {
                for (CreateBankDetailsRequest dto : createBankDetailsRequests) {
                    dto.setCmsId(cmsId);
                    this.bankDetailsWritePlatFormService.createBankDetails(dto);
                }
            }

            List<String> messages = new ArrayList<>();
            try {
                if (documentfiles != null && documentfiles.length > 0 && pathId != null && pathId.length == documentfiles.length) {
                    for (int j = 0; j < documentfiles.length; j++) {
                        if (documentfiles[j] != null) {
                            fileStorageWritePlatformService.documentsave(documentfiles[j], cmsId, pathId[j], imgName);
                            messages.add(documentfiles[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            return new Response();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Response updateDetails(String detailsDTO, Integer cmsId, Integer euid, MultipartFile[] documentfiles, Integer[] pathId, Integer imgName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        try {
            DetailsWriteDTO detailsWriteDTO = objectMapper.readValue(detailsDTO, DetailsWriteDTO.class);
            UpdateCheckingData updateCheckingData = detailsWriteDTO.getUpdateCheckingData();
            UpdateDetailsRequest updateDetailsRequest = detailsWriteDTO.getUpdateDetailsRequest();
            List<DetailsCombineDTO> detailsCombineDTO = detailsWriteDTO.getDetailsCombineDTO();
            List<CreateCountryRegistrationRequest> createCountryRegistrationRequest = detailsWriteDTO.getCreateCountryRegistrationRequest();
            List<IndOrgCommonDTO> indOrgCommonDTO = detailsWriteDTO.getIndOrgCommonDTO();
            List<CreateCaseDetailsRequest> createCaseDetailsRequest = detailsWriteDTO.getCreateCaseDetailsRequest();
            List<CreateIndPositionsRequest> createIndPositionsRequests = detailsWriteDTO.getCreateIndPositionsRequests();
            List<CreateIndCaseDetailsRequest> createIndCaseDetailsRequests = detailsWriteDTO.getCreateIndCaseDetailsRequests();
            List<CreateBankDetailsRequest> createBankDetailsRequests = detailsWriteDTO.getCreateBankDetailsRequests();
            List<CompanyCombineDTO> companyCombineDTO = detailsWriteDTO.getCompanyCombineDTO();

            System.out.println("updateCheckingData : "+updateCheckingData);

            if (updateCheckingData.getDetailsEdit() != null) {
                if (updateDetailsRequest != null && !updateDetailsRequest.equals("")) {
                    this.detailsWritePlatformService.updateDetails(cmsId, updateDetailsRequest);
                }
            }

            if (updateCheckingData.getLinkedIndividualEdit() != null) {
                if (indOrgCommonDTO != null && !indOrgCommonDTO.equals("")) {
                    this.indOrgCommonWritePlatformService.createAndUpdateIndOrgDetails(cmsId, euid, indOrgCommonDTO);
                }
            }

            if (updateCheckingData.getAddressEdit() != null) {
                if (!detailsCombineDTO.isEmpty()) {
                    this.detailsCombinedWriteService.createAndUpdateDetails(cmsId, euid, detailsCombineDTO);
                }
            }

            if (updateCheckingData.getComapnyEdit() != null) {
                if (!companyCombineDTO.isEmpty()) {
                    this.commonDtoWriteService.updateCompanyDetails(cmsId, euid, companyCombineDTO);
                    System.out.println("companyCombineDTO:"+companyCombineDTO);
                }
            }


            if (updateCheckingData.getCountryEdit() != null) {
                if (createCountryRegistrationRequest != null && !createCountryRegistrationRequest.isEmpty()) {
                    this.countryRegistrationWritePlatformService.deactive(cmsId, euid);
                    for (CreateCountryRegistrationRequest dto : createCountryRegistrationRequest) {
                        dto.setCmsId(cmsId);
                        this.countryRegistrationWritePlatformService.createCountryRegistration(dto);
                    }
                }
            }

            if (updateCheckingData.getCaseDetailsEdit() != null) {
                if (createCaseDetailsRequest != null && !createCaseDetailsRequest.isEmpty()) {
                    this.caseDetailsWritePlatFormService.deactive(cmsId, euid);
                    for (CreateCaseDetailsRequest dto : createCaseDetailsRequest) {
                        dto.setCmsId(cmsId);
                        this.caseDetailsWritePlatFormService.createCaseDetails(dto);
                    }
                }
            }

            if (updateCheckingData.getPositionEdit() != null) {
                if (createIndPositionsRequests != null && !createIndPositionsRequests.isEmpty()) {
                    this.indPositionsWritePlatformService.deactive(cmsId, euid);
                    for (CreateIndPositionsRequest dto : createIndPositionsRequests) {
                        dto.setCmsId(cmsId);
                        this.indPositionsWritePlatformService.createIndPositions(dto);
                    }
                }
            }

            if (updateCheckingData.getCaseEdit() != null) {
                if (createIndCaseDetailsRequests != null && !createIndCaseDetailsRequests.isEmpty()) {
                    this.indCaseDetailsWritePlatFormService.deactive(cmsId, euid);
                    for (CreateIndCaseDetailsRequest dto : createIndCaseDetailsRequests) {
                        dto.setCmsId(cmsId);
                        this.indCaseDetailsWritePlatFormService.createIndCaseDetails(dto);
                    }
                }
            }

            if (updateCheckingData.getBankEdit() != null) {
                if (createBankDetailsRequests != null && !createBankDetailsRequests.isEmpty()) {
                    this.bankDetailsWritePlatFormService.deactive(cmsId, euid);
                    for (CreateBankDetailsRequest dto : createBankDetailsRequests) {
                        dto.setCmsId(cmsId);
                        this.bankDetailsWritePlatFormService.createBankDetails(dto);
                    }
                }
            }



            List<String> messages = new ArrayList<>();
            try {
                if (documentfiles != null && documentfiles.length > 0 && pathId != null && pathId.length == documentfiles.length) {
                    for (int j = 0; j < documentfiles.length; j++) {
                        if (documentfiles[j] != null) {
                            fileStorageWritePlatformService.documentsave(documentfiles[j], cmsId, pathId[j], imgName);
                            messages.add(documentfiles[j].getOriginalFilename() + " [Successful]");
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return new Response();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DetailsReadDTO getDetails(Integer cmsId) {
        ModelMapper modelMapper = new ModelMapper();
        DetailsReadDTO detailsReadDTO = new DetailsReadDTO();
        Details details = this.detailsReadPlatformService.fetchDetailsById(cmsId);
        List<DetailsCombineDTO> detailsCombineDTOS = detailsCombinedReadService.getDetails(cmsId);
        List<CountryRegistrationData> countryRegistrationData = this.countryRegistrationWritePlatformService.fetchAllCountryRegistrationData(cmsId);
        List<IndOrgCommonDTO> indOrgCommonDTOS = indOrgCommonReadPlatformService.getIndOrgDetails(cmsId);
        List<CaseDetailsData> caseDetailsData = caseDetailsWritePlatFormService.fetchAllCaseDetailsData(cmsId);
        List<IndPositionsData> indPositionsData = indPositionsWritePlatformService.fetchIndPositionsData(cmsId);
        List<IndCaseDetailsData> indCaseDetailsData = indCaseDetailsWritePlatFormService.fetchAllCaseDetailsData(cmsId);
        List<BankDetailsData> bankDetailsData = bankDetailsWritePlatFormService.fetchAllBankDetailsData(cmsId);
        List<CompanyCombineDTO> companyCombineDTOS = commonDtoReadService.getCompanyDetails(cmsId);

        CreateDetailsRequest createDetailsRequest = modelMapper.map(details, CreateDetailsRequest.class);

        detailsReadDTO.setCreateDetailsRequest(createDetailsRequest);
        detailsReadDTO.setDetailsCombineDTO(detailsCombineDTOS);
        detailsReadDTO.setCountryRegistrationData(countryRegistrationData);
        detailsReadDTO.setIndOrgCommonDTO(indOrgCommonDTOS);
        detailsReadDTO.setCaseDetailsData(caseDetailsData);
        detailsReadDTO.setIndPositionsData(indPositionsData);
        detailsReadDTO.setIndCaseDetailsData(indCaseDetailsData);
        detailsReadDTO.setBankDetailsData(bankDetailsData);
        detailsReadDTO.setCompanyCombineDTO(companyCombineDTOS);
        return detailsReadDTO;
    }
}


