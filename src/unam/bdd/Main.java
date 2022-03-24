package unam.bdd;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static int getNumber(int num1, int num2) {

		int option = -1;

		do {
			try {

				String cad = sc.next();
				int num = Integer.parseInt(cad);

				if (num >= num1 && num <= num2)
					option = num;
				else
					System.out.println("Opción inválida!!\n");

			} catch (Exception p) { System.out.println("Ese no es un numero!!\n"); }
		} while (option == -1);

		System.out.println();
		return option;
	}

	public static void main(String[] args) {

         /**
		PetFile petFile = new PetFile();
		PetOwnerFile ownerFile = new PetOwnerFile();
		PetVetSalonFile salonFile = new PetVetSalonFile();*/


		//asi escriben una mascota
		Pet pet = new Pet("milaneso", "perro", 25, "golden", "Alejandra O G");
		System.out.println(pet);
		ArrayList<Pet> pets  = new ArrayList<>();
		PetFile writerPet = new PetFile();
		pets.add(pet);
		writerPet.writePet(pets);

		ArrayList<PetOwner> owners = new ArrayList<>();
		Address adress1 = new Address("edomex", "sur", 2, 432);
		PetOwner owner = new PetOwner("Jose", "pEDRO", "Mendez", "jose@gmail", "DASFDF", "11/11/3021", "5591827364", adress1);
		owners.add(owner);
		PetOwnerFile writerPetOwner = new PetOwnerFile();
		writerPetOwner.writeOwner(owners);

		ArrayList<PetVetSalon> salons = new ArrayList<>();
		PetVetSalon salon1 = new PetVetSalon("Vnidades", adress1, "10-18", "5591827364");
		salons.add(salon1);
		PetVetSalonFile writerSalon = new PetVetSalonFile();
		writerSalon.writePetVetSalon(salons);

		int option;

		try {
			
		} catch (Exception e) { System.out.println(e.getMessage()); }

		System.out.println("\n[0] SALIR\n" + 
						   	 "[1] Eliminar \n" +
						   	 "[2] Agregar \n" +
							 "[3] Consultar \n" +
						     "=============================================================\n");

		do {
			option = sc.nextInt();
			if (option == 1) {				
			}
			else if (option == 2) {
				System.out.println("Agrega");				
				System.out.println("What do you want to add?");
				System.out.println("\n[4] VetSalon\n" + "[5] Owner \n" + "[6] Pet \n" +						   	 
						     "=============================================================\n");
				int a = sc.nextInt();
				if (a == 4) {
					FileAdd.addVetSalon();
					break;
				}
				if (a == 5) {
					FileAdd.addOwner();
					break;
				}
				if (a == 6) {
					FileAdd.addPet();					
					break;
				}
				else {
					System.out.println("Opción incorrecta");
					System.exit(0);
				}
			}
			else if (option == 3) {
				System.out.println("Busca");
				break;
			}
		} while (option != 0);
		System.out.println("¡ADIOS!");
	}
}