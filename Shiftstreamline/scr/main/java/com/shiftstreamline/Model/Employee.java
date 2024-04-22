package com.shiftstreamline.model;

public class Employee {
    private String employeeID;
    private String name;
    private String email;
    private Schedule schedule; // Consider changing to Schedule type

    // Constructor
    public Employee(String employeeID, String name, String email, Schedule schedule) {
        this.employeeID = employeeID;
        this.name = name;
        this.email = email;
        this.schedule = schedule;
    }

    // Register method
    public void register() {
        // Registration logic
    }

    // Method for an employee to take a shift
    public boolean takeShift(Shift shift) {
        if (shift.isAvailable() && !schedule.hasShift(shift)) {
            schedule.addShift(shift);
            shift.setAvailable(false);
            return true;
        } else {
            return false;
        }
    }

    // Method for an employee to drop a shift
    public boolean dropShift(Shift shift) {
        if (schedule.removeShiftFromSchedule(shift)) {
            shift.setAvailable(true);
            return true;
        } else {
            return false;
        }
    }

    // Getters and setters
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}