package com.envelope.ithero2026.controller;

import com.envelope.ithero2026.dto.InspectionDTO;
import com.envelope.ithero2026.service.InspectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.envelope.ithero2026.controller.ControllerNames.ADMIN_INSPECTION;
import static com.envelope.ithero2026.controller.ControllerNames.LOAD_INSPECTION_BY_MASTER;

@RestController
@RequestMapping(ADMIN_INSPECTION)
@RequiredArgsConstructor
public class AdminInspectionController
{
    private final InspectionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody InspectionDTO dto)
    {
        service.create(dto);
    }

    @GetMapping
    InspectionDTO load(@RequestParam long id)
    {
        return service.loadById(id);
    }

    @PutMapping
    void update(@RequestBody InspectionDTO dto)
    {
        service.update(dto);
    }

    @DeleteMapping
    void delete(@RequestParam long id)
    {
        service.delete(id);
    }

    @GetMapping(LOAD_INSPECTION_BY_MASTER)
    List<InspectionDTO> loadByMaster(@RequestParam(required = false) Long masterId)
    {
        return service.loadByMaster(masterId);
    }
}
