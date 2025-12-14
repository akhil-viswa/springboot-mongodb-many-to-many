# Spring Boot + MongoDB – Many-to-Many Example

This project demonstrates how to implement **many-to-many relationships** in **Spring Boot with MongoDB** using **best practices** (ID references + aggregation), without using JPA-style annotations like `@ManyToMany`.

---

## 🚀 Tech Stack
- Java 17+
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Maven

---

## 📂 Project Structure
```
com.example.demo
 ├── controller      # REST controllers
 ├── service         # Business logic
 ├── repository      # Mongo repositories
 ├── model           # MongoDB documents
 ├── dto             # Aggregation DTOs
 └── DemoApplication # Main class
```

---

## 🧩 Use Case
**Users ↔ Roles (Many-to-Many)**
- One user can have multiple roles
- One role can be assigned to multiple users

MongoDB Collections:
- `users`
- `roles`

---

## 🗄️ Data Model

### User Collection
```json
{
  "_id": "u1",
  "name": "Akhil",
  "roleIds": ["r1", "r2"]
}
```

### Role Collection
```json
{
  "_id": "r1",
  "name": "ADMIN"
}
```

---

## ⚙️ Configuration

### application.properties
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/many_to_many_db
server.port=8081
```

---

## ▶️ How to Run

### 1️⃣ Start MongoDB
```bash
mongod
```

### 2️⃣ Build Project
```bash
mvn clean install
```

### 3️⃣ Run Application
```bash
mvn spring-boot:run
```

Application will be available at:
```
http://localhost:8081
```

---

## 📡 API Endpoints

### Create User
```http
POST /users
```
```json
{
  "name": "Akhil",
  "roleIds": ["roleId1", "roleId2"]
}
```

### Get User with Roles
```http
GET /users/{id}
```

---

## 🔍 How Many-to-Many Works
- Users store **role IDs** instead of embedding full role objects
- MongoDB **aggregation lookup** is used to fetch roles
- This avoids performance issues caused by `@DBRef`

---

## ❌ What Is NOT Used (Intentionally)
- `@ManyToMany`
- `@DBRef`
- HikariCP (MongoDB uses its own connection pool)

---

## 🏆 Best Practices Followed
- Scalable data modeling
- Aggregation-based joins
- Clean separation of layers
- Production-ready structure

---

## 🎯 Interview-Ready Explanation
> MongoDB does not support JPA-style relationships. Many-to-many is implemented using ID references and aggregation pipelines based on access patterns.

---

## 📌 Possible Enhancements
- Join-collection approach (`user_roles`)
- Pagination & sorting
- MongoDB transactions
- Docker & Docker Compose setup
- Indexing strategy

---

## 👨‍💻 Author
Akhil Viswanadhuni

---

## 📄 License
This project is for learning and demonstration purposes.
