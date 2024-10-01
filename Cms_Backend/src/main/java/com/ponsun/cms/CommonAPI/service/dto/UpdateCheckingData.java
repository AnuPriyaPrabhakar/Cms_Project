
package com.ponsun.cms.CommonAPI.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateCheckingData {
    private Boolean detailsEdit;
    private Boolean addressEdit;
    private Boolean caseEdit;
    private Boolean positionEdit;
    private Boolean countryEdit;
    private Boolean bankEdit;
    private Boolean comapnyEdit;
    private Boolean linkedIndividualEdit;
    private Boolean caseDetailsEdit;


    public UpdateCheckingData(Boolean detailsEdit, Boolean addressEdit, Boolean caseEdit, Boolean positionEdit, Boolean countryEdit, Boolean bankEdit, Boolean comapnyEdit, Boolean linkedIndividualEdit, Boolean caseDetailsEdit) {
        this.detailsEdit = detailsEdit;
        this.addressEdit = addressEdit;
        this.caseEdit = caseEdit;
        this.positionEdit = positionEdit;
        this.countryEdit = countryEdit;
        this.bankEdit = bankEdit;
        this.comapnyEdit = comapnyEdit;
        this.linkedIndividualEdit = linkedIndividualEdit;
        this.caseDetailsEdit = caseDetailsEdit;
    }
    public static UpdateCheckingData newInstance(Boolean detailsEdit, Boolean addressEdit, Boolean caseEdit, Boolean positionEdit, Boolean countryEdit, Boolean bankEdit, Boolean comapnyEdit, Boolean linkedIndividualEdit, Boolean caseDetailsEdit){
        return new UpdateCheckingData(detailsEdit, addressEdit,caseEdit, positionEdit, countryEdit, bankEdit, comapnyEdit, linkedIndividualEdit, caseDetailsEdit);
    }
}

