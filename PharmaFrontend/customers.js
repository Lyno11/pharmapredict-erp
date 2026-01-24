const API_URL = "http://localhost:8080/api/customers";

// 1. Fetch and Display Customers
async function loadCustomers() {
    try {
        const response = await fetch(API_URL);
        const customers = await response.json();
        
        const tableBody = document.getElementById('tableBody');
        tableBody.innerHTML = '';

        customers.forEach(cust => {
            const row = `
                <tr>
                    <td>${cust.customerId}</td>
                    <td><strong>${cust.name}</strong></td>
                    <td>${cust.phone}</td>
                    <td>${cust.email}</td>
                    <td>${cust.address}</td>
                    <td>${cust.dateOfBirth}</td>
                </tr>
            `;
            tableBody.innerHTML += row;
        });
    } catch (error) {
        console.error("Error:", error);
    }
}

// 2. Add New Customer
async function addCustomer() {
    const newCustomer = {
        customerId: document.getElementById('custId').value,
        name: document.getElementById('custName').value,
        phone: document.getElementById('custPhone').value,
        email: document.getElementById('custEmail').value,
        address: document.getElementById('custAddress').value,
        dateOfBirth: document.getElementById('custDob').value
    };

    if(!newCustomer.customerId || !newCustomer.name) {
        alert("ID and Name are required!");
        return;
    }

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newCustomer)
        });

        if (response.ok) {
            alert("Customer Registered!");
            loadCustomers();
            // Clear fields
            document.getElementById('custId').value = '';
            document.getElementById('custName').value = '';
        } else {
            alert("Error registering customer.");
        }
    } catch (error) {
        console.error("Error:", error);
    }
}

// Load on start
document.addEventListener('DOMContentLoaded', loadCustomers);