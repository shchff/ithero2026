package com.envelope.ithero2026.dto;

import com.envelope.ithero2026.domain.Inspection;
import com.envelope.ithero2026.domain.InspectionStatus;
import com.envelope.ithero2026.domain.InspectionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class InspectionDTO
{
    private Long id;
    private Instant startTime;
    private Instant endTime;
    private InspectionType type;
    private Long performerId;
    private Long masterId;
    private InspectionStatus status;
    private List<TaskDto> tasks;

    public InspectionDTO(Long id, Instant startTime, Instant endTime, InspectionType type, Long performerId, Long masterId, InspectionStatus status)
    {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.performerId = performerId;
        this.masterId = masterId;
        this.status = status;
    }

    public static InspectionDTO fromEntity(Inspection entity)
    {
        return new InspectionDTO(
                entity.getId(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getType(),
                entity.getPerformer().getId(),
                entity.getMaster().getId(),
                entity.getStatus());
    }
}
