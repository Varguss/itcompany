package com.javarush.tutorial.ITCompany.service.exception;

public class NoTeamFoundException extends RuntimeException {
    public NoTeamFoundException(String message) {
        super(message);
    }
}
