# employee-management-system
## Project Overview
The **Employee Management System** is a full-stack web application developed to manage employee details efficiently.  
It allows users to **add, view, update, delete, and search employees** through a user-friendly interface.
The project follows a **RESTful architecture**, where the frontend communicates with the backend using HTTP APIs, and data is stored securely in a relational database.
## Technologies Used
### Frontend
- Angular
- TypeScript
- HTML5
- CSS3
- Bootstrap
- HttpClient for API communication
### Backend
- Spring Boot
- Spring Web (REST APIs)
- Spring Data JPA
- Hibernate
- Lombok
- Java Validation API
### Database
- MySQL
### Tools & Others
- Eclipse IDE
- VS Code
- Maven
- Git & GitHub
- Docker (optional containerization)
## Project Architecture
Frontend (Angular)
↓
REST APIs (Spring Boot Controller)
↓
Service Layer (Business Logic)
↓
Repository Layer (JPA/Hibernate)
↓
Database (MySQL)
## Features
- Add new employee details
- View all employees
- Update employee information
- Delete employee records
- Search employees by keyword
- Fetch employee by ID or employee code
- Backend validation for data integrity
- Enum-based fields for controlled values
- Automatic timestamp handling (createdAt, updatedAt)
## Backend Structure
src/main/java
└── com.example.employee
├── controller
├── service
├── repository
├── entity
└── exception
## Frontend Structure
src/app
├── components
│ ├── employee-list
│ └── employee-form
├── models
├── services
└── app.routes.ts
## API Endpoints (Sample)
| Method | Endpoint | Description |
|------|---------|------------|
| POST | /api/employees | Add new employee |
| PUT | /api/employees/{id} | Update employee |
| GET | /api/employees | Get all employees |
| GET | /api/employees/by-id | Get employee by ID |
| GET | /api/employees/by-code | Get employee by code |
| DELETE | /api/employees/{id} | Delete employee |
| GET | /api/employees/search | Search employees |
## Data Validation & Integrity
- Backend validations using annotations like `@NotBlank`, `@Email`, `@Pattern`
- Enums used for controlled values (Gender, EmploymentType, EmployeeStatus)
- Unique constraints on employee code and email
- Automatic audit fields using `@PrePersist` and `@PreUpdate`
## How to Run the Project
### Backend
1. Configure MySQL database in `application.yml`
2. Run the Spring Boot application from Eclipse or using:
mvn spring-boot:run
### Frontend
1. Install dependencies:
npm install
2. Run Angular app:
ng serve
3. Access application at:
http://localhost:4200
## Future Enhancements
- Authentication and Authorization (JWT, Spring Security)
- Role-based access control (Admin/User)
- Pagination and sorting
- Cloud deployment
- File upload for profile images
## Conclusion
This project demonstrates practical knowledge of **full-stack development**, **RESTful APIs**, **database integration**, and **clean backend architecture**, reflecting real-world enterprise application design.
## Author
**Varsha G K**
 *Feel free to fork this repository and enhance it further.*
