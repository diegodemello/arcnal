package com.arcnal.services;

import com.arcnal.entity.Question;
import com.arcnal.entity.UserType;
import com.arcnal.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question save(Question question){
        if(question.getCreator().getUserType() != UserType.TEACHER){
            throw new RuntimeException("Apenas professores podem cadastrar questões.");
        }
        return questionRepository.save(question);
    }

    public List<Question> findAll(){
        return questionRepository.findAll();
    }

    public void delete(Long id){
        questionRepository.deleteById(id);
    }
}
