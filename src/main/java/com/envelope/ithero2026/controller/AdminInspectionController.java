package com.envelope.ithero2026.controller;

import com.envelope.ithero2026.dto.InspectionDTO;
import com.envelope.ithero2026.service.InspectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.envelope.ithero2026.controller.ControllerNames.ADMIN_INSPECTION;
import static com.envelope.ithero2026.controller.ControllerNames.LOAD_INSPECTION_BY_MASTER;

@Tag(name = "Администратор: Обходы", description = "Управление обходами оборудования со стороны руководителя/администратора")
@RestController
@RequestMapping(ADMIN_INSPECTION)
@RequiredArgsConstructor
public class AdminInspectionController
{
    private final InspectionService service;

    @Operation(summary = "Создание обхода", description = "Создает новый плановый или внеплановый обход оборудования")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody InspectionDTO dto)
    {
        service.create(dto);
    }

    @Operation(summary = "Получение обхода по ID", description = "Возвращает полную информацию по конкретному обходу")
    @GetMapping
    InspectionDTO load(@Parameter(description = "Уникальный идентификатор обхода") @RequestParam long id)
    {
        return service.loadById(id);
    }

    @Operation(summary = "Обновление обхода", description = "Изменение параметров существующего обхода")
    @PutMapping
    void update(@RequestBody InspectionDTO dto)
    {
        service.update(dto);
    }

    @Operation(summary = "Удаление обхода", description = "Удаление обхода по идентификатору")
    @DeleteMapping
    void delete(@Parameter(description = "Уникальный идентификатор обхода") @RequestParam long id)
    {
        service.delete(id);
    }

    @Operation(summary = "Получение обходов по мастеру", description = "Возвращает список обходов, назначенных конкретному мастеру")
    @GetMapping(LOAD_INSPECTION_BY_MASTER)
    List<InspectionDTO> loadByMaster(
            @Parameter(description = "ID мастера (если не указан, возвращает все для текущего пользователя)")
            @RequestParam(required = false) Long masterId)
    {
        return service.loadByMaster(masterId);
    }
}