package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        if(employeeRepository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if (employeeRepository.existsByEmployeeCode(employee.getEmployeeCode())) {
            throw new RuntimeException("Employee code already exists");
        }

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        existing.setName(updatedEmployee.getName());
        existing.setDepartment(updatedEmployee.getDepartment());
        existing.setDesignation(updatedEmployee.getDesignation());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setPhoneNumber(updatedEmployee.getPhoneNumber());
        existing.setEmergencyContact(updatedEmployee.getEmergencyContact());
        existing.setSalary(updatedEmployee.getSalary());
        existing.setExperienceYears(updatedEmployee.getExperienceYears());
        existing.setWorkLocation(updatedEmployee.getWorkLocation());
        existing.setAddress(updatedEmployee.getAddress());
        existing.setDateOfBirth(updatedEmployee.getDateOfBirth());
        existing.setDateOfJoining(updatedEmployee.getDateOfJoining());
        existing.setLastWorkingDay(updatedEmployee.getLastWorkingDay());
        existing.setGender(updatedEmployee.getGender());
        existing.setEmploymentType(updatedEmployee.getEmploymentType());
        existing.setStatus(updatedEmployee.getStatus());

        return employeeRepository.save(existing);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee findByEmployeeCode(String employeeCode) {
        return employeeRepository.findByEmployeeCode(employeeCode)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public List<Employee> searchEmployee(String keyword) {
        return employeeRepository.searchEmployees(keyword);
    }

}
