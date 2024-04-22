package com.shiftstreamline.model;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ShiftManagementSystem {
    private List<Shift> shifts; // List of shifts managed by the system

    // Constructor
    public ShiftManagementSystem(List<Shift> shifts) {
        this.shifts = shifts;
    }

    // Method to add a shift
    public void addShift(Shift shift) {
        shifts.add(shift);
        System.out.println("Shift " + shift.getShiftID() + " added to the system.");
    }

    // Method to remove a shift
    public void removeShift(Shift shift) {
        boolean removed = shifts.remove(shift);
        if (removed) {
            System.out.println("Shift " + shift.getShiftID() + " removed from the system.");
        } else {
            System.out.println("Shift " + shift.getShiftID() + " is not in the system.");
        }
    }

    // Method to display all shifts
    public void displayAllShifts() {
        System.out.println("All shifts in the system:");
        shifts.forEach(shift -> System.out.println("Shift ID: " + shift.getShiftID() + ", Status: " + shift.getStatus()));
    }

    // Method to find a shift by ID
    public Shift findShiftByID(String shiftID) {
        return shifts.stream()
                     .filter(shift -> shift.getShiftID().equals(shiftID))
                     .findFirst()
                     .orElse(null);
    }

    // Getters and Setters
    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }
}