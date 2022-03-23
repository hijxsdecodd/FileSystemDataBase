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
    public PetVetSalonFile() {
        super("PetVetSalon.csv");
    }

    /**
     * Metodo que prepara el arreglo de PetVetSalon  para que puede ser guardado
     *
     * @param owners 
     */
    public void writePetVetSalon(ArrayList<PetVetSalon> salons) {
    	String line = "";

    	for (PetVetSalon  salon : salons)
    		line += salon + "\n";

    	super.write(line);
	}
    
    /**
     * Metodo que convierte un arreglo de String a un arreglo de PetOwner
     *
     * @return operadores -- El arreglo de operadores
     * @throws FileNotFound -- Se lanza la excepción cuando el archivo no existe
     */
    public ArrayList<PetVetSalon> readPetVetSalons() throws FileNotExists {
        String lines[] = super.read();

        ArrayList<PetVetSalon> salons = new ArrayList<>();
        
        for (int i = 0; i < lines.length; i++) 
            
            if (!lines[i].equals("null"))
                salons.add(parsePetVetSalons(lines[i]));

        return salons;
    }

    private PetVetSalon parsePetVetSalons(String cad) {

        String line[] = cad.trim().split(",");

        String name, address, officeHours, phone, state, street;

        int number, zip;

        String arr[] = line[0].split(" ");

        state = arr[0];
        street = arr[1];
        number = Integer.parseInt(arr[2]);
        zip = Integer.parseInt(arr[3]);

        name = line[0];
        address = line[1];
        officeHours = line[2];
        phone = line[3];

        return new PetVetSalon(name, new Address(state, street, number, zip), officeHours, phone);
    }

}