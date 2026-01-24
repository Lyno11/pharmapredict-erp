const API_BASE = "http://localhost:8080/api";

// 1. Load Dropdowns on Start
async function init() {
    // Fetch Customers
    const custRes = await fetch(`${API_BASE}/customers`);
    const customers = await custRes.json();
    const custSelect = document.getElementById('customerSelect');
    custSelect.innerHTML = '<option value="">-- Select Customer --</option>';
    customers.forEach(c => {
        custSelect.innerHTML += `<option value="${c.customerId}">${c.name} (${c.customerId})</option>`;
    });

    // Fetch Medications
    const medRes = await fetch(`${API_BASE}/medications`);
    const medications = await medRes.json();
    const medSelect = document.getElementById('medicationSelect');
    medSelect.innerHTML = '<option value="">-- Select Medication --</option>';
    medications.forEach(m => {
        medSelect.innerHTML += `<option value="${m.ndcCode}">${m.name} - $${m.price} (Stock: ${m.quantityAvailable})</option>`;
    });
}

// 2. Submit the Order
async function submitOrder() {
    const custId = document.getElementById('customerSelect').value;
    const medId = document.getElementById('medicationSelect').value;
    const qty = document.getElementById('quantity').value;

    if (!custId || !medId || !qty) {
        alert("Please complete all fields.");
        return;
    }

    const orderRequest = {
        customerId: custId,
        medicationId: parseInt(medId),
        quantity: parseInt(qty)
    };

    try {
        const response = await fetch(`${API_BASE}/orders`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(orderRequest)
        });

        const msg = await response.text();

        if (response.ok) {
            alert("✅ " + msg);
            window.location.href = "index.html"; // Redirect back to Inventory to see updated stock
        } else {
            alert("❌ Order Failed: " + msg);
        }
    } catch (error) {
        console.error(error);
        alert("Network Error");
    }
}

document.addEventListener('DOMContentLoaded', init);