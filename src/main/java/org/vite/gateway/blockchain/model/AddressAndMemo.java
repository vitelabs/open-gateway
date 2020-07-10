package org.vite.gateway.blockchain.model;

public class AddressAndMemo {
    private String address;
    private String memo;

    public AddressAndMemo(String address, String memo) {
        this.address = address;
        this.memo = memo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "AddressAndMemo{" +
                "address='" + address + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
