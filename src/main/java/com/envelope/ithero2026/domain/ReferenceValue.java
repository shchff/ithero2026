package com.envelope.ithero2026.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "reference_values")
public class ReferenceValue
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "double precision")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;
}