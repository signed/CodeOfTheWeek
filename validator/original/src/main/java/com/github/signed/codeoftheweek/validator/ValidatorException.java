package com.github.signed.codeoftheweek.validator;

public class ValidatorException extends Exception{
    private final Message message;

    public ValidatorException(Message message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message.toString();
    }
}