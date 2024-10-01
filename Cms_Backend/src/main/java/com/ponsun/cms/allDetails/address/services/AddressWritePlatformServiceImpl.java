package com.ponsun.cms.allDetails.address.services;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.AddressDTO;
import com.ponsun.cms.allDetails.address.data.AddressDataValidator;
import com.ponsun.cms.allDetails.address.domain.Address;
import com.ponsun.cms.allDetails.address.domain.AddressRepository;
import com.ponsun.cms.allDetails.address.domain.AddressRepositoryWrapper;
import com.ponsun.cms.allDetails.address.request.CreateAddressRequest;
import com.ponsun.cms.allDetails.address.request.UpdateAddressRequest;
import com.ponsun.cms.allDetails.address.rowmapper.AddressRowMapper;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressWritePlatformServiceImpl implements AddressWritePlatformService {
    private final AddressRepository addressRepository;
    private final AddressRepositoryWrapper addressRepositoryWrapper;
    private final AddressDataValidator addressDataValidator;
    private final AddressRowMapper addressRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Transactional
    public Response createAddress(CreateAddressRequest createAddressRequest){
        try{
            this.addressDataValidator.validateSaveAddressData(createAddressRequest);
            final Address address = Address.create(createAddressRequest);
            this.addressRepository.saveAndFlush(address);
            return Response.of(Long.valueOf(address.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateAddress(Integer id, UpdateAddressRequest updateAddressRequest) {
        try {
            this.addressDataValidator.validateUpdateAddressData(updateAddressRequest);
            final Address address = this.addressRepositoryWrapper.findOneWithNotFoundDetection(id);
            address.update(updateAddressRequest);
            this.addressRepository.saveAndFlush(address);
            return Response.of(Long.valueOf(address.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockAddress(Integer id){
        try{
            final Address address = this.addressRepositoryWrapper.findOneWithNotFoundDetection(id);
            address.setStatus(Status.DELETE);
            address.setUpdatedAt(LocalDateTime.now());
            this.addressRepository.saveAndFlush(address);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockAddress(Integer id){
        try {
            final Address address = this.addressRepositoryWrapper.findOneWithNotFoundDetection(id);
            address.setStatus(Status.ACTIVE);
            address.setUpdatedAt(LocalDateTime.now());
            this.addressRepository.saveAndFlush(address);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    public List<AddressDTO> fetchAllAddressDTO(Integer cmsId) {
        final AddressRowMapper rowMapper = new AddressRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE ad.cmsId = ?  AND ad.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<AddressDTO> addressDTOList  = jdbcTemplate.query(Qry,addressRowMapper,
                new Object[] {cmsId}
        );
        return addressDTOList;
    }


    @Override
    @Transactional
    public Response deActivateDetails(Integer cmsId , Integer euid){
        try {

            Response response = null;
            updateAddress(cmsId ,euid);
            updateAliases(cmsId,euid);
            updateBirthDetails(cmsId,euid);
            return response;

        }
        catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    public void updateAddress(Integer cmsId ,Integer euid) {
        String updateQuery = "UPDATE cms_address SET STATUS = 'D' , euid= ? , updated_at = NOW() WHERE cmsId = ? ";
        this.jdbcTemplate.update(updateQuery, euid, cmsId);
    }

    public void updateAliases(Integer cmsId,Integer euid) {
        String updateQuery = "UPDATE cms_aliases SET STATUS = 'D' , euid= ? , updated_at = NOW() WHERE cmsId = ? ";
        this.jdbcTemplate.update(updateQuery, euid, cmsId);
    }

    public void updateBirthDetails(Integer cmsId ,Integer euid) {
        String updateQuery = "UPDATE cms_birth_details SET STATUS = 'D' , euid= ? , updated_at = NOW() WHERE cmsId = ? ";
        this.jdbcTemplate.update(updateQuery, euid, cmsId);
    }
}
