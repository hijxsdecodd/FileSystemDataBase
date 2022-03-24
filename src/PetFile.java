import java.util.ArrayList;

/**
 * Class that allows us to define a PetVet salon.
 * @version 23/03/2022
 */
public class PetFile extends ReadnWrite {

	/**
	 * Create a new ReadnWriter object.
	 */
	public PetFile() {
		super("Pet.csv");
	}

	/**
	 * Method that prepares the pets array so it can be saved.
	 * @param pets the pets array.
	 */
	public void writePet(ArrayList<Pet> pets) {
		String line = "";

		for (Pet p: pets)
			line += p + "\n";

		super.write(line);
	}

	/**
	 * Method that converts an array of String to an array of Pet.
     * @return the pet array.
	 * @throws FileNotExists in case the file is not found.
	 */
	public ArrayList<Pet> readPet() throws FileNotExists {
		String lines[] = super.read();
        
        ArrayList<Pet> pets = new ArrayList<>();
        
        for (int i = 0; i < lines.length; i++) 
            
            if (!lines[i].equals("null")) 
                pets.add(parse(lines[i]));
		
		return pets;
	}

	/**
	 * Method that receives a string and parses data to create a pet.
	 * @param cad the string to parse.
	 * @return the object with the string data.
	 */
	private Pet parse(String cad) {
		String line[] = cad.trim().split(",");

		String name, breed, weight, kind, owner;

		name = line[0];
		breed = line[1];
		weight = line[2];
		kind = line[3];
		owner = line[4];

		return new Pet(name, breed, Integer.parseInt(weight), kind, owner);
	}

}