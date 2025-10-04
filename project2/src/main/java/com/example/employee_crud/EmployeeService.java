package com.example.employee_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service  // Маркер для Spring
public class EmployeeService {
    @Autowired  // Spring вставляє репозиторій
    private EmployeeRepository employeeRepository;

    // CREATE
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // READ all
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // READ one
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // READ за відділом
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    // UPDATE
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(employeeDetails.getName());
            employee.setSalary(employeeDetails.getSalary());
            employee.setDepartment(employeeDetails.getDepartment());
            return employeeRepository.save(employee);
        }
        return null;
    }

    // DELETE
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Бонус: Високі зарплати з Streams
    public List<Employee> getHighSalaryEmployees() {
        List<Employee> highSalary = employeeRepository.findHighSalaryEmployees(50000);
        return highSalary.stream()
                .filter(e -> e.getSalary() > 70000)  // Додатковий фільтр
                .collect(Collectors.toList());
    }
}