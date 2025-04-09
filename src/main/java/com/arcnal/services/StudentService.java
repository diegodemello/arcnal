package com.arcnal.services;

import com.arcnal.entity.Question;
import com.arcnal.entity.StudentResponse;
import com.arcnal.entity.User;
import com.arcnal.repository.StudentResponseRepository;

import java.util.List;

public class StudentService {
    private final StudentResponseRepository studentResponseRepository;
    private StudentResponse response;

    public StudentService(StudentResponseRepository studentResponseRepository) {
        this.studentResponseRepository = studentResponseRepository;
    }

    public void saveResponse(User user, Question question, String chosenAlternative){
        boolean isCorrect = question.getCorrectAlternative().equalsIgnoreCase(chosenAlternative);
        response.setStudent(user);
        response.setQuestion(question);
        response.setChoseAlternative(chosenAlternative);
        response.setCorrect(isCorrect);
        studentResponseRepository.save(response);
    }

    public List<StudentResponse> listResponse(User student){
        return studentResponseRepository.findByStudent(student);
    }
}
