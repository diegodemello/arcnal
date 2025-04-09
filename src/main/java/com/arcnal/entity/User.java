package com.arcnal.entity;

import jakarta.persistence.*;

@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_Type")
    private UserType userType;
}
