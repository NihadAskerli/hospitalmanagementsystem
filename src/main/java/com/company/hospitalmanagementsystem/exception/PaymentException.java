package com.company.hospitalmanagementsystem.exception;

public class PaymentException extends Exception{
    private String errorCode;

    public PaymentException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
