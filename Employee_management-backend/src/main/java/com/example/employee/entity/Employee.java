package com.example.employee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String employeeCode;

    @NotBlank
    private String name;

    @NotBlank
    private String department;

    @NotBlank
    private String designation;

    @Email
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String phoneNumber;

    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String emergencyContact;

    private Double salary;

    private Integer experienceYears;

//    private Long managerId;

    private String workLocation;

    @Column(length = 500)
    private String address;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoining;

    private LocalDate lastWorkingDay;

    // 🔹 Image Fields
    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status = EmployeeStatus.ACTIVE;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
