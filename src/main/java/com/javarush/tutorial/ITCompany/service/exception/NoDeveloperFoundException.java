package com.javarush.tutorial.ITCompany.service.exception;

public class NoDeveloperFoundException extends RuntimeException {
    public NoDeveloperFoundException(String message) {
        super(message);
    }
}
