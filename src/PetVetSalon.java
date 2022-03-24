public class PetVetSalon {

    private String phone;

    private String name;

    private Address address;

    private String officeHours;

    public PetVetSalon (String name, Address address, String officeHours, String phone) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.officeHours = officeHours;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address adress) {
        this.address = adress;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    @Override
    public String toString() {
        return this.name + "," + this.address + ","+ this.officeHours + "," + this.phone;
    }
}
