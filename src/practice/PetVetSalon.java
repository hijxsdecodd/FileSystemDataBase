package entities;

public class PetVetSalon{

    private int phone;

    private String name;

    private Address address;

    private String officeHours;

    public PetVetSalon(
            String name,
            Address address,
            String officeHours,
            int phone
    ){
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.officeHours = officeHours;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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
}
