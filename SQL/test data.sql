USE pharmapredict;

-- 1. Insert Manufacturers (Columns renamed to snake_case)
INSERT INTO Manufacturer (manufacturer_id, name, phone, email, address)
VALUES ('MF001', 'Pfizer', '555-0199', 'contact@pfizer.com', '123 Pharma Way, NY');

INSERT INTO Manufacturer (manufacturer_id, name, phone, email, address)
VALUES ('MF002', 'Moderna', '555-0200', 'info@moderna.com', '456 Biotech Blvd, MA');

-- 2. Insert Medications (Columns renamed to snake_case)
INSERT INTO Medication (ndc_code, name, expiration_date, type, manufacturer_id, format, price, quantity_available, description)
VALUES (12345678901, 'Amoxicillin', '2026-12-31', 'generic', 'MF001', 'oral', 15.99, 500, 'Common antibiotic used for bacterial infections');

INSERT INTO Medication (ndc_code, name, expiration_date, type, manufacturer_id, format, price, quantity_available, description)
VALUES (98765432100, 'Ibuprofen', '2027-06-15', 'brand', 'MF001', 'oral', 8.50, 1000, 'Pain reliever and anti-inflammatory');

INSERT INTO Medication (ndc_code, name, expiration_date, type, manufacturer_id, format, price, quantity_available, description)
VALUES (45612378900, 'Spikevax', '2025-09-01', 'brand', 'MF002', 'parenteral', 25.00, 200, 'COVID-19 Vaccine booster');