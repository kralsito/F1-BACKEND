package com.api.crud.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DriverDTOin {
    private String firstName;
    private String lastName;
    private Long team_id;
}
