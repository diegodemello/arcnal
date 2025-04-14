package com.arcnal.controllers;

import com.arcnal.entity.Question;
import com.arcnal.entity.StudentResponse;
import com.arcnal.entity.User;
import com.arcnal.repository.QuestionRepository;
import com.arcnal.repository.UserRepository;
import com.arcnal.services.QuestionService;
import com.arcnal.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentResponseController {
    private final StudentService studentService;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public StudentResponseController(StudentService studentService, QuestionRepository questionRepository, UserRepository userRepository) {
        this.studentService = studentService;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/questions")
    public ResponseEntity<String> submitResponse(@RequestParam Long studentId, @RequestParam Long questionId, @RequestParam String chosenAlternative){
        User student = userRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Esse aluno não existe."));
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Essa questão não existe."));

        studentService.saveResponse(student, question, chosenAlternative);
        return studentService.responseQuestion(question, chosenAlternative);
    }
}
