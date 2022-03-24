package unam.bdd;

/**
 * Class that allows us to define a PetVet salon.
 * @version 23/03/2022
 */
public class PetVetSalon {

    /** The salon phone number */
    private String phone;
    /** The salon name */
    private String name;
    /** The salon address */
    private Address address;
    /** The salon office hours */
    private String officeHours;

    /**
     * PetVet salon constructor.
     * @param name the salon name.
     * @param address the salon address.
     * @param officeHours the salon hours.
     * @param phone the salon phone number.
     */
    public PetVetSalon (String name, Address address, String officeHours, String phone) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.officeHours = officeHours;
    }

    /**     
     * @return the salon phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone number of the PetVet salon.
     * @param phone the salon phone number.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**     
     * @return the salon name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the PetVet salon.
     * @param name the salon name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**     
     * @return the salon address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the complete address of the PetVet salon.
     * @param adress the salon address.
     */
    public void setAddress(Address adress) {
        this.address = adress;
    }

    /**     
     * @return the salon office hours.
     */
    public String getOfficeHours() {
        return officeHours;
    }

    /**
     * Set the office hours of the PetVet salon.
     * @param officeHours the salon hours.
     */
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    /**     
     * @return the string representation of the PetVet salon.
     */
    @Override
    public String toString() {
        return this.name + "," + this.address + ","+ this.officeHours + "," + this.phone;
    }
}
