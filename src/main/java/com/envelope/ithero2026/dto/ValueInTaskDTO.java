package com.envelope.ithero2026.dto;

import com.envelope.ithero2026.domain.ValueInTask;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValueInTaskDTO
{
    private Long id;
    private Double value;
    private Long referenceValueId;
    private String name;
    private Double minValue;
    private Double maxValue;

    public static ValueInTaskDTO fromEntity(ValueInTask entity)
    {
        ValueInTaskDTO dto = new ValueInTaskDTO();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());
        dto.setReferenceValueId(entity.getReference().getId());
        return dto;
    }
}
