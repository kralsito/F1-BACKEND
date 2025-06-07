package com.api.crud.service.impl;


import com.api.crud.model.Team;
import com.api.crud.repository.DriverRepository;
import com.api.crud.repository.TeamRepository;
import com.api.crud.service.DriverService;
import com.api.crud.service.dto.response.TeamDTO;
import com.api.crud.service.mapper.DriverMapper;
import com.api.crud.service.mapper.TeamMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.api.crud.service.dto.response.DriverDTO;
import com.api.crud.service.dto.request.DriverDTOin;
import com.api.crud.model.Driver;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    private final TeamRepository teamRepository;

    public DriverServiceImpl(DriverRepository driverRepository, TeamRepository teamRepository) {
        this.driverRepository = driverRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public DriverDTO create(DriverDTOin dto) {
        Driver driver = DriverMapper.MAPPER.toEntity(dto);
        Team team = getTeam(dto);
        driver.setTeam(team);
        driver = driverRepository.save(driver);
        return DriverMapper.MAPPER.toDto(driver);
    }

    @Override
    public DriverDTO getById(Long id) {
        Driver driver = getDriver(id);
        return DriverMapper.MAPPER.toDto(driver);
    }

    @Override
    public List<DriverDTO> getAll() {
        return driverRepository.findAll()
                .stream()
                .map(DriverMapper.MAPPER::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id)  {
        Driver driver = getDriver(id);
        driverRepository.delete(driver);
    }

    private Driver getDriver(Long id) {
        Optional<Driver> driverOptional = driverRepository.findById(id);
        if (driverOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El conductor no fue encontrado.");
        }
        return driverOptional.get();
    }

    private Team getTeam(DriverDTOin dto) {
        Optional<Team> teamOptional = teamRepository.findById(dto.getTeam_id());
        if (teamOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El equipo no fue encontrado.");
        }
        Team team = teamOptional.get();
        team.setId(dto.getTeam_id());
        return team;
    }
}

