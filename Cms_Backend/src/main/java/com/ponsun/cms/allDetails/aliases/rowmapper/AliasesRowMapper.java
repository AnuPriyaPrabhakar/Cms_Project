package com.ponsun.cms.allDetails.aliases.rowmapper;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.AliasesDTO;
import com.ponsun.cms.allDetails.aliases.data.AliasesData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AliasesRowMapper implements RowMapper<AliasesDTO>{
   private final String schema;
   public AliasesRowMapper() {
       final StringBuilder builder = new StringBuilder(200);
       builder.append("FROM cms_aliases ca");
       this.schema = builder.toString();
   }
   public String tableSchema() {
       final StringBuilder builder = new StringBuilder(200);
       builder.append("ca.id as id, ");
       builder.append("ca.recordTypeId as recordTypeId, ");
       builder.append("ca.cmsId as cmsId ,");
       builder.append("ca.aliasesName as aliasesName , ");
       builder.append("ca.uid as uid ,");
       builder.append("ca.euid as euid ");
       builder.append(this.schema);
       return builder.toString();
   }
   @Override
    public AliasesDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
       final Integer id = rs.getInt("id");
       final Integer recordTypeId = rs.getInt("recordTypeId");
       final Integer cmsId = rs.getInt("cmsId");
       final String aliasesName = rs.getString("aliasesName");
       final Integer uid = rs.getInt("uid");
       final Integer euid = rs.getInt("euid");
       return new AliasesDTO(id,recordTypeId,cmsId,aliasesName,uid,euid);

   }
}
