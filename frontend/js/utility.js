// A mock array of employers, which you'll replace with a fetch call to your backend
const mockEmployers = [
    { name: 'Company A', contact: 'contact@a.com', address: '123 A St', industry: 'Tech', size: 100 },
    { name: 'Company B', contact: 'contact@b.com', address: '456 B Ave', industry: 'Finance', size: 200 },
    // ...other mock employers
];

document.addEventListener('DOMContentLoaded', function() {
    populateEmployersTable();

    document.getElementById('addEmployerBtn').addEventListener('click', function() {
        // Redirect to the Add Employer form page
        window.location.href = 'form.html';
    });
});

function populateEmployersTable() {
    const tableBody = document.getElementById('employerTable').querySelector('tbody');
    mockEmployers.forEach(employer => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${employer.name}</td>
            <td>${employer.contact}</td>
            <td>${employer.address}</td>
            <td>${employer.industry}</td>
            <td>${employer.size}</td>
            <td>
                <button class="action-btn edit-btn">Edit</button>
                <button class="action-btn delete-btn">Delete</button>
            </td>
        `;
        tableBody.appendChild(tr);
        
        // Here you will attach event listeners to the Edit and Delete buttons
        // For now, they just display an alert
        tr.querySelector('.edit-btn').addEventListener('click', function() {
            alert('Edit functionality not implemented');
            // You would normally redirect to form.html with the selected employer's details
        });
        tr.querySelector('.delete-btn').addEventListener('click', function() {
            alert('Delete functionality not implemented');
            // You would normally call your backend to delete the employer record
        });
    });
}

function fetchPayrollData() {
    fetch('/api/payroll')
    .then(response => response.json())
    .then(data => {
        populatePayrollTable(data);
    }).catch(error => {
        console.error('Error fetching payroll data:', error);
    });
}

function populatePayrollTable(payrollData) {
    const tableBody = document.getElementById('payrollTable').querySelector('tbody');
    tableBody.innerHTML = ''; // Clear existing entries

    payrollData.forEach(payroll => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${payroll.employeeId}</td>
            <td>${payroll.employeeName}</td>
            <td>${payroll.hoursWorked}</td>
            <td>${payroll.hourlyRate}</td>
            <td>${payroll.totalPay}</td>
            <td>
                <button class="action-btn edit-btn">Edit</button>
                <button class="action-btn delete-btn">Delete</button>
            </td>
        `;
        tableBody.appendChild(tr);
    });
}

document.addEventListener('DOMContentLoaded', function() {
    // Existing load handlers
    // ...

    // Load payroll data if payroll table exists on the page
    const payrollTable = document.getElementById('payrollTable');
    if (payrollTable) {
        fetchPayrollData();
    }
});

// Functions for Employee Management
function fetchEmployees() {
    fetch('/api/employees')
    .then(response => response.json())
    .then(data => {
        populateEmployeesTable(data);
    }).catch(error => {
        console.error('Error fetching employees:', error);
    });
}

function populateEmployeesTable(employees) {
    const tableBody = document.getElementById('employeeTable').querySelector('tbody');
    tableBody.innerHTML = ''; // Clear existing entries

    employees.forEach(employee => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${employee.employeeId}</td>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>
                <button class="action-btn edit-btn" data-id="${employee.employeeId}">Edit</button>
                <button class="action-btn delete-btn" data-id="${employee.employeeId}">Delete</button>
            </td>
        `;
        tableBody.appendChild(tr);

        // Attach event listeners to Edit and Delete buttons
        tr.querySelector('.edit-btn').addEventListener('click', function() {
            window.location.href = `form.html?employeeId=${employee.employeeId}`;
        });
        tr.querySelector('.delete-btn').addEventListener('click', function() {
            deleteEmployee(employee.employeeId);
        });
    });
}

function deleteEmployee(employeeId) {
    if (confirm('Are you sure you want to delete this employee?')) {
        fetch(`/api/employees/${employeeId}`, { method: 'DELETE' })
        .then(response => {
            if (response.ok) {
                fetchEmployees(); // Refresh the list
            } else {
                alert('Error deleting employee');
            }
        }).catch(error => {
            console.error('Error deleting employee:', error);
        });
    }
}

document.addEventListener('DOMContentLoaded', function() {
    const employeeTable = document.getElementById('employeeTable');
    if (employeeTable) {
        fetchEmployees();
    }

    const addEmployeeBtn = document.getElementById('addEmployeeBtn');
    if (addEmployeeBtn) {
        addEmployeeBtn.addEventListener('click', function() {
            window.location.href = 'form.html';
        });
    }
});

/ Functions for Shift Management
function fetchShifts() {
    fetch('/api/shifts')
    .then(response => response.json())
    .then(data => {
        populateShiftsTable(data);
    }).catch(error => {
        console.error('Error fetching shifts:', error);
    });
}

function populateShiftsTable(shifts) {
    const tableBody = document.getElementById('shiftTable').querySelector('tbody');
    tableBody.innerHTML = ''; // Clear existing entries

    shifts.forEach(shift => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${shift.shiftId}</td>
            <td>${shift.startTime}</td>
            <td>${shift.endTime}</td>
            <td>
                <button class="action-btn edit-btn" data-id="${shift.shiftId}">Edit</button>
                <button class="action-btn delete-btn" data-id="${shift.shiftId}">Delete</button>
            </td>
        `;
        tableBody.appendChild(tr);

        // Attach event listeners to Edit and Delete buttons
        tr.querySelector('.edit-btn').addEventListener('click', function() {
            window.location.href = `form.html?shiftId=${shift.shiftId}`;
        });
        tr.querySelector('.delete-btn').addEventListener('click', function() {
            deleteShift(shift.shiftId);
        });
    });
}

function deleteShift(shiftId) {
    if (confirm('Are you sure you want to delete this shift?')) {
        fetch(`/api/shifts/${shiftId}`, { method: 'DELETE' })
        .then(response => {
            if (response.ok) {
                fetchShifts(); // Refresh the list
            } else {
                alert('Error deleting shift');
            }
        }).catch(error => {
            console.error('Error deleting shift:', error);
        });
    }
}

document.addEventListener('DOMContentLoaded', function() {
    const shiftTable = document.getElementById('shiftTable');
    if (shiftTable) {
        fetchShifts();
    }

    const addShiftBtn = document.getElementById('addShiftBtn');
    if (addShiftBtn) {
        addShiftBtn.addEventListener('click', function() {
            window.location.href = 'form.html';
        });
    }
});
