package com.api.crud.service.dto.response;

import lombok.Data;

@Data
public class DriverDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private TeamDTO team;
}
