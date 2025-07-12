📝 Todo List Project with User Management
A Spring Boot-based RESTful application for managing personal todo lists with full user support. Built using Spring Boot 3.4.1, Java 21, and PostgreSQL.

🚀 Features
👤 User Management

Create, update, delete, and retrieve users

✅ Todo Management

Create, update, delete, and retrieve todo items

Assign todos to users

🌐 REST API

Clean RESTful architecture ready for frontend or mobile integration

🛢️ PostgreSQL / JPA Integration

Use PostgreSQL as default database (H2/MySQL switchable)

🛠️ Tech Stack
Layer	Technology
Language	Java 21
Framework	Spring Boot 3.4.1
ORM	Spring Data JPA
Database	PostgreSQL (runtime)
Tools	Maven, Lombok
Testing	Spring Boot Starter Test

📦 Installation & Running
✅ Prerequisites
Java 21+

Maven 3.8+

PostgreSQL database (or use H2 in dev)

⚙️ Configure PostgreSQL (Optional)
In application.properties or application.yml:

spring.datasource.url=jdbc:postgresql://localhost:5432/todo_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
🏃 Run the App
bash
Copy
Edit
# Clone the project
git clone https://github.com/your-username/todo-list-project.git
cd todo-list-project

# Build and run
mvn spring-boot:run
Visit: http://localhost:8080

📌 API Reference
User Endpoints (/users)
GET /users – List all users

GET /users/{id} – Get user by ID

POST /users – Create user

PUT /users/{id} – Update user

DELETE /users/{id} – Delete user

Todo Endpoints (/todos)
GET /todos – List all todos

GET /todos/{id} – Get todo by ID

POST /todos – Create todo

PUT /todos/{id} – Update todo

DELETE /todos/{id} – Delete todo

GET /todos/user/{userId} – Todos for a specific user




