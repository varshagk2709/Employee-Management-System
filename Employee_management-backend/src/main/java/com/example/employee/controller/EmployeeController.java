package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // Create Employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Update Employee
    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestParam Long id,
                                                   @Valid @RequestBody Employee employee) {
        Employee updated = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updated);
    }

    // Get Employee by ID
    @GetMapping("/by-id")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam Long id) {
        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Delete Employee
    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@RequestParam Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok("Employee deleted successfully...!");
    }

    // Get by Employee Code
    @GetMapping("/by-code")
    public ResponseEntity<Employee> getByEmployeeCode(@RequestParam String employeeCode) {
        Employee employee = employeeService.findByEmployeeCode(employeeCode);
        return ResponseEntity.ok(employee);
    }

    // Global Search
    // name / employeeId / phone / designation
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam String keyword) {
        return ResponseEntity.ok(employeeService.searchEmployee(keyword));
    }
}
