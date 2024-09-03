package com.example.student_management.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;



@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    

    public Student addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(Long studentId, Student student) {
        Student student1 = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"));

        if (student.getName() != null &&
                student.getName().length() > 0 &&
                !student.getName().equals(student1.getName())) {
            student1.setName(student.getName());
        }

        if (student.getEmail() != null &&
                student.getEmail().length() > 0 &&
                !student.getEmail().equals(student1.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student1.setEmail(student.getEmail());
        }
        
        studentRepository.save(student1);
    }
    
}
