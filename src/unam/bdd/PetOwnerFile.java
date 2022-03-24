package unam.bdd;

import java.util.ArrayList;

/**
 ** Class that allows Operators to write and read a CSV file.
 * @version 23/03/2022
 */
public class PetOwnerFile extends ReadnWrite {
    
    /**
     * Create a new ReadnWriter object.
     */
    public PetOwnerFile() {
        super("PetOwner.csv");
    }

    /**
     * Method that prepares the owners array so it can be saved.
     * @param owners the operator array.
     */
    public void writeOwner(ArrayList<PetOwner> owners) {
    	String lineOwner = "";

    	for (PetOwner o : owners) 
    		lineOwner += o + "\n";

    	super.write(lineOwner);
	}
    
    /**
     * Method that converts an array of String to an array of PetOwner.
     * @return the operator array.
     * @throws FileNotFound in case the file is not found.
     */
    public ArrayList<PetOwner> readOwners() throws FileNotExists {
        String lines[] = super.read();

        ArrayList<PetOwner> petOwners = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) 
            
            if (!lines[i].equals("null")) 
                petOwners.add(parsePetOwner(lines[i]));

        return petOwners;
    }

    /**
     * Method that receives a string and parses data to create an Operator.
     * @param stringPetOwner the string to parse.
     * @return the object with the string data.
     */
    private PetOwner parsePetOwner(String cad) {
        String line[] = cad.trim().split(",");
        String firstName, lastNameP, lastNameM, email, curp, dob, phone, street, state;
        int zip, number;

        String arr[] = line[0].split(" ");

        state = arr[0];
        street = arr[1];
        number = Integer.parseInt(arr[2]);
        zip = Integer.parseInt(arr[3]);


        firstName = line[1];
        lastNameP = line[2];
        lastNameM = line[3];
    	email = line[4];
        curp = line[5];
    	dob = line[6];
    	phone = line[7];

        return new PetOwner(firstName, lastNameP,lastNameM, email, curp, dob, phone, new Address(state, street, number, zip));
	}
 
}
