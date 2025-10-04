package com.example.employee_crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // Маркер для Spring
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Spring дає save, findAll, findById, deleteById автоматично

    // Кастомний запит: Знайти за відділом
    List<Employee> findByDepartment(String department);

    // SQL-запит: Зарплата > 50000
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> findHighSalaryEmployees(double minSalary);
}