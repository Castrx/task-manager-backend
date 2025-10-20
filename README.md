# 📝 Task Manager API

A simple yet powerful **Task Management REST API** built with **Spring Boot**, featuring **JWT authentication** and **user-based task control**.  
Designed for learning, portfolio showcasing, and real-world backend experience.

---

## 🚀 Tech Stack

| Layer | Technologies |
|:------|:--------------|
| Language | **Java 17** |
| Framework | **Spring Boot 3**, **Spring Security**, **Spring Data JPA** |
| Database | **H2 (in-memory)** |
| Build Tool | **Maven** |
| Auth | **JWT (JSON Web Token)** |
| Testing | **VSCode REST Client / Postman** |

---

## ⚙️ Features

✅ Register and authenticate users via JWT  
✅ Create, read, update, and delete tasks  
✅ Each user can only access their own tasks  
✅ Secure endpoints with Spring Security  
✅ In-memory H2 database for easy testing  
✅ Modular and clean architecture  

---

## 🧩 API Endpoints

### 🔐 Authentication
| Method | Endpoint | Description |
|:------:|:----------|:-------------|
| `POST` | `/api/auth/register` | Register a new user |
| `POST` | `/api/auth/login` | Login and receive a JWT token |

### 🧠 Tasks
| Method | Endpoint | Description |
|:------:|:----------|:-------------|
| `GET` | `/api/tasks` | List all tasks for the logged-in user |
| `POST` | `/api/tasks` | Create a new task |
| `PUT` | `/api/tasks/{id}` | Update an existing task |
| `DELETE` | `/api/tasks/{id}` | Delete a task |

---

## 🧪 Quick Start (H2 Database)

### 1️⃣ Clone the repository
```bash
git clone https://github.com/Castrx/task-manager-backend.git
cd task-manager-backend/taskmanager
2️⃣ Run the application
Using Maven Wrapper:

bash
Copiar código
.\mvnw spring-boot:run
3️⃣ Access the app
Server: http://localhost:8080
H2 Console: http://localhost:8080/h2-console

Default JDBC settings:

yaml
Copiar código
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave empty)
🧠 Example Requests (VSCode REST Client)
http
Copiar código
### Register
POST http://localhost:8080/api/auth/register
Content-Type: application/json

{
  "username": "gabriel",
  "email": "gabriel@email.com",
  "password": "123456"
}

### Login
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "username": "gabriel",
  "password": "123456"
}
After login, copy the token and use it as:

makefile
Copiar código
Authorization: Bearer YOUR_TOKEN_HERE
🧱 Project Structure
bash
Copiar código
src
 ├── main
 │   ├── java/com/gabriel/taskmanager
 │   │   ├── controller      # REST controllers
 │   │   ├── domain          # Entities (User, Task)
 │   │   ├── repository      # JPA Repositories
 │   │   ├── security        # JWT filters & configuration
 │   │   └── service         # Business logic
 │   └── resources
 │       ├── application.properties
 │       └── data.sql (optional sample data)
 └── test
📘 Documentation
Once the app is running:

H2 Console: /h2-console

(Optional) Swagger (if added later): /swagger-ui.html

🔮 Next Features (Planned Improvements)
PostgreSQL configuration (for production use)

Swagger UI documentation

Docker Compose setup

Unit and integration tests with JUnit

User roles: ADMIN and USER

👨‍💻 Author
Gabriel de Castro Pinto
🔗 GitHub Profile
💼 Java / Spring Boot Developer

⭐ If you found this project helpful, consider starring the repo to support future projects! 🌟
