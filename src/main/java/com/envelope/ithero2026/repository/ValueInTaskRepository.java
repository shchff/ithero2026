package com.envelope.ithero2026.repository;

import com.envelope.ithero2026.domain.ValueInTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValueInTaskRepository extends JpaRepository<ValueInTask, Long>
{
    List<ValueInTask> findAllByTaskId(Long taskId);
}
