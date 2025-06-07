package com.api.crud.service.mapper;

import com.api.crud.model.Team;
import com.api.crud.service.dto.request.TeamDTOin;
import com.api.crud.service.dto.response.TeamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TeamMapper extends EntityMapper<TeamDTO, Team>{
    TeamMapper MAPPER = Mappers.getMapper(TeamMapper.class);
    Team toEntity(TeamDTOin dto);
}
