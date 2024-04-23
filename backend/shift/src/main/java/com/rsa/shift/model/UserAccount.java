package com.shiftstreamline.model;

import java.util.Arrays;

public class UserAccount {
    private String userId;
    private String password;
    private String[] securityQuestions;
    private boolean loginStatus;

    public UserAccount(String userId, String password, String[] securityQuestions) {
        this.userId = userId;
        this.password = password;
        this.securityQuestions = securityQuestions;
        this.loginStatus = false;
    }

    public boolean login(String password) {
        // In a real application, you would hash the password and compare it with the stored hash.
        if (this.password.equals(password)) {
            this.loginStatus = true;
            System.out.println("User logged in successfully.");
            return true;
        } else {
            System.out.println("Incorrect password.");
            return false;
        }
    }

    public void logout() {
        this.loginStatus = false;
        System.out.println("User logged out successfully.");
    }

    public boolean resetPassword(String oldPassword, String newPassword, String answerToSecurityQuestion) {
        // In a real application, add hashing and proper security checks.
        if (this.password.equals(oldPassword) && Arrays.asList(securityQuestions).contains(answerToSecurityQuestion)) {
            this.password = newPassword;
            System.out.println("Password reset successfully.");
            return true;
        } else {
            System.out.println("Password reset failed due to incorrect old password or security answer.");
            return false;
        }
    }

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        // Note: For security reasons, you typically wouldn't provide a getter for passwords.
        return password;
    }

    public void setPassword(String password) {
        // In a real application, this would involve hashing the password before storing it.
        this.password = password;
    }

    public String[] getSecurityQuestions() {
        return securityQuestions;
    }

    public void setSecurityQuestions(String[] securityQuestions) {
        this.securityQuestions = securityQuestions;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    // No setter for loginStatus; it should only be changed via the login/logout methods.
}