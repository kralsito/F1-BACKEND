package com.api.crud.service.impl;

import com.api.crud.model.Team;
import com.api.crud.repository.TeamRepository;
import com.api.crud.service.TeamService;
import com.api.crud.service.dto.request.TeamDTOin;
import com.api.crud.service.dto.response.TeamDTO;
import com.api.crud.service.mapper.TeamMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;


    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public TeamDTO create(TeamDTOin dto) {
        Team team = TeamMapper.MAPPER.toEntity(dto);
        team = teamRepository.save(team);
        return TeamMapper.MAPPER.toDto(team);
    }

    @Override
    public TeamDTO getById(Long id) {
        Team team = getTeam(id);
        return TeamMapper.MAPPER.toDto(team);
    }

    @Override
    public void delete(Long id)  {
        Team team = getTeam(id);
        teamRepository.delete(team);
    }

    @Override
    public List<TeamDTO> getAll() {
        return teamRepository.findAll()
                .stream()
                .map(TeamMapper.MAPPER::toDto)
                .collect(Collectors.toList());
    }

    private Team getTeam(Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El equipo con ID " + id + " no fue encontrado.");
        }
        return teamOptional.get();
    }
}
