package com.ponsun.cms.IndPositions.api;




import com.ponsun.cms.IndPositions.data.IndPositionsData;
import com.ponsun.cms.IndPositions.domain.IndPositions;
import com.ponsun.cms.IndPositions.request.CreateIndPositionsRequest;
import com.ponsun.cms.IndPositions.request.UpdateIndPositionsRequest;
import com.ponsun.cms.IndPositions.services.IndPositionsReadPlatformService;
import com.ponsun.cms.IndPositions.services.IndPositionsWritePlatformService;
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
@RequestMapping("/api/v1/IndPositions")
@Tag(name = "IndPositionsApiResource")
public class IndPositionsApiResource {
    private final IndPositionsWritePlatformService indPositionsWritePlatformService;
    private final IndPositionsReadPlatformService indPositionsReadPlatformService;
    @PostMapping("/CreateIndPositionsRequest")
    public Response saveIndPositions(@RequestBody CreateIndPositionsRequest createIndPositionsRequest){
        Response response = this.indPositionsWritePlatformService.createIndPositions(createIndPositionsRequest);
        return response;
    }
    @GetMapping
    public List<IndPositions> fetchAll(){ return this.indPositionsReadPlatformService.fetchAllIndPositions();}

    @GetMapping("/{id}")
    public IndPositions fetchIndPositionsById(@PathVariable(name = "id")Integer id){
        return this.indPositionsReadPlatformService.fetchIndPositionsById(id);
    }


    @PutMapping("/{id}")
    public Response updateIndPositions(@PathVariable Integer id, @RequestBody UpdateIndPositionsRequest updateIndPositionsRequest){
        Response response = this.indPositionsWritePlatformService.updateIndPositions(id,updateIndPositionsRequest);
        return  response;
    }

    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer cmsId, @RequestParam Integer euid){
        Response response = this.indPositionsWritePlatformService.deactive(cmsId,euid);
        return  response;
    }
    @GetMapping("/Get/{cmsId}")
    public List<IndPositionsData> getIndPositionData(@PathVariable Integer cmsId){
        return this.indPositionsWritePlatformService.fetchIndPositionsData(cmsId);
    }

}
