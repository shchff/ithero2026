package com.envelope.ithero2026.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "values_in_task",
        uniqueConstraints = @UniqueConstraint(columnNames = {"reference_id", "task_id"}))
public class ValueInTask
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reference_id", nullable = false)
    private ReferenceValue reference;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "value", columnDefinition = "double precision")
    private Double value;
}
