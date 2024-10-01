package com.ponsun.cms.bankDetails.api;


import com.ponsun.cms.bankDetails.data.BankDetailsData;
import com.ponsun.cms.bankDetails.domain.BankDetails;
import com.ponsun.cms.bankDetails.request.CreateBankDetailsRequest;
import com.ponsun.cms.bankDetails.request.UpdateBankDetailsRequest;
import com.ponsun.cms.bankDetails.services.BankDetailsReadPlatFormService;
import com.ponsun.cms.bankDetails.services.BankDetailsWritePlatFormService;
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
@RequestMapping("/api/v1/BankDetails")
@Tag(name = "BankDetailsApiResources")
public class BankDetailsApiResources {
    private final BankDetailsWritePlatFormService bankDetailsWritePlatformService;
    private final BankDetailsReadPlatFormService bankDetailsReadPlatformService;
    @PostMapping("/CreateBankDetailsRequest")
    public Response saveBankDetails(@RequestBody CreateBankDetailsRequest createBankDetailsRequest){
        Response response = this.bankDetailsWritePlatformService.createBankDetails(createBankDetailsRequest);
        return response;
    }
    @GetMapping
    public List<BankDetails> fetchAll(){ return this.bankDetailsReadPlatformService.fetchAllBankDetails();}

    @GetMapping("/{id}")
    public BankDetails fetchBankDetailsById(@PathVariable(name = "id")Integer id){
        return this.bankDetailsReadPlatformService.fetchBankDetailsById(id);
    }
    @GetMapping("/BankDetailsData/{cmsId}/{recordTypeId}")
    public List<BankDetailsData> getBankDetailsData(@PathVariable Integer cmsId){
        return this.bankDetailsWritePlatformService.fetchAllBankDetailsData(cmsId);
    }
    @PutMapping("/{id}")
    public Response updateBankDetails(@PathVariable Integer id, @RequestBody UpdateBankDetailsRequest updateBankDetailsRequest){
        Response response = this.bankDetailsWritePlatformService.updateBankDetails(id,updateBankDetailsRequest);
        return  response;
    }

    @PutMapping("/deactivate/{cmsId}/{euid}")
    public Response deactivate(@PathVariable Integer cmsId, @PathVariable Integer euid){
        Response response = this.bankDetailsWritePlatformService.deactive(cmsId, euid);
        return  response;
    }


}
