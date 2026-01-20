# 💰 Personal Finance Tracker

A full-stack **Personal Finance Tracker** web application built using **Spring Boot**, **Spring Data JPA**, **Spring Security**, and **MySQL**. The application allows a single authenticated user to manage income, expenses, notes, and visualize financial data through an interactive dashboard.



## ✨ Highlights

✔ Secure login authentication  
✔ Income & expense management (CRUD)  
✔ Dashboard with real-time analytics  
✔ Category-wise and month-wise charts  
✔ Notes and calculator modules  
✔ Clean UI with backend integration  



## 🚀 Features

- Secure login (only authorized user can access data)
- Add, view, update, and delete income & expense records
- Dashboard analytics:
  - Total Income
  - Total Expenses
  - Savings
  - Expense by Category (Pie Chart)
  - Monthly Expenses (Bar Chart)
- Month-based filtering of finance data
- Notes module for reminders
- Built-in calculator for quick calculations
- Persistent storage using JPA & Hibernate



## 🧰 Tech Stack

**Backend**
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- Spring Security

**Frontend**
- HTML
- CSS
- JavaScript
- Chart.js

**Database & Tools**
- MySQL
- Maven
- Git & GitHub



## 📁 Project Structure
```
├── src
│ └── main
│ ├── java/com/example/personalFinanceTracker
│ │ ├── dashboard
│ │ ├── finance
│ │ ├── notes
│ │ └── security
│ └── resources
│ ├── static
│ │ ├── dashboard.html
│ │ ├── dashboard.css
│ │ ├── dashboard.js
│ │ ├── finance.html
│ │ └── login.html
│ └── application.properties
├── pom.xml
└── README.md
```

## 🔐 Authentication

- Implemented using **Spring Security**
- Login required to access finance & dashboard pages
- All APIs protected after authentication
- Designed for single-user access to secure personal financial data.
  



## ⚙️ Configuration

Database configuration is stored in `application.properties`.  

Example:

- spring.application.name=personalFinanceTracker
- spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
- spring.datasource.username=your_username
- spring.datasource.password=your_password <br>
- spring.jpa.hibernate.ddl-auto=update <br>
- spring.jpa.show-sql=true

## ▶️ How to Run the Project

1. Clone the repository  

2. Open in VS Code / IntelliJ IDEA  

3. Ensure Java 17, Maven, and MySQL are installed  

4. Create a MySQL database (example: `finance_db`)  

5. Run the application
  
6. Open in browser
- http://localhost:8080/login
  


## 🧠 Key Learnings

- Spring Boot REST API development
- JPA & Hibernate database interaction
- Secure authentication using Spring Security
- Backend data aggregation
- Frontend & backend integration
- Dashboard visualization with Chart.js



## 📌 Future Enhancements

- Multi-user support
- Integrating with bank account
- Export reports (PDF / Excel)
- Budget limit alerts



## 👩‍💻 Author

**Jahnavi Arthamuri**  
Software Engineering Student  
GitHub: https://github.com/Jahnavi987-A


