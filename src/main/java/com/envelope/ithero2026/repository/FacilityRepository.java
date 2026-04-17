package com.envelope.ithero2026.repository;

import com.envelope.ithero2026.domain.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long>
{
}
