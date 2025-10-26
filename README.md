# 🔐 JWT Authentication with Spring Boot

A simple demo project built with **Spring Boot 3.2.0**, **Java 17**, and **MySQL**, demonstrating **JWT-based authentication**.

---

## 🚀 Overview

This project provides a basic example of implementing **JSON Web Token (JWT)** authentication using Spring Boot.  
It allows users to register, log in, and access protected routes only when authenticated.

**Main features:**
- User registration and login
- JWT token generation and validation
- Password hashing with Spring Security
- Protected REST endpoints
- Integration with MySQL

---

## 🧰 Tech Stack

| Layer | Technology |
|--------|-------------|
| Backend | Spring Boot 3.2.0 |
| Security | Spring Security + JWT |
| Database | MySQL |
| ORM | Spring Data JPA |
| Build Tool | Maven |
| Language | Java 17 |

---

## 🗂️ Project Structure

```
jwt-auth-springboot/
│
├── src/main/java/com/achraf/security/
│   ├── controller/
│   │   └── AuthController.java
│   ├── service/
│   │   ├── AuthService.java
│   │   └── CustomUserDetailsService.java
│   ├── config/
│   │   └── SecurityConfig.java
│   ├── model/
│   │   └── User.java
│   ├── repository/
│   │   └── UserRepository.java
│   ├── util/
│   │   └── JwtUtil.java
│   └── JwtAuthSpringbootApplication.java
│
├── src/main/resources/
│   └── application.properties
│
├── pom.xml
└── README.md
```

---

## ⚙️ Configuration

Edit your `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jwtauth?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

spring.application.name=jwt-auth-springboot
server.port=8080
```

---

## 🏗️ Setup & Run

### 1. Clone the repository
```bash
git clone https://github.com/achramoustatir/jwt-auth-springboot.git
cd jwt-auth-springboot
```

### 2. Build the project
```bash
mvn clean package
```

### 3. Run the application
```bash
java -jar target/jwt-auth-springboot-0.0.1-SNAPSHOT.jar
```

The app runs by default on:  
👉 **http://localhost:8080**

---

## 📡 API Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|-----------|--------------|---------------|
| POST | `/api/auth/register` | Register a new user | ❌ No |
| POST | `/api/auth/login` | Authenticate user and return JWT | ❌ No |
| GET | `/api/users` | Retrieve list of users | ✅ Yes (JWT) |

---

## 🔑 Example API Usage (via Postman)

### 1. Register a new user
**POST** `/api/auth/register`

**Body (JSON):**
```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

**Response:**
```json
{
  "message": "User registered successfully"
}
```

---

### 2. Login and get JWT token
**POST** `/api/auth/login`

**Body (JSON):**
```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5..."
}
```

---

### 3. Access protected endpoint
**GET** `/api/users`

In Postman, add the token to the **Authorization** header:

```
Authorization: Bearer <your_token_here>
```

**Response example:**
```json
[
  {
    "id": 1,
    "email": "user@example.com"
  }
]
```

---

## 🔄 JWT Authentication Flow

Below is a simplified sequence of how authentication works:

1. Client sends credentials (`email`, `password`) to `/api/auth/login`
2. `AuthController` delegates to `AuthService`
3. `AuthService` uses `AuthenticationManager` to validate the user
4. `CustomUserDetailsService` loads user from `UserRepository`
5. If valid, `JwtUtil` generates a token
6. The token is sent back to the client
7. The client uses the token in Authorization headers for protected routes

### 📊 Sequence Diagram

![JWT Flow Diagram](/docs/authJWT.png)

---

## 🧠 Notes

- You can customize the token expiration and secret key inside `JwtUtil.java`.
- The password is securely hashed using `BCryptPasswordEncoder`.
- To test easily, you can use Postman collections and environment variables.

---

## 🧑‍💻 Author

**Achraf Moustatir**  
🔗 [GitHub Profile](https://github.com/achrafmoustatir)

---

## 📄 License

This project is licensed under the **MIT License**.  
Feel free to use, modify, and share it.

---
