package com.envelope.ithero2026.repository;

import com.envelope.ithero2026.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>
{
    List<Task> findByInspectionId(long inspectionId);
}
