package com.ponsun.cms.IndOrg.IndOrgCommonService.service;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.*;
import com.ponsun.cms.IndOrg.detailsAboutRelation.services.DetailsAboutRelationWritePlatformService;
import com.ponsun.cms.IndOrg.indAliasesName.domain.IndAliasesNameRepository;
import com.ponsun.cms.IndOrg.indAliasesName.services.IndAliasesNameWritePlatformService;
import com.ponsun.cms.IndOrg.positions.data.PositionsData;
import com.ponsun.cms.IndOrg.positions.domain.PositionsRepository;
import com.ponsun.cms.IndOrg.relation.domain.RelationRepository;
import com.ponsun.cms.IndOrg.relation.services.RelationWritePlatformService;
import com.ponsun.cms.IndOrg.relationAliases.domain.RelationAliasesRepository;
import com.ponsun.cms.IndOrg.relationAliases.services.RelationAliasesWritePlatformService;
import com.ponsun.cms.common.entity.Status;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IndOrgCommonReadPlatformServiceImpl implements IndOrgCommonReadPlatformService {

    private final PositionsRepository positionsRepository;
    private final IndAliasesNameRepository indAliasesNameRepository;
    private final RelationRepository relationRepository;
    private final RelationAliasesRepository relationAliasesRepository;
    private final IndAliasesNameWritePlatformService indAliasesNameWritePlatformService;
    private final RelationWritePlatformService relationWritePlatformService;
    private final RelationAliasesWritePlatformService relationAliasesWritePlatformService;
    private final DetailsAboutRelationWritePlatformService detailsAboutRelationWritePlatformService;


    @Override
    public List<IndOrgCommonDTO> getIndOrgDetails(Integer cmsId) {
        List<PositionsData> positionsDataList = positionsRepository.findByCmsIdAndStatus(cmsId , Status.ACTIVE);
        ModelMapper modelMapper = new ModelMapper();
        List<IndOrgCommonDTO> indOrgCommonDTOList = new ArrayList<>();

        for(PositionsData positionsData : positionsDataList) {
            IndOrgCommonDTO indOrgCommonDTO = new IndOrgCommonDTO();
            PositionsDTO positionsDTO = modelMapper.map(positionsData , PositionsDTO.class);
            Integer positionId  = positionsDTO.getId();
            List<IndAliasesNameDTO> indAliasesNameDTOList = indAliasesNameWritePlatformService.fetchIndAliasesNameDTO(cmsId,positionId);
            List<RelationDTO> relationDTOList = relationWritePlatformService.fetchRelationDTO(cmsId,positionId);
            List<RelationAliasesDTO> relationAliasesDTOList = relationAliasesWritePlatformService.fetchRelationAliasesDTO(cmsId,positionId);
            List<DetailsAboutRelationDTO> detailsAboutRelationDTOList = detailsAboutRelationWritePlatformService.fetchDetailsAboutRelationDTO(cmsId,positionId);

            indOrgCommonDTO.setPositionsDTO(positionsDTO);
            indOrgCommonDTO.setIndAliasesNameDTOS(indAliasesNameDTOList);
            indOrgCommonDTO.setRelationDTOS(relationDTOList);
            indOrgCommonDTO.setRelationAliasesDTOS(relationAliasesDTOList);
            indOrgCommonDTO.setDetailsAboutRelationDTOS(detailsAboutRelationDTOList);
            indOrgCommonDTOList.add(indOrgCommonDTO);
        }
        return indOrgCommonDTOList;
    }
}
