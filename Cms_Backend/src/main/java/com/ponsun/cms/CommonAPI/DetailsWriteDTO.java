package com.ponsun.cms.CommonAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.cms.CommonAPI.service.dto.UpdateCheckingData;
import com.ponsun.cms.IndCaseDetails.request.CreateIndCaseDetailsRequest;
import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.IndOrgCommonDTO;
import com.ponsun.cms.IndPositions.request.CreateIndPositionsRequest;
import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DetailsCombineDTO;
import com.ponsun.cms.bankDetails.request.CreateBankDetailsRequest;
import com.ponsun.cms.caseDetails.request.CreateCaseDetailsRequest;
import com.ponsun.cms.company.commondto.dto.CompanyCombineDTO;
import com.ponsun.cms.company.companyAliases.request.CreateCompanyAliasesRequest;
import com.ponsun.cms.company.companyDetails.request.CreateCompanyDetailsRequest;
import com.ponsun.cms.countryRegistration.request.CreateCountryRegistrationRequest;
import com.ponsun.cms.details.request.CreateDetailsRequest;
import com.ponsun.cms.details.request.UpdateDetailsRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailsWriteDTO {
    private UpdateCheckingData updateCheckingData;
    private UpdateDetailsRequest updateDetailsRequest;
    private CreateDetailsRequest createDetailsRequest;
    private List<DetailsCombineDTO> detailsCombineDTO;
    private List<CreateCountryRegistrationRequest> createCountryRegistrationRequest;
    private List<IndOrgCommonDTO> indOrgCommonDTO;
    private List<CreateCaseDetailsRequest> createCaseDetailsRequest;
    private List<CreateIndPositionsRequest> createIndPositionsRequests;
    private List<CreateIndCaseDetailsRequest> createIndCaseDetailsRequests;
    private List<CreateBankDetailsRequest> createBankDetailsRequests;
    private List<CompanyCombineDTO> companyCombineDTO;

    public DetailsWriteDTO (UpdateDetailsRequest updateDetailsRequest,
                            CreateDetailsRequest createDetailsRequest,
                            List<DetailsCombineDTO> detailsCombineDTOList,
                            List<CreateCountryRegistrationRequest> createCountryRegistrationRequestList,List<IndOrgCommonDTO> indOrgCommonDTO,
                            List<CreateCaseDetailsRequest> createCaseDetailsRequestList,List<CreateIndPositionsRequest> createIndPositionsRequests,List<CreateIndCaseDetailsRequest> createIndCaseDetailsRequestlist,List<CreateBankDetailsRequest> createBankDetailsRequests,List<CompanyCombineDTO> companyCombineDTO
    ) {
        this.updateDetailsRequest = updateDetailsRequest;
        this.createDetailsRequest = createDetailsRequest;
        this.detailsCombineDTO = detailsCombineDTOList;
        this.createCountryRegistrationRequest = createCountryRegistrationRequestList;
        this.indOrgCommonDTO = indOrgCommonDTO;
        this.createCaseDetailsRequest = createCaseDetailsRequestList;
        this.createIndPositionsRequests = createIndPositionsRequests;
        this.createIndCaseDetailsRequests = createIndCaseDetailsRequestlist;
        this.createBankDetailsRequests = createBankDetailsRequests;
        this.companyCombineDTO = companyCombineDTO;
    }

    public static DetailsWriteDTO newInstance (UpdateDetailsRequest updateDetailsRequest,
                                               CreateDetailsRequest createDetailsRequest,
                                               List<DetailsCombineDTO> detailsCombineDTOList,
                                               List<CreateCountryRegistrationRequest> createCountryRegistrationRequestList,List<IndOrgCommonDTO> indOrgCommonDTO,
                                               List<CreateCaseDetailsRequest> createCaseDetailsRequestList,List<CreateIndPositionsRequest> createIndPositionsRequests,
                                               List<CreateIndCaseDetailsRequest> createIndCaseDetailsRequestlist,
                                                       List<CreateBankDetailsRequest> createBankDetailsRequests,List<CompanyCombineDTO> companyCombineDTO
    ) {
        return new DetailsWriteDTO(updateDetailsRequest,createDetailsRequest,
                detailsCombineDTOList,
                createCountryRegistrationRequestList,
                indOrgCommonDTO,
                createCaseDetailsRequestList,createIndPositionsRequests,createIndCaseDetailsRequestlist,createBankDetailsRequests,companyCombineDTO);
    }
}
