package com.shiftstreamline;

import com.shiftstreamline.model.Employee;
import com.shiftstreamline.model.Employer;
import com.shiftstreamline.model.Schedule;
import com.shiftstreamline.model.Shift;
import com.shiftstreamline.service.EmployeeService;
import com.shiftstreamline.service.EmployerService;
import com.shiftstreamline.service.ShiftService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        EmployeeService employeeService = new EmployeeService();
        EmployerService employerService = new EmployerService();
        ShiftService shiftService = new ShiftService();

        // Register employees
        System.out.println("Registering employees...");
        employeeService.registerEmployee("E001", "Alice Johnson", "alice@example.com", new Schedule());
        employeeService.registerEmployee("E002", "Bob Smith", "bob@example.com", new Schedule());

        // Register employers
        System.out.println("Registering employers...");
        employerService.registerEmployer("EM001", "XYZ Corporation");

        // Create shifts
        System.out.println("Creating shifts...");
        shiftService.createShift(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(8));
        shiftService.createShift(LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(8));

        // Assign shifts to employees
        System.out.println("Assigning shifts...");
        Employee alice = employeeService.getEmployee("E001");
        Shift firstShift = shiftService.getShift("S001");
        if (alice != null && firstShift != null) {
            employeeService.assignShiftToEmployee("E001", firstShift);
        }

        // Outputting the status of shifts
        System.out.println("Available shifts after assignments:");
        shiftService.listAvailableShifts();
    }
}
