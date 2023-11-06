package com.mn.crep.exception;

public class ApplicationException extends RuntimeException {

    private final ErrorCode errorCode;

    public ApplicationException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApplicationException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public enum ErrorCode {
        INVALID_FORMAT,
        INVALID_REQUEST
    }
}
