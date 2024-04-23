package com.shiftstreamline.service;

import com.shiftstreamline.model.Shift;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShiftManagementService {
    private List<Shift> shifts; // Store the list of shifts

    // Constructor
    public ShiftManagementService() {
        this.shifts = new ArrayList<>();
    }

    // Method to add a shift
    public boolean addShift(Shift shift) {
        return shifts.add(shift);
    }

    // Method to remove a shift
    public boolean removeShift(Shift shift) {
        return shifts.remove(shift);
    }

    // Getters and Setters
    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }

    // Additional methods can be added for managing shifts, such as finding shifts by ID or status
}