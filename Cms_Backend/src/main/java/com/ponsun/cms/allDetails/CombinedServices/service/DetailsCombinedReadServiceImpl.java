package com.ponsun.cms.allDetails.CombinedServices.service;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.*;
import com.ponsun.cms.allDetails.address.domain.AddressRepository;
import com.ponsun.cms.allDetails.address.services.AddressWritePlatformService;
import com.ponsun.cms.allDetails.aliases.domain.AliasesRepository;
import com.ponsun.cms.allDetails.aliases.services.AliasesWritePlatformService;
import com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirthRepository;
import com.ponsun.cms.allDetails.dateOfBirth.services.DateOfBirthWritePlatformService;
import com.ponsun.cms.details.data.DetailsData;
import com.ponsun.cms.details.services.DetailsWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailsCombinedReadServiceImpl implements DetailsCombinedReadService {

    final private AddressRepository addressRepository;
    final private AliasesRepository aliasesRepository;
    final private DateOfBirthRepository dateOfBirthRepository;

    final private AddressWritePlatformService addressWritePlatformService;
    final private AliasesWritePlatformService aliasesWritePlatformService;
    final private DateOfBirthWritePlatformService dateOfBirthWritePlatformService;
    final private DetailsWritePlatformService detailsWritePlatformService;
    final private ModelMapper modelMapper;

    public List<DetailsCombineDTO> getDetails(Integer cmsId) {
        List<DetailsData> detailsDataList = detailsWritePlatformService.fetchAllDetails(cmsId);
        ModelMapper modelMapper = new ModelMapper();
        List<DetailsCombineDTO> detailsCombineDTOList = new ArrayList<>();

        for (DetailsData detailsData : detailsDataList) {
            DetailsCombineDTO detailsCombineDTO = new DetailsCombineDTO();
            //DetailsDTO detailsDTO = modelMapper.map(detailsData, DetailsDTO.class);
            List<AddressDTO> addressDTOList = addressWritePlatformService.fetchAllAddressDTO(cmsId);
            List<AliasesDTO> aliasesDTOList = aliasesWritePlatformService.fetchAllAliasesDTO(cmsId);
            List<DateOfBirthDTO> dateOfBirthDTOList = dateOfBirthWritePlatformService.fetchAllDateOfBirthDTO(cmsId);

            //detailsCombineDTO.setDetailsDTOS(Collections.singletonList(detailsDTO));
            detailsCombineDTO.setAddressDTOS(addressDTOList);
            detailsCombineDTO.setAliasesDTOS(aliasesDTOList);
            detailsCombineDTO.setDateOfBirthDTOS(dateOfBirthDTOList);
            detailsCombineDTOList.add(detailsCombineDTO);

        }
        return detailsCombineDTOList;
    }
}
