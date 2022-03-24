
import java.util.ArrayList;

/**
 *Clase que permite escribir y leer a Operadores sobre un archivo CSV
 * @version 23/03/2022
 */
public class PetOwnerFile extends ReadnWrite {
    
    public PetOwnerFile() {
        super("PetOwner.csv");
    }

    /**
     * Metodo que prepara el arreglo de owners  para que puede ser guardado
     *
     * @param owners -- El arreglo de operador
     */
    public void writeOwner(ArrayList<PetOwner> owners) {
    	String lineOwner = "";

    	for (PetOwner o : owners) 
    		lineOwner += o + "\n";

    	super.write(lineOwner);
	}
    
    /**
     * Metodo que convierte un arreglo de String a un arreglo de PetOwner
     *
     * @return operadores -El arreglo de operadores
     * @throws FileNotExists Se lanza la excepción cuando el archivo no existe
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
     * Metodo que recibe una cadena y parsea los datos para crear a un Operador
     *
     * @param stringPetOwner -- La cadena  parsear
     * @return el objeto con los datos de la cadena
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
