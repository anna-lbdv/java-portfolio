# java-portfolio
# Java Portfolio for EPAM Training

My first Java projects! This portfolio is built to prepare for the EPAM Java Development program. It includes examples from basic console apps to Spring Boot REST APIs.

## Tech Stack
- **Java 17** (Core, OOP, Collections, Streams, Generics)
- **Spring Boot 3.x** (MVC, JPA, H2 Database)
- **Maven** (build tool)
- **Git** (version control)
- Bonus: SQL basics, Algorithms (LeetCode-style)

## Projects

### 1. Java Basics Console App
- **Description**: Simple OOP program with classes, methods, and exception handling.
- **What I Learned**: Variables, loops, if/else, try-catch.
- **How to Run**: `javac Main.java && java Main`
- [Code Link](project1/) (add later)

### 2. TODO Console App
- **Description**: CLI app for task management (add/list/remove) using ArrayList and Streams.
- **What I Learned**: Collections API, Streams for filtering/mapping.
- **How to Run**: `java TodoApp`
- [Code Link](project2/)

### 3. Spring Boot CRUD API
- **Description**: RESTful service for managing tasks with H2 database.
- **What I Learned**: Spring Boot (Controller, Service, Repository), JPA, HTTP methods (GET/POST/PUT/DELETE).
- **How to Run**: `mvn spring-boot:run` → Test in Postman at localhost:8080/tasks
- **Endpoints**:
  - GET /tasks — Get all tasks
  - POST /tasks — Create task (JSON: {"description": "Buy milk"})
- [Code Link](spring-crud/)

## Setup and Run
1. Install JDK 17: [Download here](https://www.oracle.com/java/technologies/downloads/)
2. IntelliJ IDEA: [Free Community Edition](https://www.jetbrains.com/idea/download/)
3. Clone repo: `git clone https://github.com/yourusername/java-portfolio.git`
4. For Maven projects: `mvn clean install`

## Next Steps
- Adding SQL integration and front-end (HTML/JS).
- LeetCode solutions in a separate branch.

Contact: [LinkedIn](your-linkedin-link) | Email: your@email.com

Thanks for checking it out! 🚀
