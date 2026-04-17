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

import static com.envelope.ithero2026.controller.ControllerNames.*;

@Tag(name = "Обходчик: Обходы", description = "Рабочий интерфейс обходчика: выполнение заданий, фиксация результатов, создание инцидентов")
@RestController
@RequestMapping(INSPECTOR_INSPECTION)
@RequiredArgsConstructor
public class InspectorInspectionController
{
    private final InspectionService service;

    @Operation(summary = "Создание обхода", description = "Создание обхода (доступно обходчику для инициации)")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody InspectionDTO dto)
    {
        service.create(dto);
    }

    @Operation(summary = "Получение обходов по исполнителю", description = "Возвращает список обходов, назначенных конкретному обходчику")
    @GetMapping(BY_PERFORMER)
    List<InspectionDTO> loadByPerformer(
            @Parameter(description = "ID обходчика")
            @RequestParam(required = false) Long performerId)
    {
        return service.loadByPerformer(performerId);
    }

    @Operation(summary = "Завершение обхода", description = "Фиксация факта завершения обхода и сохранение результатов")
    @PutMapping(FINISH)
    void finish(@RequestBody InspectionDTO dto)
    {
        service.finish(dto);
    }

    @Operation(summary = "Подготовка к обходу", description = "Инициализация обхода: фиксация времени начала, загрузка чек-листов и маршрута")
    @PutMapping(PREPARE)
    InspectionDTO prepareToInspect(
            @Parameter(description = "Уникальный идентификатор обхода")
            @RequestParam long id)
    {
        return service.prepareForInspection(id);
    }

//    @Operation(summary = "Создание инцидента/дефекта", description = "Фиксация выявленного отклонения или дефекта во время обхода")
//    @PostMapping(REQUEST_INCIDENT)
//    void requestIncident(@RequestBody InspectionDTO dto)
//    {
//        service.create(dto);
//    }
}