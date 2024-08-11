package com.example.student_management.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.student_management.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    
}
