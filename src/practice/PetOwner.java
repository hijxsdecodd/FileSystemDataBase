package practice;

import java.util.Date;

public class PetOwner {

    private Address address;

    private String firstName;

    private String lastNameP;

    private String lastNameM;

    private String email;

    private String curp;

    private String dob;

    private String phone;

    public PetOwner(String firstName, String lastNameP, String lastNameM, String email, String curp, String dob, int phone, Address address) {
        this.address = address;
        this.firstName = firstName;
        this.lastNameP = lastNameP;
        this.lastNameM = lastNameM;
        this.email = email;
        this.curp = curp;
        this.dob = dob;
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNameP() {
        return lastNameP;
    }

    public void setLastNameP(String lastNameP) {
        this.lastNameP = lastNameP;
    }

    public String getLastNameM() {
        return lastNameM;
    }

    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void getPets() {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return this.firstName +","+this.lastNameP+","+this.lastNameM+","+this.email+","+this.curp,+","+this.dob+","+this.phone+","+this.address;
    }
}
