import java.util.ArrayList;

/**
 * Class that allows Operators to write and read a CSV file.
 * @version 23/03/2022
 */
public class PetVetSalonFile extends ReadnWrite {

    /**
     * Default constructor that creates the file "Operador.csv".
     */
    public PetVetSalonFile() {
        super("PetVetSalon.csv");
    }

    /**
     * Method that prepares the PetVet Salon array so it can be saved.
     * @param salons the vets array.
     */
    public void writePetVetSalon(ArrayList<PetVetSalon> salons) {
    	String line = "";

    	for (PetVetSalon  salon : salons)
    		line += salon + "\n";

    	super.write(line);
	}
    
    /**
     * Method that converts an array of String to an array of PetSalon.
     * @return the operator array.
     * @throws FileNotFound in case the file is not found.
     */
    public ArrayList<PetVetSalon> readPetVetSalons() throws FileNotExists {
        String lines[] = super.read();

        ArrayList<PetVetSalon> salons = new ArrayList<>();
        
        for (int i = 0; i < lines.length; i++) 
            
            if (!lines[i].equals("null"))
                salons.add(parsePetVetSalons(lines[i]));

        return salons;
    }

    /**
     * Method to parse the PetVet salons and their attributes.
     * @param cad the string to parse.
     * @return the object with the string data.
     */
    private PetVetSalon parsePetVetSalons(String cad) {

        String line[] = cad.trim().split(",");

        String name, officeHours, phone, state, street;

        int number, zip;

        String arr[] = line[1].split(" ");

        state = arr[0];
        street = arr[1];
        number = Integer.parseInt(arr[2]);
        zip = Integer.parseInt(arr[3]);

        name = line[0];
        officeHours = line[2];
        phone = line[3];

        return new PetVetSalon(name, new Address(state, street, number, zip), officeHours, phone);
    }

}