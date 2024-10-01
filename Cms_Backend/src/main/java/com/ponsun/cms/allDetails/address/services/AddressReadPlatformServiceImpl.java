package com.ponsun.cms.allDetails.address.services;

import com.ponsun.cms.allDetails.address.domain.Address;
import com.ponsun.cms.allDetails.address.domain.AddressRepository;
import com.ponsun.cms.allDetails.address.domain.AddressRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressReadPlatformServiceImpl implements AddressReadPlatformService {
    private final AddressRepositoryWrapper addressRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AddressRepository addressRepository;
    @Override
    public Address fetchAddressById(Integer id){
        return this.addressRepository.findById(id).get();
    }
    @Override
    public List<Address> fetchAllAddress(){ return this.addressRepository.findAll();}
}
