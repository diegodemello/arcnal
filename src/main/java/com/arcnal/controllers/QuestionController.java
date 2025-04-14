package com.arcnal.controllers;

import com.arcnal.entity.Question;
import com.arcnal.entity.User;
import com.arcnal.entity.UserType;
import com.arcnal.repository.UserRepository;
import com.arcnal.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;
    private final UserRepository userRepository;

    public QuestionController(QuestionService questionService, UserRepository userRepository) {
        this.questionService = questionService;
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        Long creatorId = question.getCreator().getId();
        User creator = userRepository.findById(creatorId).orElseThrow(() -> new RuntimeException("Esse usuário não existe."));
        if(creator.getUserType().equals(UserType.STUDENT)){
            throw new RuntimeException("Você não tem autorização para cadastrar uma questão.");
        }
        question.setCreator(creator);
        Question saved = questionService.save(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Question>> findAllQuestions(){
        List<Question> all = questionService.findAll();
        return ResponseEntity.ok(all);
    }

    @DeleteMapping
    public void deleteQuestion(Long id){
        questionService.delete(id);
    }
}