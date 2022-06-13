package com.kopylov.telegrambotlogger.exception;

public class UnknownMessageContentException extends RuntimeException {
    public UnknownMessageContentException(String message) {
        super(message);
    }
}
