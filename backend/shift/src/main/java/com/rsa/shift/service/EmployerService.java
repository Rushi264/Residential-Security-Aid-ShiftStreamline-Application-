package com.shiftstreamline.service;

import com.shiftstreamline.model.Employer;
import com.shiftstreamline.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployerService {
    private Map<String, Employer> employers;

    public EmployerService() {
        this.employers = new HashMap<>();
    }

    // Register a new employer
    public void registerEmployer(String employerId, String name) {
        ShiftManagementService sms = new ShiftManagementService(); // Assuming default constructor
        Employer newEmployer = new Employer(employerId, name, sms);
        employers.put(employerId, newEmployer);
        System.out.println("Employer registered: " + name);
    }

    // Add an employee to an employer
    public boolean addEmployeeToEmployer(String employerId, Employee employee) {
        Employer employer = employers.get(employerId);
        if (employer != null) {
            employer.addEmployee(employee);
            System.out.println("Employee added to employer: " + employer.getName());
            return true;
        }
        System.out.println("Failed to add employee to employer.");
        return false;
    }

    // Retrieve an employer by their ID
    public Employer getEmployer(String employerId) {
        return employers.get(employerId);
    }
}