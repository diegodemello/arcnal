package com.arcnal.repository;

import com.arcnal.entity.StudentResponse;
import com.arcnal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentResponseRepository extends JpaRepository<StudentResponse, Long> {
    List<StudentResponse> findByStudent(User student);
}
