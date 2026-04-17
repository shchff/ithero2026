package com.envelope.ithero2026.service;

import com.envelope.ithero2026.domain.Task;
import com.envelope.ithero2026.domain.ValueInTask;
import com.envelope.ithero2026.dto.ValueInTaskDTO;
import com.envelope.ithero2026.repository.ValueInTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValueInTaskService
{
    private final ValueInTaskRepository repository;
    private final ReferenceValueService referenceValueService;

    @Transactional(readOnly = true)
    public ValueInTask loadEntityById(long id)
    {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("ValueInTask with id=" + id + " not found."));
    }

    @Transactional
    public void finish(List<ValueInTaskDTO> values)
    {
        for (var dto : values)
        {
            var value = loadEntityById(dto.getId());
            value.setValue(dto.getValue());
        }
    }

    @Transactional(readOnly = true)
    public List<ValueInTaskDTO> prepare(Long taskId)
    {
        var valueInTasks = repository.findAllByTaskId(taskId).stream().map(ValueInTaskDTO::fromEntity).toList();
        valueInTasks.forEach(v -> {
            var rf = referenceValueService.loadEntityById(v.getReferenceValueId());
            v.setName(rf.getName());
            v.setMinValue(rf.getMinValue());
            v.setMaxValue(rf.getMaxValue());
        });
        return valueInTasks;
    }

    @Transactional
    public void saveValueInTask(ValueInTaskDTO dto, Task task)
    {
        var value = new ValueInTask();
        value.setTask(task);
    }
}
