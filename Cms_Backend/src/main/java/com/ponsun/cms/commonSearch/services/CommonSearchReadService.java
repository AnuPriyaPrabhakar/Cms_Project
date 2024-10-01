package com.ponsun.cms.commonSearch.services;


import com.ponsun.cms.commonSearch.data.RecordsDto;
import com.ponsun.cms.commonSearch.data.SearchDto;

import java.util.List;

public interface CommonSearchReadService {
    List<RecordsDto> getRecords(SearchDto searchDto);

}
