package com.arcnal.controllers;

import com.arcnal.entity.Question;
import com.arcnal.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        Question saved = questionService.save(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Question>> findAllQuestions(){
        List<Question> all = questionService.findAll();
        return ResponseEntity.ok(all);
    }
}