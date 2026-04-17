package com.envelope.ithero2026.dto;

import com.envelope.ithero2026.domain.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto
{
    private Long id;

    private Long inspectionId;

    private Long facilityId;

    private List<ValueInTaskDTO> values;

    public TaskDto(Long id, Long inspectionId, Long facilityId)
    {
        this.id = id;
        this.inspectionId = inspectionId;
        this.facilityId = facilityId;
    }

    public static TaskDto fromEntity(Task task)
    {
        return new TaskDto(task.getId(), task.getInspection().getId(), task.getFacility().getId());
    }
}
