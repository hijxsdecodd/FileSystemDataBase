package practice;

import java.util.ArrayList;

/**
 * Clase que permite escribir y leer a Operadores sobre un archivo CSV
 * @version 23/03/2022
 */
public class PetVetSalonFile extends ReadnWrite {

    /**
     * Constructor por omision que crea el archivo Operador.csv
     */
    public PetOwnerFile() {
        super("PetVetSalon.csv");
    }

    /**
     * Metodo que prepara el arreglo de PetVetSalon  para que puede ser guardado
     *
     * @param owners 
     */
    public void writePetVetSalon(ArrayList<PetOwner> petVetSalons) {
    	String line = "";

    	for (PetVetSalons  salon : petVetSalons)
    		line += salon + "\n";

    	super.write(line);
	}
    
    /**
     * Metodo que convierte un arreglo de String a un arreglo de PetOwner
     *
     * @return operadores -- El arreglo de operadores
     * @throws FileNotFound -- Se lanza la excepción cuando el archivo no existe
     */
    public ArrayList<PetVetSalons> readPetVetSalons() throws FileNotExists {
        String lines[] = super.read();

        ArrayList<PetOwner> petVetSalons = new ArrayList<>();
        
        for (int i = 0; i < lines.length; i++) 
            
            if (!lines[i].equals("null"))
                petVetSalons.add(parsePetVetSalons(lines[i]));

        return petOwners;
    }

    private PetVetSalon parsePetVetSalons(String line) {

        String line[] = cadenaOperador.trim().split(",");

        String name, address, officeHours, phone;

        name = line[0];
        address = line[1];
        officeHours = line[2];
        phone = line[3];

        return new PetVetSalon(name, address, officeHours,phone);
    }

}