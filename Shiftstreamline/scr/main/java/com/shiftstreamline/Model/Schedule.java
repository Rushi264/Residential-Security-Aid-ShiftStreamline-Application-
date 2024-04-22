package com.shiftstreamline.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Schedule {
    private List<Shift> shifts; // Stores a list of shifts

    // Constructor
    public Schedule() {
        this.shifts = new ArrayList<>();
    }

    // Adds a shift to the schedule if it does not conflict with existing ones

    public void addShift(Shift shift) {
        shifts.add(shift);
    }
    // Removes a shift from the schedule
    public boolean removeShiftFromSchedule(Shift shift) {
        boolean removed = shifts.remove(shift);
        if (removed) {
            System.out.println("Shift " + shift.getShiftID() + " removed from schedule.");
        } else {
            System.out.println("Shift " + shift.getShiftID() + " is not in the schedule.");
        }
        return removed;
    }

    // Checks if the proposed shift conflicts with any existing shift
    public boolean conflictsWith(Shift newShift) {
        return shifts.stream().anyMatch(existingShift ->
                existingShift.getStartTime().equals(newShift.getStartTime()) &&
                existingShift.getEndTime().equals(newShift.getEndTime()));
    }

    // Check if the shift is in the employee's schedule
    public boolean hasShift(Shift shift) {
        return shifts.contains(shift);
    }

    // Getters and Setters

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }

    // Additional potential methods not required by your current diagram
    // but might be useful for schedule management:
    
    // Returns all shift IDs as a String for easy viewing or logging
    public String getShiftIDsAsString() {
        return shifts.stream()
                     .map(Shift::getShiftID)
                     .collect(Collectors.joining(", "));
    }

    // Clears all shifts from the schedule
    public void clearSchedule() {
        shifts.clear();
        System.out.println("All shifts have been cleared from the schedule.");
    }
}