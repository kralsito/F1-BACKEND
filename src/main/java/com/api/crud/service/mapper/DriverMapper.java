package com.api.crud.service.mapper;

import com.api.crud.model.Driver;
import com.api.crud.service.dto.request.DriverDTOin;
import com.api.crud.service.dto.response.DriverDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DriverMapper extends EntityMapper<DriverDTO, Driver>{
    DriverMapper MAPPER = Mappers.getMapper(DriverMapper.class);
    Driver toEntity(DriverDTOin dto);
}
