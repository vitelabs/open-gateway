package org.vite.gateway.model.api;

public class AddressVerification {
    private boolean isValidAddress;
    private String message;

    public AddressVerification(boolean isValid, String message) {
        this.isValidAddress = isValid;
        this.message = message;
    }

    // Note: It's not a good idea to use 'isValidAddress' in the gateway protocol, 'validAddress' is better.
    public boolean getIsValidAddress() {
        return isValidAddress;
    }

    public void setIsValidAddress(boolean validAddress) {
        isValidAddress = validAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
