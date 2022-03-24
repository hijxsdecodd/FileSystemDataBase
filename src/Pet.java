public class Pet {

    private String name;

    private String breed;

    private int weight;

    private String kind;

    private String owner;

    /**
     * The pet constructor.
     * @param name the pet's name.
     * @param breed the pet's breed.
     * @param weight the pet's weight.
     * @param kind the pet's type.
     * @param owner the pet owner.
     */
    public Pet(String name, String breed, int weight, String kind, String owner) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.kind = kind;
        this.owner = owner;
    }

    /**
     * @return the pet's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the pet.
     * @param name the pet's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pet's breed.
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Set the breed of the pet.
     * @param breed the pet's breed.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * @return the pet's weight.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Set the weight of the pet.
     * @param weight the pet's weight.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the pet type.
     */
    public String getKind() {
        return kind;
    }

    /**
     * Set the kind of animal of the pet.
     * @param kind the pet type.
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return the pet owner.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Set the name of the owner of the pet.
     * @param owner the pet owner.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    /**
     * @return the string representation of the address.
     */
    @Override
    public String toString() {
        return this.name + "," + this.breed + "," + this.weight + "," + this.kind + "," + this.owner;
    }

}
