package com.envelope.ithero2026.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
public class Inspection
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Enumerated(EnumType.STRING)
    private InspectionType type;

    @ManyToOne
    @JoinColumn(name = "performer_id", nullable = false)
    private User performer;

    @ManyToOne
    @JoinColumn(name = "master_id", nullable = false)
    private User master;

    @Enumerated(EnumType.STRING)
    private InspectionStatus status;
}
