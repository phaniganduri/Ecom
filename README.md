# 🛒 E-Commerce Spring Boot Application

This is a **Spring Boot E-Commerce API** project built with:
- Spring Boot 3.5.0
- REST API endpoints
- Spring Data JPA & Hibernate ORM
- MySQL database
- HikariCP connection pool
- Embedded Tomcat server

## 🚀 Features
- Product Management (Add, View, Update, Delete)
- REST API-based architecture
- MySQL database integration
- Spring Data JPA repository support
- Hibernate ORM with auto schema update
- Uses HikariCP for efficient DB connection pooling

## 🛠 Tech Stack
- **Backend:** Java 17, Spring Boot 3.5.0
- **Database:** MySQL 8.x
- **ORM:** Hibernate (JPA)
- **Build Tool:** Maven
- **Server:** Embedded Tomcat 10.x

## 📂 Project Structure
Ecom/
├── src/main/java/com/ecom
│ ├── EcomApplication.java # Main Spring Boot entry point
│ ├── controller/ # REST Controllers
│ ├── model/ # Entity classes
│ ├── repository/ # JPA Repositories
│ └── service/ # Business logic
├── src/main/resources
│ ├── application.properties # Spring Boot configuration
│ └── data.sql / schema.sql # Initial data (optional)
├── pom.xml
└── README.md
