package com.example.employee_crud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity  // Це таблиця в БД
public class Employee {
    @Id  // Первинний ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Авто-ID
    private Long id;

    @NotBlank(message = "Ім'я не може бути порожнім")  // Валідація
    private String name;

    @Positive(message = "Зарплата повинна бути > 0")
    private double salary;

    private String department;  // Відділ

    // Порожній конструктор (для JPA)
    public Employee() {}

    // Конструктор з параметрами
    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Getters і Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    // toString для виведення
    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Ім'я='" + name + "', Зарплата=" + salary + ", Відділ='" + department + "']";
    }
}