# Employee Management CRUD API

RESTful API для керування співробітниками: створення, читання, оновлення, видалення (CRUD). Використовує Spring Boot для backend, JPA для БД, H2 як вбудовану базу. Фільтри за відділом і зарплатою з Streams.

## Стек технологій
- **Java 19** (Core, OOP)
- **Spring Boot 3.2.x** (MVC, Auto-configuration)
- **Spring Data JPA** (Repository, @Query)
- **H2 Database** (in-memory БД)
- **Validation** (@NotBlank, @Positive)
- **Maven** (build tool)

## Функції
- CREATE: Додати співробітника (POST /employees)
- READ: Список всіх / один / за відділом / високі зарплати (>70k з Streams)
- UPDATE: Оновити за ID (PUT /employees/{id})
- DELETE: Видалити за ID (DELETE /employees/{id})
- БД: Авто-створення таблиць, веб-консоль H2

## Як запустити
1. **Install JDK 19:** [Download](https://www.oracle.com/java/technologies/downloads/)
2. **IntelliJ IDEA:** [Community Edition](https://www.jetbrains.com/idea/download/)
3. **Clone & Build:** `git clone [repo-link]` → Open in IntelliJ → Maven Reload → Run 'EmployeeCrudApplication'.
4. **Test:** Сервер на localhost:8080. Використовуй Postman або curl.
5. **H2 Console:** localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:testdb, User: sa).

## Endpoints
| Method | Endpoint | Description | Example Request | Example Response |
|--------|----------|-------------|-----------------|------------------|
| POST | /employees | Create employee | `{"name":"Іван","salary":60000,"department":"Dev"}` | `{"id":1,"name":"Іван",...}` |
| GET | /employees | Get all | - | `[{"id":1,...}]` |
| GET | /employees/{id} | Get by ID | - | `{"id":1,"name":"Іван",...}` |
| PUT | /employees/{id} | Update | `{"name":"Іван Петренко","salary":70000,...}` | Оновлений об'єкт |
| DELETE | /employees/{id} | Delete | - | 204 No Content |
| GET | /employees/department/{dept} | By department | - | Фільтр за "Dev" |
| GET | /employees/high-salary | High salary (>70k) | - | Фільтр з Streams |

## Скріншоти
- Postman requests
- <img width="1377" height="791" alt="Screenshot_1" src="https://github.com/user-attachments/assets/338889ff-356e-4ae9-b027-3334143fe894" />
- <img width="1398" height="805" alt="Screenshot_2" src="https://github.com/user-attachments/assets/f0c399a2-feb2-4547-9bf8-9fd4dedfbf5c" />
- <img width="1376" height="743" alt="Screenshot_3" src="https://github.com/user-attachments/assets/8fb94815-cc88-475e-9f7c-bffb95275029" />
- <img width="1380" height="694" alt="Screenshot_4" src="https://github.com/user-attachments/assets/73d2918b-21f4-488a-8bac-05d48b6495a4" />


- H2 Console Table
- <img width="943" height="460" alt="Screenshot_1" src="https://github.com/user-attachments/assets/f4abcc46-7a1c-4f56-9801-1b2f5eee0368" />

Дякую🚀 Контакт: [LinkedIn](https://www.linkedin.com/in/anna-lebedieva-ab4080226/)
