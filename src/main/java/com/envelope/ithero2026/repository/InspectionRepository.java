package com.envelope.ithero2026.repository;

import com.envelope.ithero2026.domain.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InspectionRepository extends JpaRepository<Inspection, Long>
{
    List<Inspection> findByPerformerId(Long performerId);
    List<Inspection> findByMasterId(Long masterId);
}
