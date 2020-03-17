package com.freya.springboot.exception.exception;

/**
 * @author yuanchengpin
 */
public class NullOrEmptyException extends Exception {

    protected String message;

    public NullOrEmptyException(){
        setMessage("null or empty exception");
    }

    public NullOrEmptyException(String message) {
        this.message = message;
        setMessage(String.format("Prop: %s is null or empty!", message));
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
