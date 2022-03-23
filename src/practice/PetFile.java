package practice;

import java.util.ArrayList;

public class PetFile extends ReadnWriter {

	public PetFile() {
		super("Pet.csv");
	}

	public void writePet(ArrayList<Pet> pets) {
		String line = "";

		for (Pet p: pets)
			line += p + "\n";

		super.write(line);
	}

	public ArrayList<Pet> readPet() throws FileNotExists {
		String lines[] = super.read();
        
        ArrayList<Pet> pets = new ArrayList<>();
        
        for (int i = 0; i < lines.length; i++) 
            
            if (!lines[i].equals("null")) 
                pets.add(parser(lines[i]));
		
		return pets;
	}

	private void parse(String cad) {
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