package com.shiftstreamline.service;

import com.shiftstreamline.model.Shift;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShiftService {
    private Map<String, Shift> shifts;

    public ShiftService() {
        this.shifts = new HashMap<>();
    }

    // Create a new shift
    public void createShift(LocalDateTime start, LocalDateTime end) {
        String shiftId = UUID.randomUUID().toString();
        if (!shifts.containsKey(shiftId)) {
            Shift newShift = new Shift(start, end);
            shifts.put(shiftId, newShift);
            System.out.println("Shift created: " + shiftId);
        } else {
            System.out.println("Shift already exists.");
        }
    }
    // Get a shift by ID
    public Shift getShift(String shiftId) {
        return shifts.get(shiftId);
    }

    // List all available shifts
    public void listAvailableShifts() {
        shifts.values().stream()
            .filter(Shift::isAvailable)
            .forEach(shift -> System.out.println("Available Shift: " + shift.getShiftID()));
    }
}
