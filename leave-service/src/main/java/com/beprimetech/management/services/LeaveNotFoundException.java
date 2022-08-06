package com.beprimetech.management.services;

public class LeaveNotFoundException extends RuntimeException {
    public LeaveNotFoundException(String message) {
        super(message);
    }
}

