package com.arcnal.entity;

import jakarta.persistence.*;

@Entity(name = "tb_question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String statement;
    private String alternativeA;
    private String alternativeB;
    private String alternativeC;
    private String alternativeD;
    private String alternativeE;
    private String correctAlternative;
    private String explanation;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;
}
