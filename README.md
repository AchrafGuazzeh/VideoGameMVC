<div align="center">

# 🎮 Video Game Library MVC

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)

**A simple web application to manage your video game collection with genres, studios, and games.**

</div>

---

## 📋 About

Video Game Library MVC is a full-stack web application that allows you to manage a video game collection. Built with Spring Boot and Thymeleaf, it provides a clean interface to create, read, update, and delete games, genres, and studios.

---

## ✨ Features

- ✅ **Manage Games** - Add, edit, view, and delete video games
- ✅ **Manage Genres** - Organize games by genres (Action, RPG, Sports, etc.)
- ✅ **Manage Studios** - Track game development studios
- ✅ **CRUD Operations** - Full Create, Read, Update, Delete functionality
- ✅ **Clean UI** - Simple and intuitive Thymeleaf templates

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Spring Boot** | Backend framework |
| **Spring Data JPA** | Database ORM |
| **Thymeleaf** | Template engine |
| **Lombok** | Reduce boilerplate code |
| **MySQL** | Database |
| **Spring Web** | Web MVC |

---

## 📊 Database Structure

```
┌─────────────┐       ┌─────────────┐       ┌─────────────┐
│   Genres    │       │    Games    │       │   Studios   │
├─────────────┤       ├─────────────┤       ├─────────────┤
│ id          │◄──────│ id          │──────►│ id          │
│ name        │       │ title       │       │ name        │
│             │       │ releaseYear │       │ location    │
│             │       │ genre_id    │       │             │
│             │       │ studio_id   │       │             │
└─────────────┘       └─────────────┘       └─────────────┘
```

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- MySQL 8.x
- Maven 3.x

### Installation

**1. Clone the repository**
```bash
git clone https://github.com/AchrafGuazzeh/VideoGameLibraryMVC.git
cd VideoGameLibraryMVC
```

**2. Setup MySQL Database**
```sql
CREATE DATABASE videogame_library;
```

**3. Configure Database**

Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/videogame_library
spring.datasource.username=root
spring.datasource. password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**4. Run the Application**
```bash
mvn spring-boot:run
```

**5. Access the Application**
```
http://localhost:8080
```

---

## 📁 Project Structure

```
VideoGameLibraryMVC/
├── src/main/java/
│   ├── controller/     # Controllers for Games, Genres, Studios
│   ├── model/          # Entity classes (Game, Genre, Studio)
│   ├── repository/     # JPA Repositories
│   └── service/        # Business logic
├── src/main/resources/
│   ├── templates/      # Thymeleaf HTML templates
│   └── application. properties
└── pom.xml
```

---

## 🎯 Usage

### Managing Genres
- Navigate to `/genres` to view all genres
- Add new genres, edit existing ones, or delete them

### Managing Studios
- Navigate to `/studios` to view all studios
- Add new studios, edit existing ones, or delete them

### Managing Games
- Navigate to `/games` to view all games
- Add new games with associated genre and studio
- Edit or delete existing games

---

## 🔧 Main Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org. springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
    <dependency>
        <groupId>com. mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
    </dependency>
</dependencies>
```

---

## 📝 License

This project is open source and available under the MIT License. 

---

## 👤 Author

**Achraf Guazzeh**

GitHub: [@AchrafGuazzeh](https://github.com/AchrafGuazzeh)

---

<div align="center">

Made with ☕ and Spring Boot

⭐ Star this repo if you found it helpful! 

</div>
