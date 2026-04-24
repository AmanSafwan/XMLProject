# XML Document Processing Project – GlobalTech Solutions

## 📌 Project Overview
This project is developed as part of **CSD34403 Advanced Database Group Assignment**.  
It demonstrates XML document processing integrated with a MySQL database, including data export, import, and validation using XML Schema (XSD).

The system is designed to support **data interoperability, external data sharing, and data integrity enforcement** for GlobalTech Solutions.

---

## 📁 Project Features

### ✔ XML Schema Design (XSD)
- Defines structure for Employee data
- Enforces data integrity rules such as:
  - Data type validation
  - Email format restriction
  - Controlled status values (Active, Inactive, Resigned)

---

### ✔ XML Export (Database → XML)
- Uses Java JDBC to connect to MySQL database
- Retrieves employee data
- Writes data into structured XML format (`employees.xml`)

---

### ✔ XML Import (XML → Database)
- Uses DOM Parser to read XML file
- Extracts employee records
- Inserts data into MySQL database using PreparedStatement

---

### ✔ XML Validation (Data Integrity)
- XML file is validated against XSD schema
- Ensures correct structure and format before processing

---

## 🛠 Technologies Used
- Java (NetBeans / Maven)
- MySQL Database
- JDBC (Java Database Connectivity)
- XML (DOM Parser)
- XML Schema Definition (XSD)

---