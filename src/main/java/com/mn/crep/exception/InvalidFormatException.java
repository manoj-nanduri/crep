package com.mn.crep.exception;

public class InvalidFormatException extends ApplicationException {

    public InvalidFormatException(String message) {
        super(message, ErrorCode.INVALID_FORMAT);
    }

    public InvalidFormatException(String message, Throwable cause) {
        super(message, cause, ErrorCode.INVALID_FORMAT);
    }
}
