document.addEventListener("DOMContentLoaded", function() {
    const employerForm = document.getElementById('employerForm');

    employerForm.addEventListener('submit', function(event) {
        // Prevent the default form submission
        event.preventDefault();

        // Validate the Employer Name
        const employerName = document.getElementById('employerName').value;
        if (!employerName) {
            alert('Employer name is required.');
            return false;
        }

        // Additional validations can be added here
        
        // If all validations pass, submit the form
        // This example uses simple form submission, you might use Ajax requests here
        this.submit();
    });
});

document.addEventListener("DOMContentLoaded", function() {
    const payrollForm = document.getElementById('payrollForm');
    if (payrollForm) {
        payrollForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission

            const employeeId = document.getElementById('employeeId').value;
            const hoursWorked = document.getElementById('hoursWorked').value;
            const hourlyRate = document.getElementById('hourlyRate').value;

            if (!employeeId || !hoursWorked || !hourlyRate) {
                alert('All fields are required to calculate payroll.');
                return false;
            }

            // Further validation rules can be implemented here

            this.submit(); // Submit the form if all validations pass
        });
    }
});

document.addEventListener("DOMContentLoaded", function() {
    const employeeForm = document.getElementById('employeeForm');
    if (employeeForm) {
        employeeForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission

            const employeeId = document.getElementById('employeeId').value;
            const name = document.getElementById('name').value;
            const email = document.getElementById('email').value;

            if (!employeeId || !name || !email) {
                alert('All fields are required.');
                return false;
            }

            // Further validation rules can be implemented here

            this.submit(); // Submit the form if all validations pass
        });
    }
});

// Assuming existing code for other forms...

document.addEventListener("DOMContentLoaded", function() {
    const shiftForm = document.getElementById('shiftForm');
    if (shiftForm) {
        shiftForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission

            const shiftId = document.getElementById('shiftId').value;
            const startTime = document.getElementById('startTime').value;
            const endTime = document.getElementById('endTime').value;

            if (!shiftId || !startTime || !endTime) {
                alert('All fields are required.');
                return false;
            }

            // Additional validations like checking date and time formats
            // Ensure end time is after start time
            if (new Date(startTime) >= new Date(endTime)) {
                alert('End time must be after start time.');
                return false;
            }

            this.submit(); // Submit the form if all validations pass
        });
    }
});


document.getElementById('shiftForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const startTime = document.getElementById('startTime').value;
    const endTime = document.getElementById('endTime').value;

    if (new Date(startTime) >= new Date(endTime)) {
        const errorMessage = document.createElement('p');
        errorMessage.textContent = 'End time must be after start time.';
        errorMessage.style.color = 'red';
        this.insertBefore(errorMessage, this.firstChild);
        return false;
    }

    this.submit(); // Now submit the form
});
