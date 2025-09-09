# Hibernate Learning 🚀

This repository documents my step-by-step learning of **Hibernate ORM** with **MySQL** using Java.  
The goal is to understand how Hibernate works, from basic configuration to entity relationships and CRUD operations.

---

## 📚 What I Learned So Far


### ✅ Day 1: Hibernate Basics
- Added Hibernate & MySQL dependencies in `pom.xml`
- Configured `hibernate.cfg.xml`
- Tested Hibernate connection to MySQL database
- Learned that Hibernate auto-creates tables from Java classes (`@Entity`)

### ✅ Day 2: Mapping & Relationships
- Learned mapping annotations:  
  - `@Entity`, `@Table`, `@Id`, `@Column`
- Practiced basic CRUD: Insert, Fetch, Update, Delete
- Understood real-world need for **Relationships**:  
  - One-to-One  
  - One-to-Many  

---

## ⚠ Warnings Observed
- Built-in connection pool (not for production)
- MySQLDialect warning (auto-selected)
- No JTA platform available
- Auto-commit during schema update

---

## 🛠 Tech Stack
- Java 17+ (JDK 24 in my case)  
- Hibernate ORM 6.x  
- MySQL 8.x  
- Maven  
- IntelliJ IDEA  

---

## 🎯 Next Steps
- Explore One-to-One and One-to-Many relationships in Hibernate
- Implement real-world mapping examples (User–Profile, Student–Courses)

---

## 📌 Author
Utkarsh – *Learning Hibernate step by step*
