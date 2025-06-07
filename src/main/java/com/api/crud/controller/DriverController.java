package com.api.crud.controller;

import com.api.crud.service.DriverService;
import com.api.crud.service.dto.request.DriverDTOin;
import com.api.crud.service.dto.response.DriverDTO;
import com.api.crud.service.dto.response.TeamDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;


    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/create")
    public ResponseEntity<DriverDTO> create(@RequestBody DriverDTOin driverDTOin) {
        DriverDTO response = driverService.create(driverDTOin);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity<DriverDTO> getById(@PathVariable Long id) {
        DriverDTO response = driverService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/read/all")
    public ResponseEntity<List<DriverDTO>> getAll() {
        List<DriverDTO> drivers = driverService.getAll();
        return ResponseEntity.ok(drivers);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DriverDTO> update(@PathVariable Long id,
                                            @RequestBody DriverDTOin driverDTOin) {
        DriverDTO updatedDriver = driverService.update(id, driverDTOin);
        return ResponseEntity.ok(updatedDriver);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)  {
        driverService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
