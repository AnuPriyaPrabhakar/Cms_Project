package com.ponsun.cms.CommonAPI;


import com.ponsun.cms.IndCaseDetails.request.CreateIndCaseDetailsRequest;
import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.IndOrgCommonDTO;
import com.ponsun.cms.IndPositions.request.CreateIndPositionsRequest;
import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DetailsCombineDTO;
import com.ponsun.cms.bankDetails.request.CreateBankDetailsRequest;
import com.ponsun.cms.caseDetails.request.CreateCaseDetailsRequest;
import com.ponsun.cms.company.companyDetails.request.CreateCompanyDetailsRequest;
import com.ponsun.cms.countryRegistration.request.CreateCountryRegistrationRequest;
import com.ponsun.cms.details.request.CreateDetailsRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class DetailsCommonDTO {

    private CreateDetailsRequest createDetailsRequest;
    private List<DetailsCombineDTO> detailsCombineDTO;
    private List<CreateCountryRegistrationRequest> createCountryRegistrationRequest;
    private List<IndOrgCommonDTO> indOrgCommonDTO;
    private List<CreateCaseDetailsRequest> createCaseDetailsRequest;
    private List<CreateIndPositionsRequest> createIndPositionsRequests;
    private List<CreateIndCaseDetailsRequest> createIndCaseDetailsRequest;
    private List<CreateBankDetailsRequest> createBankDetailsRequests;
    private List<CreateCompanyDetailsRequest> createCompanyDetailsRequests;

    public DetailsCommonDTO (CreateDetailsRequest createDetailsRequest,
                             List<DetailsCombineDTO> detailsCombineDTOList,
                             List<CreateCountryRegistrationRequest> createCountryRegistrationRequestList,List<IndOrgCommonDTO> indOrgCommonDTO,
                             List<CreateCaseDetailsRequest> createCaseDetailsRequestList,
                             List<CreateIndPositionsRequest> createIndPositionsRequests,
                             List<CreateIndCaseDetailsRequest> createIndCaseDetailsRequestlist,
                             List<CreateBankDetailsRequest> createBankDetailsRequests,List<CreateCompanyDetailsRequest> createCompanyDetailsRequests
    ) {
        this.createDetailsRequest = createDetailsRequest;
        this.detailsCombineDTO = detailsCombineDTOList;
        this.createCountryRegistrationRequest = createCountryRegistrationRequestList;
        this.indOrgCommonDTO = indOrgCommonDTO;
        this.createCaseDetailsRequest = createCaseDetailsRequestList;
        this.createIndPositionsRequests = createIndPositionsRequests;
        this.createIndCaseDetailsRequest = createIndCaseDetailsRequestlist;
        this.createBankDetailsRequests = createBankDetailsRequests;
        this.createCompanyDetailsRequests = createCompanyDetailsRequests;


    }

    public static DetailsCommonDTO newInstance (CreateDetailsRequest createDetailsRequest,
                                                List<DetailsCombineDTO> detailsCombineDTOList,
                                                List<CreateCountryRegistrationRequest> createCountryRegistrationRequestList,List<IndOrgCommonDTO> indOrgCommonDTO,
                                                List<CreateCaseDetailsRequest> createCaseDetailsRequestList,List<CreateIndPositionsRequest> createIndPositionsRequests,List<CreateIndCaseDetailsRequest> createIndCaseDetailsRequestlist,List<CreateBankDetailsRequest> createBankDetailsRequests,List<CreateCompanyDetailsRequest> createCompanyDetailsRequests
    ) {
        return new DetailsCommonDTO(createDetailsRequest,
                detailsCombineDTOList,
                createCountryRegistrationRequestList,
                indOrgCommonDTO,
                createCaseDetailsRequestList,createIndPositionsRequests,createIndCaseDetailsRequestlist,createBankDetailsRequests,createCompanyDetailsRequests);
    }
}
