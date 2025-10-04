package com.example.employee_crud;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  // JSON API
@RequestMapping("/employees")  // Базовий шлях
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // CREATE: POST /employees
    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // READ all: GET /employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // READ one: GET /employees/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // READ за відділом: GET /employees/department/{dept}
    @GetMapping("/department/{dept}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String dept) {
        return employeeService.getEmployeesByDepartment(dept);
    }

    // UPDATE: PUT /employees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employeeDetails) {
        Employee updated = employeeService.updateEmployee(id, employeeDetails);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE: DELETE /employees/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Бонус: GET /employees/high-salary
    @GetMapping("/high-salary")
    public List<Employee> getHighSalaryEmployees() {
        return employeeService.getHighSalaryEmployees();
    }
}