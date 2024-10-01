package com.ponsun.cms.allDetails.CombinedServices.service;


import com.ponsun.cms.allDetails.CombinedServices.writeDTO.*;
import com.ponsun.cms.allDetails.address.services.AddressWritePlatformService;
import com.ponsun.cms.master.RecordType.domain.RecordTypeRepository;
import com.ponsun.cms.allDetails.address.domain.Address;
import com.ponsun.cms.allDetails.address.domain.AddressRepository;
import com.ponsun.cms.allDetails.address.request.CreateAddressRequest;
import com.ponsun.cms.allDetails.aliases.domain.Aliases;
import com.ponsun.cms.allDetails.aliases.domain.AliasesRepository;
import com.ponsun.cms.allDetails.aliases.request.CreateAliasesRequest;
import com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirth;
import com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirthRepository;
import com.ponsun.cms.allDetails.dateOfBirth.request.CreateDateOfBirthRequest;
import com.ponsun.cms.details.domain.DetailsRepository;
import com.ponsun.cms.details.services.DetailsWritePlatformService;
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
public class DetailsCombinedWriteServiceImpl implements DetailsCombinedWriteService {

    private final RecordTypeRepository recordTypeRepository;
    private final DetailsRepository detailsRepository;
    private final DetailsWritePlatformService detailsWritePlatformService;
    private final AddressRepository addressRepository;
    private final AliasesRepository aliasesRepository;
    private final DateOfBirthRepository dateOfBirthRepository;
    private final AddressWritePlatformService addressWritePlatformService;

    @Override
    @Transactional
    public Response createDetail(Integer cmsId,  List<DetailsCombineDTO> detailsCombineDTO) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();

            for (DetailsCombineDTO dto : detailsCombineDTO) {
                for (AddressDTO addressDTO : dto.getAddressDTOS()) {
                    CreateAddressRequest createAddressRequest = modelMapper.map(addressDTO, CreateAddressRequest.class);
                    if(!createAddressRequest.getAddress().isEmpty()) {
                        createAddressRequest.setCmsId(cmsId);
                        final Address address = Address.create(createAddressRequest);
                        this.addressRepository.save(address);
                    }
                }

                for (AliasesDTO aliasesDTO : dto.getAliasesDTOS()) {
                    CreateAliasesRequest createAliasesRequest = modelMapper.map(aliasesDTO, CreateAliasesRequest.class);
                    if(!createAliasesRequest.getAliasesName().isEmpty()) {
                        createAliasesRequest.setCmsId(cmsId);
                        final Aliases aliases = Aliases.create(createAliasesRequest);
                        this.aliasesRepository.save(aliases);
                    }
                }

                for (DateOfBirthDTO dateOfBirthDTO : dto.getDateOfBirthDTOS()) {
                    CreateDateOfBirthRequest createDateOfBirthRequest = modelMapper.map(dateOfBirthDTO, CreateDateOfBirthRequest.class);
                    //if(!createDateOfBirthRequest.getDob().isEmpty()) {
                        createDateOfBirthRequest.setCmsId(cmsId);
                        final DateOfBirth dateOfBirth = DateOfBirth.create(createDateOfBirthRequest);
                        this.dateOfBirthRepository.save(dateOfBirth);
                    //}
                }
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response createAndUpdateDetails(Integer cmsId, Integer euid, List<DetailsCombineDTO> detailsCombineDTO) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();

            for (DetailsCombineDTO dto : detailsCombineDTO) {
                this.addressWritePlatformService.deActivateDetails(cmsId , euid);

                for (AddressDTO addressDTO : dto.getAddressDTOS()) {
                    CreateAddressRequest createAddressRequest = modelMapper.map(addressDTO, CreateAddressRequest.class);
                    //this.addressWritePlatformService.deActivateDetails(cmsId , euid);
                    if(!createAddressRequest.getAddress().isEmpty()) {
                        createAddressRequest.setCmsId(cmsId);
                        final Address address = Address.create(createAddressRequest);
                        this.addressRepository.save(address);
                    }
                }

                for (AliasesDTO aliasesDTO : dto.getAliasesDTOS()) {
                    CreateAliasesRequest createAliasesRequest = modelMapper.map(aliasesDTO, CreateAliasesRequest.class);

                    if(!createAliasesRequest.getAliasesName().isEmpty()) {
                        createAliasesRequest.setCmsId(cmsId);
                        final Aliases aliases = Aliases.create(createAliasesRequest);
                        this.aliasesRepository.save(aliases);
                    }
                }

                for (DateOfBirthDTO dateOfBirthDTO : dto.getDateOfBirthDTOS()) {
                    CreateDateOfBirthRequest createDateOfBirthRequest = modelMapper.map(dateOfBirthDTO, CreateDateOfBirthRequest.class);
                    //if(!createDateOfBirthRequest.getDob().isEmpty()) {
                        createDateOfBirthRequest.setCmsId(cmsId);
                        final DateOfBirth dateOfBirth = DateOfBirth.create(createDateOfBirthRequest);
                        this.dateOfBirthRepository.save(dateOfBirth);
                    //}
                }
            }

            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}
