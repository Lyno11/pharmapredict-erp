// The URL of your running Java Backend
const API_URL = "http://localhost:8080/api/medications";

async function fetchMedications() {
    const tableBody = document.getElementById('tableBody');
    tableBody.innerHTML = '<tr><td colspan="6" style="text-align:center">Loading data...</td></tr>';

    try {
        const response = await fetch(API_URL);

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        renderTable(data);

    } catch (error) {
        console.error('Error fetching data:', error);
        tableBody.innerHTML = `<tr><td colspan="6" style="color:red; text-align:center">Error loading data. Is the Java Backend running?</td></tr>`;
    }
}

function renderTable(medications) {
    const tableBody = document.getElementById('tableBody');
    tableBody.innerHTML = ''; // Clear previous data

    medications.forEach(med => {
        // Highlight low stock (logic example)
        const stockStyle = med.quantityAvailable < 100 ? 'class="low-stock"' : '';

        const row = `
            <tr>
                <td>${med.ndcCode}</td>
                <td><strong>${med.name}</strong></td>
                <td>${med.type}</td>
                <td>$${med.price.toFixed(2)}</td>
                <td ${stockStyle}>${med.quantityAvailable}</td>
                <td>${med.expirationDate}</td>
            </tr>
        `;
        tableBody.innerHTML += row;
    });
}

// Load data automatically when page opens
document.addEventListener('DOMContentLoaded', fetchMedications);

async function addMedication() {
    // 1. Get values from the input boxes
    const ndc = document.getElementById('newNdc').value;
    const name = document.getElementById('newName').value;
    const manId = document.getElementById('newManId').value;
    const price = document.getElementById('newPrice').value;
    const stock = document.getElementById('newStock').value;
    
    // Get the date from the picker
    const expDate = document.getElementById('newExpDate').value;

    // 2. Validate input (Added Date check)
    if (!ndc || !name || !manId || !expDate) {
        alert("Please fill in NDC, Name, Manufacturer ID, and Expiration Date.");
        return;
    }

    const newMed = {
        ndcCode: parseInt(ndc),
        name: name,
        manufacturerID: manId, 
        price: parseFloat(price),
        quantityAvailable: parseInt(stock),
        type: "brand", 
        format: "oral", 
        
        //Use the real date variable instead of the hardcoded string
        expirationDate: expDate 
    };

    // 3. Send to Java Backend
    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newMed)
        });

        if (response.ok) {
            alert("✅ Medication Added!");
            fetchMedications(); 
            // Clear inputs
            document.getElementById('newNdc').value = '';
            document.getElementById('newName').value = '';
            document.getElementById('newExpDate').value = ''; // Clear date
        } else {
            const errorText = await response.text(); 
            console.error("Error:", errorText); 
            alert("❌ Save Failed!\n\nReason: " + errorText);
        }
    } catch (error) {
        console.error("Network Error:", error);
        alert("Network Error. Is Java running?");
    }
}