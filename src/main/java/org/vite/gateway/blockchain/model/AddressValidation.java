package org.vite.gateway.blockchain.model;

public class AddressValidation {
    private boolean valid;
    private String message;

    public static AddressValidation createValid() {
        AddressValidation instance = new AddressValidation();
        instance.setValid(true);
        return instance;
    }

    public static AddressValidation createInvalid(String message) {
        AddressValidation instance = new AddressValidation();
        instance.setValid(false);
        instance.setMessage(message);
        return instance;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
