package unam.bdd;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* class to eliminate pet, owner and veterinarian registrations. */
public class FileDelete {
    /* pet registries */
    private ArrayList<Pet> pets;
    /* owners registries */
    private ArrayList<PetOwner> owners;
    /* Salons/veterinarian registries */
    private ArrayList<PetVetSalon> salons;

    public FileDelete(ArrayList<Pet> pets,ArrayList<PetOwner> owners, ArrayList<PetVetSalon> salons,PetFile petf, PetOwnerFile ownerf, PetVetSalonFile salonf){
        this.owners = owners;
        this.pets = pets;
        this.salons = salons;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = -1;
        while(true){
            System.out.println("Desea eliminar un registro[1=Yes,0=No]");
            try {
                String numero = br.readLine();
                n = Integer.parseInt(numero);
            } catch (Throwable e) {
                System.out.println("Error");
                continue;
            }
            if(n !=  0 && n != 1){
                System.out.println("Escriba 1 si desea eliminar un registro, 0 en caso contrario");
                continue;
            }
            if(n==0)
                break;
            String m = "Si desea eliminar una mascota escriba 1. \n" + "Si desea eliminar una cliente/duenno escriba 2. \n";
            m += "si desea eliminar una Salon escriba 3";
            n = -1;
            System.out.println(m);
            while(true){
                try {
                    String numero = br.readLine();
                    n = Integer.parseInt(numero);
                } catch (Throwable e) {
                    System.out.println("Error");
                    continue;
                }
                if(n != 1 && n != 2 && n != 3){
                    System.out.println("Unicas opciones (1 = elimina mascota, 2 = elimina duenno, 3 = elimina salon)");
                    continue;
                }
                if (n == 1) {
                    pets = this.deletePet();
                    petf.writePet(pets);
                } else if(n==2) {
                    owners = this.deleteOwner();
                    ownerf.writeOwner(owners);
                } else {
                    salons = this.deleteSalon();
                    salonf.writePetVetSalon(salons);
                }
            }
        }
    }
    /** method to eliminate owner registries */
    public ArrayList<PetOwner> deleteOwner(){
        for (PetOwner petOwner : owners) {
            System.out.println(petOwner.getCurp()+ ": " + petOwner.getFirstName());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el curp del duenno que quiera eliminar:");
        String curp = "";
        while(true){
            try {
                curp = br.readLine();
            } catch (Throwable e) {
                System.out.println("Error ");
            }
            for (PetOwner petOwner : owners) {
                if(curp.equals(petOwner.getCurp())){
                    owners.remove(petOwner);
                    return owners;
                }
            }
            System.out.println("No se encontro registro de un duenno con ese curp, escriba bien el curp.");
        }

    }
    /**  method to eliminate pet registries*/
    public ArrayList<Pet> deletePet(){
        for (Pet pet : pets) {
            System.out.println(pet.getKind()+ ": " + pet.getName());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el tipo y nombre de la mascota que quiera eliminar:");
        String kind = "";
        String name = "";
        while(true){
            try {
                System.out.println("Tipo: ");
                kind = br.readLine();
                System.out.println("Nombre: ");
                name = br.readLine();
            } catch (Throwable e) {
                System.out.println("Error ");
            }
            for (Pet pet : pets) {
                if(kind.equals(pet.getKind()) && name.equals(pet.getName())){
                    pets.remove(pet);
                    return pets;
                }
            }
            System.out.println("No se encontro registro de una mascota con esos datos, escriba bien los datos.");
        }
    }
    /** method to eliminate salon registries */
    public ArrayList<PetVetSalon> deleteSalon(){
        for (PetVetSalon salon : salons) {
            System.out.println(salon.getName());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el nombre del salon que quiera eliminar:");
        String name = "";
        while(true){
            try {
                name = br.readLine();
            } catch (Throwable e) {
                System.out.println("Error ");
            }
            for (PetVetSalon salon : salons) {
                if(name.equals(salon.getName())){
                    salons.remove(salon);
                    return salons;
                }
            }
            System.out.println("No se encontro registro de un VetSalon con ese nombre, escriba bien el nombre.");
        }
    }
}
