package com.envelope.ithero2026.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "facilities")
public class Facility
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String location;
}
