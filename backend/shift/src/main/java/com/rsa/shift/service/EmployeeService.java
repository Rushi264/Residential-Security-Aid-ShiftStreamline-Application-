package com.shiftstreamline.service;

import com.shiftstreamline.model.Employee;
import com.shiftstreamline.model.Schedule;
import com.shiftstreamline.model.Shift;

import java.util.HashMap;
import java.util.Map;

public class EmployeeService {
    private Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    // Register a new employee

    public void registerEmployee(String employeeId, String name, String email, Schedule schedule) {
        if (!employees.containsKey(employeeId)) {
            Employee newEmployee = new Employee(employeeId, name, email, schedule);
            employees.put(employeeId, newEmployee);
            System.out.println("Employee registered: " + name);
        } else {
            System.out.println("Employee already exists.");
        }
    }

    // Assign a shift to an employee
    public boolean assignShiftToEmployee(String employeeId, Shift shift) {
        Employee employee = employees.get(employeeId);
        if (employee != null && shift.isAvailable()) {
            employee.getSchedule().addShift(shift);
            shift.setAvailable(false);
            System.out.println("Shift assigned to employee: " + employee.getName());
            return true;
        }
        System.out.println("Shift assignment failed.");
        return false;
    }

    // Retrieve an employee by their ID
    public Employee getEmployee(String employeeId) {
        return employees.get(employeeId);
    }
}
