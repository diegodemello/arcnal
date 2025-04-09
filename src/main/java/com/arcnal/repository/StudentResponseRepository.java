package com.arcnal.repository;

import com.arcnal.entity.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentResponseRepository extends JpaRepository<Long, StudentResponse> {
}
