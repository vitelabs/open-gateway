package org.vite.gateway.blockchain.transport.rest;

public class RestExcption extends RuntimeException {
    private int code;
    private String message;


    public RestExcption(Throwable cause) {
        super(cause);
    }

    public RestExcption(String message, int code) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
