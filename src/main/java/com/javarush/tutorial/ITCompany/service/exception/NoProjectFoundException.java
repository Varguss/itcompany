package com.javarush.tutorial.ITCompany.service.exception;

public class NoProjectFoundException extends RuntimeException {
    public NoProjectFoundException(String message) {
        super(message);
    }
}
