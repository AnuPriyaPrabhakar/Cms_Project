package com.ponsun.cms.allDetails.CombinedServices.writeDTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class DetailsCombineDTO {

    private List<AddressDTO> addressDTOS;
    private List<DateOfBirthDTO> dateOfBirthDTOS;
    private List<AliasesDTO> aliasesDTOS;

    public DetailsCombineDTO( List<AddressDTO> addressDTOS ,List<DateOfBirthDTO> dateOfBirthDTOS,List<AliasesDTO> aliasesDTOS) {
        this.addressDTOS = addressDTOS;
        this.dateOfBirthDTOS = dateOfBirthDTOS;
        this.aliasesDTOS = aliasesDTOS;
    }
    public DetailsCombineDTO newInstance( List<AddressDTO> addressDTOS ,List<DateOfBirthDTO> dateOfBirthDTOS,List<AliasesDTO> aliasesDTOS) {
        return new DetailsCombineDTO( addressDTOS , dateOfBirthDTOS,aliasesDTOS);
    }
}
