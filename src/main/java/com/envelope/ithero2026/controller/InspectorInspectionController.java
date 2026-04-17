package com.envelope.ithero2026.controller;

import com.envelope.ithero2026.dto.InspectionDTO;
import com.envelope.ithero2026.service.InspectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.envelope.ithero2026.controller.ControllerNames.*;

@RestController
@RequestMapping(INSPECTOR_INSPECTION)
@RequiredArgsConstructor
public class InspectorInspectionController
{
    private final InspectionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody InspectionDTO dto)
    {
        service.create(dto);
    }

    @GetMapping(BY_PERFORMER)
    List<InspectionDTO> loadByPerformer(@RequestParam(required = false) Long performerId)
    {
        return service.loadByPerformer(performerId);
    }

    @PutMapping(FINISH)
    void finish(@RequestBody InspectionDTO dto)
    {
        service.finish(dto);
    }

    @PutMapping(PREPARE)
    InspectionDTO prepareToInspect(@RequestParam long id)
    {
        return service.prepareForInspection(id);
    }

    @PostMapping(REQUEST_INCIDENT)
    void requestIncident(InspectionDTO dto)
    {
        service.create(dto);
    }
}
