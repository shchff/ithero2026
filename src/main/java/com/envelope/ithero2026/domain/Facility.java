package com.envelope.ithero2026.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "facilities")
@Getter
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
