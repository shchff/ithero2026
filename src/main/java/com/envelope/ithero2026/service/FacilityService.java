package com.envelope.ithero2026.service;

import com.envelope.ithero2026.domain.Facility;
import com.envelope.ithero2026.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilityService
{
    private final FacilityRepository repository;

    public Facility loadEntityById(long id)
    {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Facility with id" + id + " not found"));
    }
}
