package unam.bdd;

public class Address {

    /** State of the address */
    private String state;
    /** Street address */
    private String street;
    /** Address number */
    private int number;
    /** Zone improvement plan number */
    private int zip;

    /**
     * Complete Address constructor.
     * @param state the state of the address,
     * @param street the street address,
     * @param number the address number,
     * @param zip the zone improvement plan number.
     */
    public Address(String state, String street, int number, int zip) {
        this.state = state;
        this.street = street;
        this.number = number;
        this.zip = zip;
    }

    /**
     * @return the state of the address.
     */
    public String getState() {
        return state;
    }

    /**
     * Set the name of state address.
     * @param state the state name.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the name of the street address.
     * @param street the street name.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the address number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Set the the address number.
     * @param number the address number.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the zip number.
     */
    public int getZip() {
        return zip;
    }

    /**
     * Set the zone improvement plan number.
     * @param zip the zip number.
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * @return the string representation of the address.
     */
    @Override public String toString() {
        return this.state +" "+this.street+" "+this.number+" "+this.zip;
    }
       
}
