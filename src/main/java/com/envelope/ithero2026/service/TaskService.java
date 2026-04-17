package com.envelope.ithero2026.service;

import com.envelope.ithero2026.domain.Facility;
import com.envelope.ithero2026.domain.Inspection;
import com.envelope.ithero2026.domain.Task;
import com.envelope.ithero2026.dto.TaskDto;
import com.envelope.ithero2026.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService
{
    private final TaskRepository repository;
    private final FacilityService facilityService;
    private final ValueInTaskService valueInTaskService;

    @Transactional(readOnly = true)
    public List<TaskDto> prepare(long inspectionId)
    {
        var tasks = repository.findByInspectionId(inspectionId).stream().map(TaskDto::fromEntity).toList();
        tasks.forEach(dto -> dto.setValues(valueInTaskService.prepare(dto.getId())));
        return tasks;
    }

    @Transactional
    public void saveTask(TaskDto dto, Inspection inspection)
    {
        var task = new Task();
        task.setInspection(inspection);
        task.setFacility(facilityService.loadEntityById(dto.getFacilityId()));
        repository.save(task);
        for (var value : dto.getValues()) {
            valueInTaskService.saveValueInTask(value, task);
        }
    }
}
