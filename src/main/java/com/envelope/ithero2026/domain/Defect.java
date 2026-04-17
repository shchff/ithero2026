package com.envelope.ithero2026.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "defects")
public class Defect
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
}