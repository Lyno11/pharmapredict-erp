🏥 PharmaPredict ERP
PharmaPredict ERP is a full-stack Enterprise Resource Planning system designed specifically for pharmaceutical inventory, supply chain management, and point-of-sale (POS) operations.
Built with a Spring Boot backend and a Vanilla HTML/CSS/JS frontend, this application handles complex transactional logic, master-detail relationships, and real-time business analytics without relying on heavy frontend frameworks.

✨ Core Features📦 
Inventory Management: Track medication stock, handle disposals (with automated inventory deduction), and monitor expiration dates dynamically.
🏗️ Supply Chain (Warehouse Ops): Create purchase orders for suppliers and log inbound shipments. Receiving a shipment automatically updates database stock levels.
🛒 Point of Sale (POS): A dedicated POS terminal allowing staff to process multi-item shopping carts, validating stock in real-time and recording master-detail sales receipts.
📊 Business Intelligence: Real-time analytics dashboard featuring Chart.js visual graphs and 8 specialized database views (e.g., Customer Lifetime Value, Warehouse Valuation, Low Stock Alerts).
📥 CSV Export: Client-side, one-click data export for all business reports.
💻 Modern UI/UX: A responsive, SaaS-style dashboard with live KPI tracking.

🛠️ Technology Stack
Backend:
--Java 17
--Spring Boot (Spring Web, Spring Data JPA)
--Hibernate (ORM)
--MySQL (Relational Database & Views)

Frontend:
--HTML5 / CSS3 (CSS Grid & Flexbox)
--Vanilla JavaScript (Fetch API, DOM Manipulation)
--Chart.js (Data Visualization)

🚀 The Development Journey
This project evolved from a basic read-only data viewer into a fully functional transactional ERP. Here is the roadmap of how it was built:

Phase 1: Foundation & CRUD OperationsGoal: Establish the baseline database connections and basic UI.
Milestones: Built the core REST APIs for Medications, Customers, Suppliers, and Manufacturers. Upgraded static HTML tables to include dynamic "Add New" forms, allowing direct database insertion from the browser. Handled data formatting (like dynamic HTML date pickers for expiration dates).

Phase 2: Business Logic & Supply ChainGoal: Make the system react intelligently to data changes.
Milestones: Implemented backend logic to automatically subtract inventory when a medication is logged in the Disposal module.Designed the Warehouse Operations module.
Translated legacy Oracle DB scripts to MySQL.
Built a system where logging a received Warehouse_Log automatically links to a Warehouse_Order and mathematically increases available medication stock.

Phase 3: Transactional Point of Sale (POS)
Goal: Process complex, multi-item customer orders safely.
Milestones: Rebuilt the database schema to support a Master-Detail relationship (Customer_Order and Customer_Order_Detail).
Wrote a transactional Spring Boot checkout controller using @Transactional to ensure that if one item in a shopping cart fails (e.g., insufficient stock), the entire transaction rolls back safely.
Resolved complex Java BigDecimal math and Foreign Key timing constraints.

Phase 4: Analytics & Database ViewsGoal: Turn raw data into actionable business intelligence.
Milestones: Engineered 8 complex MySQL VIEWs (e.g., Top Selling Products, Customer Lifetime Value, Expiry Watchlist).Mapped these SQL Views to Java using @Immutable entities to ensure read-only safety.
Built a dedicated reports.html dashboard utilizing Chart.js to visualize warehouse valuation and sales volume. Added custom JS scripts to export HTML tables to .csv files instantly.

Phase 5: UI Modernization & Architecture
Goal: Deliver a professional, SaaS-tier user experience.
Milestones: Overhauled the main dashboard using CSS Grid. Replaced basic navigation with a persistent dark-mode sidebar and dynamic KPI cards (Green/Yellow/Blue/Red) that calculate metrics directly from the analytics API. Navigated and resolved Git nested-submodule (.git) issues to successfully merge the frontend and backend into a single monorepo.

📂 Database Architecture
The system relies on a tightly constrained relational schema:
Core Entities: Medication, Customer, Supplier, Manufacturer
Supply Chain: Warehouse_Order (Parent)--> Warehouse_Log (Child)
Sales: Customer_Order (Parent)--> Customer_Order_Detail (Child)

🔮 Future Developments
While the core ERP is fully functional, the roadmap for future enhancements includes:
🔐 Authentication & Authorization: Implement Spring Security with JWT tokens to manage Admin vs. Staff roles. The UI currently has a placeholder profile that will be linked to real user sessions.
🤖 Predictive Analytics (The "Predict" in PharmaPredict): Integrate a basic machine learning model (or heuristic algorithms) to predict when a medication will run out of stock based on historical sales velocity.
📧 Automated Notifications: Hook into Spring Mail to automatically email suppliers when a Low Stock Alert triggers.
🧾 PDF Invoice Generation: Allow the POS system to generate and print downloadable PDF receipts for customers.

⚙️ How to Run Locally
1. Clone the repository:Bash-git--> clone https://github.com/YOUR_USERNAME/PharmaPredict-ERP.git
2. Database Setup:Create a MySQL database named pharmapredict.Update the application.properties file with your local MySQL username and password.
Note: The application uses Hibernate update, but initial schema creation scripts are recommended.
3. Start the Backend:Open the project in IntelliJ IDEA (or your preferred IDE) and run PharmaPredictApplication.java.
The server will start on localhost:8080.
4. Launch the Frontend:Navigate to the PharmaFrontend folder.
Open index.html directly in your browser or run it via a Live Server extension.

--Developed as a comprehensive showcase of full-stack software engineering, database design, and business logic implementation.--
