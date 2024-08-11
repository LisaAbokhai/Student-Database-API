package com.example.student_management.cofig;

import com.example.student_management.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.student_management.repository.StudentRepository;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfiguration {
    
        @Bean
        CommandLineRunner commandLineRunner(StudentRepository repository) {
            return args -> {
                Student mariam = new Student(
                        1L,
                        "Mariam",
                        "1234567890",
                        "majaro onike",
                        "Lagos",
                        "tobe@gmail.com",
                        LocalDate.of(2000, 1, 5));

                Student alex = new Student(
                        2L,
                        "Alex",
                        "1234567890",
                        "majaro onike",
                        "Lagos",
                        "lisa@gmail.com",
                        LocalDate.of(2004, 1, 5));

                repository.saveAll(List.of(mariam, alex));

            };

        }
    
}
