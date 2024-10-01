package com.ponsun.cms.allDetails.address.api;

import com.ponsun.cms.allDetails.address.domain.Address;
import com.ponsun.cms.allDetails.address.request.CreateAddressRequest;
import com.ponsun.cms.allDetails.address.request.UpdateAddressRequest;
import com.ponsun.cms.allDetails.address.services.AddressReadPlatformService;
import com.ponsun.cms.allDetails.address.services.AddressWritePlatformService;
import com.ponsun.cms.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/Address")
@Tag(name = "AddressApiResource")
public class AddressApiResource {
    private final AddressWritePlatformService addressWritePlatformService;
    private final AddressReadPlatformService addressReadPlatformService;
    @PostMapping("/CreateAddressRequest")
    public Response saveAddress(@RequestBody CreateAddressRequest createAddressRequest){
        Response response = this.addressWritePlatformService.createAddress(createAddressRequest);
        return response;
    }
    @GetMapping
    public List<Address> fetchAll(){ return this.addressReadPlatformService.fetchAllAddress();}

    @GetMapping("/{id}")
    public Address fetchAddressById(@PathVariable(name = "id")Integer id){
        return this.addressReadPlatformService.fetchAddressById(id);
    }


    @PutMapping("/{id}")
    public Response updateAddress(@PathVariable Integer id, @RequestBody UpdateAddressRequest updateAddressRequest){
        Response response = this.addressWritePlatformService.updateAddress(id,updateAddressRequest);
        return  response;
    }
    @PutMapping("/{id}/block")
    public Response blockAddress(@PathVariable Integer id){
        Response response = this.addressWritePlatformService.blockAddress(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockAddress(@PathVariable Integer id){
       Response response = this.addressWritePlatformService.unblockAddress(id);
       return  response;
    }

    @PutMapping("/{id}/deActivate")
    public Response updateAddress(@RequestParam Integer cmsId , @RequestParam Integer euid){
        Response response = this.addressWritePlatformService.deActivateDetails(cmsId,euid);
        return  response;
    }

}
