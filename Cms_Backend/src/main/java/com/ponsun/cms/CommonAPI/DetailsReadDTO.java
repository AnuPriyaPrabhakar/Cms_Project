package com.ponsun.cms.CommonAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.cms.IndCaseDetails.data.IndCaseDetailsData;
import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.IndOrgCommonDTO;
import com.ponsun.cms.IndPositions.data.IndPositionsData;
import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DetailsCombineDTO;
import com.ponsun.cms.bankDetails.data.BankDetailsData;
import com.ponsun.cms.caseDetails.data.CaseDetailsData;
import com.ponsun.cms.company.commondto.dto.CompanyCombineDTO;
import com.ponsun.cms.company.commondto.dto.CompanyDetailsDTO;
import com.ponsun.cms.company.companyAliases.data.CompanyAliasesData;
import com.ponsun.cms.company.companyDetails.data.CompanyDetailsData;
import com.ponsun.cms.countryRegistration.data.CountryRegistrationData;
import com.ponsun.cms.details.request.CreateDetailsRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailsReadDTO {
    private CreateDetailsRequest createDetailsRequest;
    private List<DetailsCombineDTO> detailsCombineDTO;
    private List<CountryRegistrationData> countryRegistrationData;
    private List<IndOrgCommonDTO> indOrgCommonDTO;
    private List<CaseDetailsData> caseDetailsData;
    private List<IndPositionsData> indPositionsData;
    private List<IndCaseDetailsData> indCaseDetailsData;
    private List<BankDetailsData> bankDetailsData;
    private List<CompanyCombineDTO> companyCombineDTO;


    public DetailsReadDTO (CreateDetailsRequest createDetailsRequest, List<DetailsCombineDTO> detailsCombineDTOList, List<CountryRegistrationData> countryRegistrationData,List<IndOrgCommonDTO> indOrgCommonDTO,
                           List<CaseDetailsData> caseDetailsData,
                           List<IndPositionsData> indPositionsData,List<IndCaseDetailsData> indCaseDetailsData,
                           List<BankDetailsData> bankDetailsData,List<CompanyCombineDTO> companyCombineDTO
    ) {
        this.createDetailsRequest = createDetailsRequest;
        this.detailsCombineDTO = detailsCombineDTOList;
        this.countryRegistrationData = countryRegistrationData;
        this.indOrgCommonDTO = indOrgCommonDTO;
        this.caseDetailsData = caseDetailsData;
        this.indPositionsData = indPositionsData;
        this.indCaseDetailsData = indCaseDetailsData;
        this.bankDetailsData = bankDetailsData;
        this.companyCombineDTO = companyCombineDTO;
    }

    public static DetailsReadDTO newInstance (CreateDetailsRequest createDetailsRequest, List<DetailsCombineDTO> detailsCombineDTOList, List<CountryRegistrationData> countryRegistrationData,List<IndOrgCommonDTO> indOrgCommonDTO,List<CaseDetailsData> caseDetailsData,
                                              List<IndPositionsData> indPositionsData,List<IndCaseDetailsData> indCaseDetailsData,
                                              List<BankDetailsData> bankDetailsData,List<CompanyCombineDTO> companyCombineDTO
    ) {
        return new DetailsReadDTO(createDetailsRequest,
                detailsCombineDTOList,
                countryRegistrationData,
                indOrgCommonDTO,
                caseDetailsData,indPositionsData,indCaseDetailsData,bankDetailsData,companyCombineDTO);
    }
}
