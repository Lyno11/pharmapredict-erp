-- =============================================
-- FULL MYSQL MIGRATION SCRIPT
-- =============================================
DROP DATABASE IF EXISTS pharmapredict;
CREATE DATABASE pharmapredict;
USE pharmapredict;

-- 1. MANUFACTURER
CREATE TABLE Manufacturer (
    manufacturerID VARCHAR(6),
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    CONSTRAINT manufacturer_pk PRIMARY KEY(manufacturerID),
    CONSTRAINT manufacturer_email_ck CHECK (email LIKE '%@%' AND email LIKE '%.%')
);

-- 2. MEDICATION
CREATE TABLE Medication (
    ndcCode BIGINT,
    name VARCHAR(255) NOT NULL,
    expiration_date DATE NOT NULL, 
    type VARCHAR(10),
    manufacturerID VARCHAR(6) NOT NULL,
    format VARCHAR(20),
    price DECIMAL(10,2),
    quantity_available INT NOT NULL,
    description VARCHAR(255),
    CONSTRAINT medication_pk PRIMARY KEY(ndcCode),
    CONSTRAINT medication_fk_man FOREIGN KEY (manufacturerID) REFERENCES Manufacturer(manufacturerID),
    CONSTRAINT medication_type_ck CHECK (type IN ('brand', 'compounded', 'generic')),
    CONSTRAINT medication_format_ck CHECK (format IN ('oral', 'parenteral', 'topical', 'inhalation', 'other'))
);

-- 3. SUPPLIER
CREATE TABLE Supplier (
    supplierID VARCHAR(6),
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    CONSTRAINT supplier_pk PRIMARY KEY(supplierID),
    CONSTRAINT supplier_email_ck CHECK (email LIKE '%@%' AND email LIKE '%.%')
);

-- 4. INVENTORY
CREATE TABLE Inventory (
    inventoryID VARCHAR(10),
    medicationID BIGINT NOT NULL,
    min_quantity INT NOT NULL,
    current_stock INT NOT NULL,
    reorder_level INT NOT NULL,
    location VARCHAR(10),
    CONSTRAINT inventory_pk PRIMARY KEY(inventoryID),
    CONSTRAINT inventory_med_fk FOREIGN KEY (medicationID) REFERENCES Medication(ndcCode),
    CONSTRAINT inventory_loc_ck CHECK (location IN ('stockroom', 'warehouse'))
);

-- 5. WAREHOUSE_ORDER
CREATE TABLE Warehouse_Order (
    warehouse_order_ID VARCHAR(10),
    medicationID BIGINT NOT NULL,
    supplierID VARCHAR(6) NOT NULL,
    stock_on_order INT NOT NULL,
    delivery_date DATE, -- Defaults handled better in App Logic for MySQL
    CONSTRAINT warehouse_order_pk PRIMARY KEY(warehouse_order_ID),
    CONSTRAINT wo_med_fk FOREIGN KEY (medicationID) REFERENCES Medication(ndcCode),
    CONSTRAINT wo_sup_fk FOREIGN KEY (supplierID) REFERENCES Supplier(supplierID)
);

-- 6. CUSTOMER
CREATE TABLE Customer ( 
    customer_id VARCHAR(15) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL CHECK(email LIKE '%@%' AND email LIKE '%.%'),
    address VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL
);

-- 7. CUSTOMER_ORDER
CREATE TABLE Customer_Order (
    order_number VARCHAR(20) PRIMARY KEY,
    customer_id VARCHAR(15) NOT NULL,
    date_placed DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(10) NOT NULL CHECK(status IN ('received', 'processing','ready')),
    total_cost DECIMAL(10,2) NOT NULL,
    CONSTRAINT cust_ord_fk FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

-- 8. CUSTOMER_ORDER_DETAIL
CREATE TABLE Customer_Order_Detail (
    order_number VARCHAR(20) NOT NULL,
    medication_ID BIGINT NOT NULL,
    quantity_ordered INT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    CONSTRAINT cod_ord_fk FOREIGN KEY (order_number) REFERENCES Customer_Order(order_number),
    CONSTRAINT cod_med_fk FOREIGN KEY (medication_ID) REFERENCES Medication(ndcCode)
);