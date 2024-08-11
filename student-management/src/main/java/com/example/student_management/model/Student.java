package com.example.student_management.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long studentId;

    private String name;

    private String phoneNo;

    private String address;

    private String city;

    @Column(
            nullable = false,
            unique = true
    )
    private String email;

    private LocalDate dob;

    
}
