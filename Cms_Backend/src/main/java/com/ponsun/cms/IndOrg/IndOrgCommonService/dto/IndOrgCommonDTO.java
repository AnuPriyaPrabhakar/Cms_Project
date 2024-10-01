package com.ponsun.cms.IndOrg.IndOrgCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class IndOrgCommonDTO {
    private PositionsDTO positionsDTO;
    private List<IndAliasesNameDTO> indAliasesNameDTOS;
    private List<RelationDTO> relationDTOS;
    private List<RelationAliasesDTO> relationAliasesDTOS;
    private List<DetailsAboutRelationDTO> detailsAboutRelationDTOS;

    public IndOrgCommonDTO (PositionsDTO positionsDTO,List<IndAliasesNameDTO> indAliasesNameDTOS,List<RelationDTO> relationDTOS,List<RelationAliasesDTO> relationAliasesDTOS,List<DetailsAboutRelationDTO> detailsAboutRelationDTOS) {
        this.positionsDTO = positionsDTO;
        this.indAliasesNameDTOS = indAliasesNameDTOS;
        this.relationDTOS = relationDTOS;
        this.relationAliasesDTOS = relationAliasesDTOS;
        this.detailsAboutRelationDTOS= detailsAboutRelationDTOS;
    }

    public IndOrgCommonDTO newInstance(PositionsDTO positionsDTO,List<IndAliasesNameDTO> indAliasesNameDTOS,List<RelationDTO> relationDTOS,List<RelationAliasesDTO> relationAliasesDTOS,List<DetailsAboutRelationDTO> detailsAboutRelationDTOS) {
            return new IndOrgCommonDTO(positionsDTO,indAliasesNameDTOS,relationDTOS,relationAliasesDTOS,detailsAboutRelationDTOS);
    }
}
