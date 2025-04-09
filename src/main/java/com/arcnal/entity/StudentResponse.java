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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getChoseAlternative() {
        return choseAlternative;
    }

    public void setChoseAlternative(String choseAlternative) {
        this.choseAlternative = choseAlternative;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
