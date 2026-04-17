package com.envelope.ithero2026.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inspection_id", nullable = false)
    private Inspection inspection;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;
}