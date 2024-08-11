package com.example.student_management.controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.student_management.service.StudentService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.student_management.model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/register")
    public ResponseEntity<Student> registerNewStudent(@RequestBody Student student) {
        Student newStudent = studentService.addNewStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    @DeleteMapping(path = "{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId) {
       studentService.deleteStudent(studentId);
        return "Student with id " + studentId + " has been deleted";
    }

    @PutMapping(path = "update/{studentId}")
    public String updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody Student student) {
        studentService.updateStudent(studentId, student);
        return "Student with id " + studentId + " has been updated";
    }
    
}
