package com.example.employee.repository;

import com.example.employee.entity.Employee;
import com.example.employee.entity.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find by employee code
    Optional<Employee> findByEmployeeCode(String employeeCode);

    // Find by email
    Optional<Employee> findByEmail(String email);

    // Search employee (partial match)
    @Query("""
        SELECT e FROM Employee e
        WHERE 
            LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR LOWER(e.designation) LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR LOWER(e.phoneNumber) LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR CAST(e.employeeCode AS string) LIKE CONCAT('%', :keyword, '%')
    """)
    List<Employee> searchEmployees(@Param("keyword") String keyword);

    // Search by department
    List<Employee> findByDepartment(String department);

    // Search by designation
    List<Employee> findByDesignation(String designation);

    // Find employees by status
    List<Employee> findByStatus(EmployeeStatus status);


    // Find employees by work location
    List<Employee> findByWorkLocation(String workLocation);


    boolean existsByEmployeeCode(String employeeCode);
    boolean existsByEmail(String email);

    // Advanced search examples
    List<Employee> findByDepartmentAndStatus(String department, EmployeeStatus status);
}
