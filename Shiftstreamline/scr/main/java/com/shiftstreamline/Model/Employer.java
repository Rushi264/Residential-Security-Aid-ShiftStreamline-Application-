package com.shiftstreamline.model;

import java.util.ArrayList;
import java.util.List;

import com.shiftstreamline.service.ShiftManagementService;

public class Employer {
    private String employerId;
    private String name;
    private List<Employee> employees = new ArrayList<>();
    private ShiftManagementService shiftManagementService;


    // Constructor
    public Employer(String employerId, String name, ShiftManagementService shiftManagementService) {
        this.employerId = employerId;
        this.name = name;
        this.shiftManagementService = shiftManagementService;
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    // Method to add a shift
    public boolean addShift(Shift shift) {
        return shiftManagementService.addShift(shift);
    }

    // Method to remove a shift
    public boolean removeShift(Shift shift) {
        return shiftManagementService.removeShift(shift);
    }

    // Getters and Setters
    public String getEmployerID() {
        return employerId;
    }

    public void setEmployerID(String employerId) {
        this.employerId = employerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShiftManagementService getShiftManagementService() {
        return shiftManagementService;
    }

    public void setShiftManagementService(ShiftManagementService shiftManagementService) {
        this.shiftManagementService = shiftManagementService;
    }
}