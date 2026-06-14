# 🛒 Merchant Product Management System

A console-based Java application to manage merchants and their products using **Hibernate ORM** and **MySQL**. Supports full CRUD operations, merchant authentication, and product filtering — all through a menu-driven CLI.

---

## 📌 Features

### Merchant Operations
- Save a new merchant (name, phone, GST number, email, password)
- Update merchant details
- Find merchant by ID
- Verify merchant by **email & password**
- Verify merchant by **phone & password**

### Product Operations
- Add a product linked to a merchant
- Update product details (name, brand, category, cost)
- Find products by **product ID**
- Find products by **category**
- Find products by **merchant ID**

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java (JDK 8+) | Core application logic |
| Hibernate ORM | Object-relational mapping & DB operations |
| MySQL | Relational database |
| Scanner (CLI) | Console-based user interaction |

---

## 📁 Project Structure

```
Merchant-Product-Management-System/
├── src/
│   └── org/
│       ├── MerchantApp/
│       │   ├── dao/
│       │   │   ├── MerchantDao.java
│       │   │   └── ProductDao.java
│       │   └── dto/
│       │       ├── Merchant.java
│       │       └── Product.java
│       └── merchantProductApp/
│           └── controller/
│               └── MerchantProductController.java
├── hibernate.cfg.xml
└── README.md
```

---

## ⚙️ Setup & Installation

### Prerequisites
- Java JDK 8 or higher
- MySQL Server
- Hibernate 5.x
- Any Java IDE (IntelliJ IDEA, Eclipse)

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/alekhyaGontla/Merchant-Product-Management-System.git
   cd Merchant-Product-Management-System
   ```

2. **Set up the MySQL database**
   ```sql
   CREATE DATABASE merchant_db;
   ```

3. **Configure Hibernate**

   Update `hibernate.cfg.xml` with your MySQL credentials:
   ```xml
   <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/merchant_db</property>
   <property name="hibernate.connection.username">your_username</property>
   <property name="hibernate.connection.password">your_password</property>
   <property name="hibernate.hbm2ddl.auto">update</property>
   ```

4. **Add dependencies**

   Make sure your build path includes:
   - `hibernate-core.jar`
   - `mysql-connector-java.jar`

5. **Run the application**

   Run `MerchantProductController.java` as a Java application.

---

## 💡 Usage

On launch, the CLI presents a menu:

```
1.  Save Merchant
2.  Update Merchant
3.  Find Merchant By Id
4.  Verify Merchant by email and password
5.  Verify Merchant by phone and password
6.  Add Product
7.  Update Product
8.  Find Products by id
9.  Find Products by brand and category
10. Find Products by merchant id
Enter your choice:
```

Enter a number and follow the prompts to enter the required details.

---

## 🗄️ Entity Overview

### Merchant
| Field | Type |
|-------|------|
| id | int (auto) |
| name | String |
| phone | long |
| gst_num | String |
| email | String |
| password | String |

### Product
| Field | Type |
|-------|------|
| id | int (auto) |
| name | String |
| brand | String |
| category | String |
| cost | double |
| merchant | Merchant (FK) |

---

## 👩‍💻 Author

**Katari Jahnavi**  
[GitHub](https://github.com/KatariJahnavi)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
