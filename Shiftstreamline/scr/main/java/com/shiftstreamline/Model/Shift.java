package com.shiftstreamline.model;

import java.util.UUID;
import java.time.LocalDateTime;

public class Shift {
    private String shiftID;
    private LocalDateTime start;
    private LocalDateTime end;
    private boolean isAvailable;
    private Employee assignedEmployee;  // Assuming Employee class is already defined

    public Shift(LocalDateTime start, LocalDateTime end) {
        this.shiftID = UUID.randomUUID().toString(); // Generate a unique identifier
        this.start = start;
        this.end = end;
        this.isAvailable = true;
    }

    // Methods to assign a shift to an employee
    public void assignToEmployee(Employee employee) {
        if (isAvailable()) {
            this.assignedEmployee = employee;
            this.isAvailable = false;
            System.out.println("Shift " + shiftID + " assigned to employee " + employee.getName());
        } else {
            System.out.println("Shift is not available for assignment.");
        }
    }

    // Check if the shift is available
    public boolean isAvailable() {
        return isAvailable;
    }

    // Getters and Setters
    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    // Getter for start time
    public LocalDateTime getStartTime() {
        return start;
    }

    // Getter for end time
    public LocalDateTime getEndTime() {
        return end;
    }

    // Method to get the availability status of the shift
    public boolean getStatus() {
        return isAvailable;
    }


    // Method to set the availability of the shift
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}