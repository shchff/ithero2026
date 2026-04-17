package com.envelope.ithero2026.service;

import com.envelope.ithero2026.domain.Inspection;
import com.envelope.ithero2026.domain.InspectionStatus;
import com.envelope.ithero2026.dto.InspectionDTO;
import com.envelope.ithero2026.repository.InspectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class InspectionService
{
    private final InspectionRepository repository;
    private final UserService userService;
    private final TaskService taskService;
    private final ValueInTaskService valueInTaskService;

    @Transactional(readOnly = true)
    public List<InspectionDTO> loadByPerformer(Long performerId)
    {
        return repository.findByPerformerId(performerId).stream().map(InspectionDTO::fromEntity).toList();
    }

    @Transactional(readOnly = true)
    public List<InspectionDTO> loadByMaster(Long masterId)
    {
        return repository.findByMasterId(masterId).stream().map(InspectionDTO::fromEntity).toList();
    }

    /**
     * При создании задаются все поля кроме {@link Inspection#getEndTime()}
     */
    @Transactional
    public void create(InspectionDTO dto)
    {
        var entity = new Inspection();
        entity.setStartTime(dto.getStartTime());
        entity.setType(dto.getType());
        entity.setPerformer(userService.loadUser(dto.getPerformerId()));
        entity.setMaster(userService.loadUser(dto.getMasterId()));
        entity.setStatus(InspectionStatus.PLANNED);
        repository.save(entity);
        for (var task : dto.getTasks())
        {
            taskService.saveTask(task, entity);
        }
    }

    @Transactional
    public void delete(long id)
    {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Inspection loadEntityById(long id)
    {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Inspection with id=" + id + " not fount"));
    }

    @Transactional
    public InspectionDTO loadById(long id)
    {
        return InspectionDTO.fromEntity(loadEntityById(id));
    }

    @Transactional
    public InspectionDTO prepareForInspection(long id)
    {
        var inspection = loadEntityById(id);
        inspection.setStatus(InspectionStatus.IN_PROGRESS);
        var dto = InspectionDTO.fromEntity(inspection);
        dto.setTasks(taskService.prepare(id));
        return dto;
    }

    @Transactional
    public void update(InspectionDTO dto)
    {
        var entity = loadEntityById(dto.getId());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setType(dto.getType());
        entity.setPerformer(userService.loadUser(dto.getPerformerId()));
        entity.setMaster(userService.loadUser(dto.getMasterId()));
    }

    @Transactional
    public void finish(InspectionDTO dto)
    {
        for (var task : dto.getTasks())
        {
            valueInTaskService.finish(task.getValues());
        }
        var inspection = loadEntityById(dto.getId());
        inspection.setStatus(InspectionStatus.COMPLETED);
    }
}
