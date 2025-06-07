package com.api.crud.service;

import com.api.crud.service.dto.request.DriverDTOin;
import com.api.crud.service.dto.response.DriverDTO;

import java.util.List;

public interface DriverService {

    DriverDTO create(DriverDTOin dto);

    DriverDTO getById(Long id);

    List<DriverDTO> getAll();

    void delete(Long id);
}
