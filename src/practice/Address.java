package entities;

public class Address {

    private String state;

    private String street;

    private int number;

    private int zip;

    public Address(String state, String street, int number, int zip) {
        this.state = state;
        this.street = street;
        this.number = number;
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
