package com.envelope.ithero2026.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;

@Entity
@Getter
public class Inspection
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @ManyToOne
    @JoinColumn(name = "performer_id", nullable = false)
    private User performer;

    @ManyToOne
    @JoinColumn(name = "master_id", nullable = false)
    private User master;
}
