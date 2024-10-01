package com.ponsun.cms.company.commondto.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class CompanyCombineDTO {

    private CompanyDetailsDTO companyDetailsDTOS;
    private List<CompanyAliasesDTO> companyAliasesDTOS;

    public CompanyCombineDTO(CompanyDetailsDTO companyDetailsDTOS , List<CompanyAliasesDTO> companyAliasesDTOS) {
        this.companyDetailsDTOS = companyDetailsDTOS;
        this.companyAliasesDTOS = companyAliasesDTOS;
    }
    public CompanyCombineDTO newInstance (CompanyDetailsDTO companyDetailsDTOS , List<CompanyAliasesDTO> companyAliasesDTOS) {
        return new CompanyCombineDTO( companyDetailsDTOS , companyAliasesDTOS);
    }
}
