package com.envelope.ithero2026.service;

import com.envelope.ithero2026.domain.ReferenceValue;
import com.envelope.ithero2026.repository.ReferenceValueRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Setter
@RequiredArgsConstructor
public class ReferenceValueService
{
    private final ReferenceValueRepository repository;

    public ReferenceValue loadEntityById(long id)
    {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("ReferenceValue with id=" + id + " not found"));
    }
}
