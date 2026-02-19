🏥 PharmaPredict ERP SystemVersion: 2.1 (Full Stack Transactional)Status: Active / MaintenanceDeveloper: [Your Name] - Pace University Graduate Student

📖 Project Overview

PharmaPredict is a comprehensive Enterprise Resource Planning (ERP) web application designed for pharmaceutical inventory management. It integrates Inventory Control, Supplier Management, and Customer Relationship Management (CRM) into a unified dashboard.The system utilizes a 3-Tier Architecture to ensure separation of concerns, data integrity, and scalability. It features a transactional engine that automatically updates inventory levels in real-time when sales orders are processed.

🛠 Tech Stack
Layer              Technology                                                    Description
Frontend     HTML5, CSS3, Vanilla JavaScript                 Lightweight, responsive Single Page Application (SPA) simulation.
Backend      Java 17, Spring Boot 3                          RESTful API handling business logic and request routing.
Database     MySQL 8.0                                       Relational database with strict Foreign Key constraints.
ORM          Hibernate / Spring Data JPA                     Object-Relational Mapping for seamless database interaction.
Tools        IntelliJ IDEA, MySQL Workbench                  Development environment and database management.

🏗 System Architecture

The application follows a standard Model-View-Controller (MVC) pattern adapted for a REST API context.

1. The Persistence Layer (MySQL)
The database serves as the single source of truth. It uses a normalized schema with Foreign Key constraints to prevent orphaned records (e.g., you cannot delete a Manufacturer if they have linked Medications).
Key Tables:
Medication: The core entity containing NDC codes, stock levels (quantity_available), and pricing.
Manufacturer: Parent entity for medications.
Customer: Stores patient/buyer profiles.Supplier: Manages external vendors.
Purchase_Order: Tracks inbound stock history.
Disposals: Logs removed/expired inventory.

2. The Application Layer (Spring Boot)
The backend exposes data via HTTP endpoints. It is structured into three standard packages:
    >model: Java POJOs mapped to database tables (e.g., Medication.java).
    >repository: Interfaces extending JpaRepository for CRUD operations.
    >controller: REST controllers that handle HTTP Requests (GET, POST) and define business logic (e.g., Stock subtraction).

3. The Presentation Layer (Frontend)
The user interface uses a Dashboard Architecture to route users between specific modules.index.html: Main Hub with navigation cards.inventory_menu.html: Sub-menu for Disposals, Medications, and Manufacturers.order.html: The Transaction Terminal.

🔌API Documentation (Endpoints)The system exposes the following REST endpoints via http://localhost:8080/api:Inventory Module

MethodEndpointDescription
GET   /api/medications    --> Retrieve all medication stock.
POST  /api/medications    --> Create a new medication record.
GET   /api/manufacturers  --> List all registered manufacturers.
POST  /api/manufacturers  --> Register a new manufacturer.
GET   /api/disposals      --> View disposal logs.
POST  /api/disposals      --> Record a stock disposal event.

Customer & Supplier Modules
MethodEndpointDescription:
GET   /api/customers --> Retrieve customer directory.
POST  /api/customers --> Register a new customer.
GET   /api/suppliers --> List active suppliers.
POST  /api/suppliers --> Add a new supplier.
GET   /api/purchase-orders -->View inbound order history.

Transaction Module (Business Logic)
Method_Endpoint_Description:
POST /api/orders -->Place Order. Validates stock --> Subtracts Quantity--> Returns Success/Fail.

🚀 Installation & Setup

Prerequisites:
    >Java JDK 17 or higher
    >MySQL Server (Port 3306)
    >IntelliJ IDEA (or Eclipse)

Step 1: Database InitializationOpen MySQL Workbench.
    >Run the Full_System_Reset_v2.sql script (included in project docs) to create the schema and seed initial data.

Step 2: Backend Deployment
    >Open the project in IntelliJ IDEA.
    >Update application.properties with your MySQL credentials:
    Propertiesspring.datasource.url=jdbc:mysql://localhost:3306/pharmapredict
    spring.datasource.username=root
    spring.datasource.password=YOUR_PASSWORD
    
    >Run PharmaPredictApplication.java.
    Verify console output: Started PharmaPredictApplication in X seconds.

Step 3: Frontend Launch Navigate to the PharmaFrontend folder.Open index.html in any modern web browser.