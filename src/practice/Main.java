package practice;

import java.util.Scanner;

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


		Pet pet = new Pet("milaneso", "perro", 25, "golden", "Alejandra O G");
		System.out.println(pet);
		
		/**
		int option;

		try {
			
		} catch (Exception e) { System.out.println(e.getMessage()); }

		do {
			System.out.println("\n[0] SALIR\n" + 
							   	 "[1] Cargar \n" +
							   	 "[2] "
							     "=============================================================\n");

			option = getNumber(0, 1);
		
			if (option == 1) {

				
			} 
		} while (option != 0);
		System.out.println("¡ADIOS!");*/
	}
}