package com.javarush.tutorial.ITCompany.service.exception;

public class NoTaskFoundException extends RuntimeException {
    public NoTaskFoundException(String message) {
        super(message);
    }
}
