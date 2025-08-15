# 🛍️ SpringStore API

A complete Java Spring Boot API for managing an e-commerce system.  
It includes core features like users, orders, products, payments, and categories, with full CRUD operations and entity relationships.

---

## 🧱 Core Entities

The following domain entities form the backbone of the application:

| Entity      | Description                          |
|-------------|--------------------------------------|
| `User`      | Represents a customer in the system  |
| `Order`     | Contains order details per user      |
| `OrderItem` | Items (products) inside an order     |
| `Product`   | Items available for purchase         |
| `Category`  | Categories that group products       |
| `Payment`   | Payment details for orders           |

---

## 🔁 Relationships

- A `User` can have multiple `Orders`
- An `Order` contains multiple `OrderItems`
- An `OrderItem` links a `Product` to an `Order`
- A `Product` can belong to multiple `Categories`
- Each `Order` can have **one** `Payment`

---

## ⚙️ Tech Stack

- Java 11+
- Spring Boot
- Spring Data JPA (Hibernate)
- H2 / PostgreSQL (configurable)
- REST API
- Maven

---

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 11+
- Maven
- (Optional) Postman

### ▶️ Run the Project

```bash
# Clone the repo
git clone https://github.com/yourusername/springstore.git
cd springstore

# Run with Maven
./mvnw spring-boot:run


