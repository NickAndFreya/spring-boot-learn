package com.freya.springboot.exception.exception;

/**
 * @author yuanchengpin
 */
public class SessionNotFoundException extends Exception {

    protected String message;

    public SessionNotFoundException(){
        setMessage("session not found");
    }

    public SessionNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
