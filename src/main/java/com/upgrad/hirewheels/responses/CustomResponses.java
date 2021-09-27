package com.upgrad.hirewheels.responses;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomResponses {
    private LocalDateTime timestamp;
    private String message;
    private int statusCode;


    public CustomResponses(){
        this.timestamp=LocalDateTime.now();
    }

    public CustomResponses(String message, int statusCode) {
        this.timestamp=LocalDateTime.now();
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String errorMessage) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}