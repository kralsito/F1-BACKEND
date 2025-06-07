package com.api.crud.service;

import com.api.crud.service.dto.request.TeamDTOin;
import com.api.crud.service.dto.response.TeamDTO;
import java.util.List;

public interface TeamService {
    TeamDTO create(TeamDTOin dto);

    TeamDTO getById(Long id);

    List<TeamDTO> getAll();

    void delete(Long id);
}
