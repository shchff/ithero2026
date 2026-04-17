package com.envelope.ithero2026.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reference_values")
@Getter
@Setter
public class ReferenceValue
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "min_value", columnDefinition = "double precision")
    private Double minValue;

    @Column(name = "max_value", columnDefinition = "double precision")
    private Double maxValue;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;
}