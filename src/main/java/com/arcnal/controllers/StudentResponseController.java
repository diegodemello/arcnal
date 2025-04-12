package com.arcnal.controllers;

import com.arcnal.entity.Question;
import com.arcnal.entity.User;
import com.arcnal.repository.QuestionRepository;
import com.arcnal.repository.UserRepository;
import com.arcnal.services.QuestionService;
import com.arcnal.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentResponseController {
    private final StudentService studentService;
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public StudentResponseController(StudentService studentService, QuestionService questionService, QuestionRepository questionRepository, UserRepository userRepository) {
        this.studentService = studentService;
        this.questionService = questionService;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitResponse(@RequestParam Long studentId, @RequestParam Long questionId, @RequestParam String chosenAlternative){
        User student = userRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Esse aluno não existe."));
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Essa questão não existe."));

        studentService.saveResponse(student, question, chosenAlternative);
        return studentService.responseQuestion(question, chosenAlternative);
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> listQuestions(){
        List<Question> questions = questionService.findAll();
        return ResponseEntity.ok(questions);
    }
}
