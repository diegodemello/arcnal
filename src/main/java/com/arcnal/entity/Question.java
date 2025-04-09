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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getAlternativeA() {
        return alternativeA;
    }

    public void setAlternativeA(String alternativeA) {
        this.alternativeA = alternativeA;
    }

    public String getAlternativeB() {
        return alternativeB;
    }

    public void setAlternativeB(String alternativeB) {
        this.alternativeB = alternativeB;
    }

    public String getAlternativeC() {
        return alternativeC;
    }

    public void setAlternativeC(String alternativeC) {
        this.alternativeC = alternativeC;
    }

    public String getAlternativeD() {
        return alternativeD;
    }

    public void setAlternativeD(String alternativeD) {
        this.alternativeD = alternativeD;
    }

    public String getAlternativeE() {
        return alternativeE;
    }

    public void setAlternativeE(String alternativeE) {
        this.alternativeE = alternativeE;
    }

    public String getCorrectAlternative() {
        return correctAlternative;
    }

    public void setCorrectAlternative(String correctAlternative) {
        this.correctAlternative = correctAlternative;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
