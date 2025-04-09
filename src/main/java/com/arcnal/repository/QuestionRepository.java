package com.arcnal.repository;

import com.arcnal.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Long, Question> {
}
