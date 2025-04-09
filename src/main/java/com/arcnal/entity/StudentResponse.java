package com.arcnal.entity;

import jakarta.persistence.*;

@Entity(name = "tb_response")
public class StudentResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    private String choseAlternative;
    private Boolean correct;
}
