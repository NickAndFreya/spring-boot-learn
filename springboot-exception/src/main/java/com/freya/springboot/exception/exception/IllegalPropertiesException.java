package com.freya.springboot.exception.exception;

/**
 * @author yuanchengpin
 */
public class IllegalPropertiesException extends Exception {

    protected String message;

    public IllegalPropertiesException(){
        setMessage("illegal properties exception");
    }

    public IllegalPropertiesException(String message) {
        this.message = message;
        setMessage(String.format("Prop: %s is illegal!", message));
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
