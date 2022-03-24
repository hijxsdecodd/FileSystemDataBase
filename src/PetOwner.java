public class PetOwner {

    private Address address;

    private String firstName;

    private String lastNameP;

    private String lastNameM;

    private String email;

    private String curp;

    private String dob;

    private String phone;

    /**
     * Pet owner constructor.
     * @param firstName the owner's first name.
     * @param lastNameP the owner's father surname.
     * @param lastNameM the owner's mother surname.
     * @param email the owner's mail.
     * @param curp the owner's curp.
     * @param dob the owner's birthday.
     * @param phone the owner's phone.
     * @param address the owner's address.
     */
    public PetOwner(String firstName, String lastNameP, String lastNameM, String email, String curp, String dob, String phone, Address address) {
        this.address = address;
        this.firstName = firstName;
        this.lastNameP = lastNameP;
        this.lastNameM = lastNameM;
        this.email = email;
        this.curp = curp;
        this.dob = dob;
        this.phone = phone;
    }

    /**
     * @return the owner's address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the complete address of the owner.
     * @param address the owner's address.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the owner's name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the owner.
     * @param firstName the owner's name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the owner's father surname.
     */
    public String getLastNameP() {
        return lastNameP;
    }

    /**
     * Set the father's surname of the owner.
     * @param lastNameP the owner's father surname.
     */
    public void setLastNameP(String lastNameP) {
        this.lastNameP = lastNameP;
    }

    /**
     * @return the owner's mother surname.
     */
    public String getLastNameM() {
        return lastNameM;
    }

    /**
     * Set the mother's surname of the owner.
     * @param lastNameM the owner's mother surname.
     */
    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
    }

    /**
     * @return the owner mail.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the owner.
     * @param email the owner mail.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the owner curp.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Set the curp of the owner.
     * @param curp the owner curp.
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * @return the owner day of birth.
     */
    public String getDob() {
        return dob;
    }

    /**
     * Set the day of birth of the owner.
     * @param dob the owner day of birth.
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the owner phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone number of the pet owner.
     * @param phone the owner phone number.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the string representation of the pet owner.
     */
    @Override
    public String toString() {
        return this.firstName +","+this.lastNameP+","+this.lastNameM+","+this.email+","+this.curp+","+this.dob+","+this.phone+","+this.address;
    }
}
