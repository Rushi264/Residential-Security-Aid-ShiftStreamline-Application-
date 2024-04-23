package com.shiftstreamline.service;

import com.shiftstreamline.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class PayrollService {
    private Map<String, Employee> employeeRecords; // Employee records for payroll
    private Map<String, Integer> paymentDetails; // Payment details for each employee

    // Constructor
    public PayrollService() {
        this.employeeRecords = new HashMap<>();
        this.paymentDetails = new HashMap<>();
    }

    // Adds an employee to the payroll
    public boolean addEmployeeToPayroll(Employee employee) {
        if (!employeeRecords.containsKey(employee.getEmployeeID())) {
            employeeRecords.put(employee.getEmployeeID(), employee);
            paymentDetails.put(employee.getEmployeeID(), 0); // Initialize payment details
            System.out.println("Employee " + employee.getName() + " added to payroll.");
            return true;
        } else {
            System.out.println("Employee is already in payroll.");
            return false;
        }
    }

    // Calculates the pay for an employee based on hours worked and hourly rate
    public int calculatePay(Employee employee, int hoursWorked, int hourlyRate) {
        if (employeeRecords.containsKey(employee.getEmployeeID())) {
            int pay = hoursWorked * hourlyRate;
            paymentDetails.put(employee.getEmployeeID(), pay);
            System.out.println("Pay for " + employee.getName() + " calculated: " + pay);
            return pay;
        } else {
            System.out.println("Employee not found in payroll for pay calculation.");
            return 0;
        }
    }

    // Processes the payment for an employee
    public boolean processPayment(Employee employee) {
        if (employeeRecords.containsKey(employee.getEmployeeID()) &&
                paymentDetails.containsKey(employee.getEmployeeID())) {
            int pay = paymentDetails.get(employee.getEmployeeID());
            // Logic to actually process the payment goes here. For now, let's just print a message.
            System.out.println("Payment of " + pay + " processed for employee " + employee.getName());
            // After payment, reset the payment details for the next pay period.
            paymentDetails.put(employee.getEmployeeID(), 0);
            return true;
        } else {
            System.out.println("Employee not found in payroll for payment processing.");
            return false;
        }
    }

    // Getters and Setters

    public Map<String, Employee> getEmployeeRecords() {
        return employeeRecords;
    }

    public void setEmployeeRecords(Map<String, Employee> employeeRecords) {
        this.employeeRecords = employeeRecords;
    }

    public Map<String, Integer> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(Map<String, Integer> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
