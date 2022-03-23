package practice;

public class Pet {

    private String name;

    private String breed;

    private int weight;

    private String kind;

    private String owner;

    public Pet(String name, String breed, int weight, String kind, String owner) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.kind = kind;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return this.name + "," + this.breed + "," + this.weight + "," + this.kind + "," + this.owner;
    }

}
