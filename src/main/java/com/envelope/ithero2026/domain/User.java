package com.envelope.ithero2026.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "users")
@Getter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String surname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String phone;
}
