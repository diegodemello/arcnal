package com.arcnal.services;

import com.arcnal.entity.Question;
import com.arcnal.entity.StudentResponse;
import com.arcnal.entity.User;
import com.arcnal.repository.StudentResponseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentResponseRepository studentResponseRepository;

    public StudentService(StudentResponseRepository studentResponseRepository) {
        this.studentResponseRepository = studentResponseRepository;
    }

    public void saveResponse(User user, Question question, String chosenAlternative){
        boolean isCorrect = question.getCorrectAlternative().equalsIgnoreCase(chosenAlternative);
        StudentResponse response = new StudentResponse();
        response.setStudent(user);
        response.setQuestion(question);
        response.setChoseAlternative(chosenAlternative);
        response.setCorrect(isCorrect);
        studentResponseRepository.save(response);
    }

    public ResponseEntity<String> responseQuestion(Question question, String chosenAlternative) {
        if (question.getCorrectAlternative().equalsIgnoreCase(chosenAlternative)) {
            return ResponseEntity.ok("Alternativa correta");
        } else {
            return ResponseEntity.ok("Alternativa incorreta. Correção: " + question.getExplanation());
        }
    }
}
