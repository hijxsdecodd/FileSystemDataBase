package unam.bdd;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FileAdd {
    
    /**
     * Method to write a new Owner into de CSV file.
     */
    public static void addOwner() {
        Scanner sc = new Scanner(System.in);
        do {
            String firstName;
            String lastNameP;
            String lastNameM;
            String email;         
            String dob;                        
            String phone;
            String curp;
            Address address;
            boolean condition;          
            do {
                condition = true;
                System.out.println("Owner's name: ");
                System.out.println("(press Enter to cancel)");
                firstName = sc.nextLine();
                if(firstName.equals("")){
                    System.out.println("Canceling...");
                    return;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Father's surname: ");
                System.out.println("(press Enter to cancel)");
                lastNameP = sc.nextLine();
                if(lastNameP.equals("")){
                    System.out.println("Canceling...");
                    return;
                }
                condition = false;
            } while (condition);

            do {
                condition = true;
                System.out.println("Mother's surname: ");
                System.out.println("(press Enter to cancel)");
                lastNameM = sc.nextLine();
                if(lastNameM.equals("")){
                    System.out.println("Canceling...");
                    return;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Email: ");
                System.out.println("(press Enter to cancel)");
                email = sc.nextLine();
                if(email.equals("")){
                    System.out.println("Canceling...");
                    return;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Day of birth: ");
                System.out.println("(press Enter to cancel)");
                dob = sc.nextLine();
                if(dob.toString().equals("")){
                    System.out.println("Canceling...");
                    return;
                }                
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Phone (10 digits): ");
                System.out.println("(press Enter to cancel)");
                phone = sc.nextLine();
                if(phone.toString().equals("")){
                    System.out.println("Canceling...");
                    return;
                }                
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Curp: ");
                System.out.println("(press Enter to cancel)");            
                curp = sc.nextLine();                
                if(curp.toString().equals("")){
                    System.out.println("Canceling...");
                    return;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Address: ");
                System.out.println("(press Enter to cancel)");
                System.out.println("State: ");
                String state = sc.nextLine();
                if(state.toString().equals("")){
                    System.out.println("Canceling...");
                    return;
                }                           
                System.out.println("Street: ");
                String street = sc.nextLine();
                System.out.println("Number: ");
                int number = sc.nextInt();
                System.out.println("ZIP: ");
                int zip = sc.nextInt();                                
                address = new Address(state, street, number, zip);                
                condition = false;
            } while (condition);
            // (String firstName, String lastNameP, String lastNameM, String email, String curp, String dob, String phone, Address address) {
            PetOwner owner = new PetOwner(firstName, lastNameP, lastNameM, email, curp, dob, phone, address);
            System.out.println("Listo se creo el cliente " + firstName);
            ReadnWrite bdd = new ReadnWrite("PetOwner.csv");
            bdd.write(owner.toString());
            System.out.println("Owner saved");
            System.out.println("Want to add more? (Y/N)");
            String continuar = sc.nextLine();
            if(!continuar.equals("Y")){
                break;
            }
            
        } while (true);
    }

     /**
     * Method to write a new Pet into de CSV file.
     */
    public static void addPet() {
        Scanner sc = new Scanner(System.in);
        do {
            String name;
            String breed;
            int weight = 0;
            String kind;
            String owner;  
            boolean condition;  
            do {
                condition = true;
                System.out.println("Pet's name: ");
                System.out.println("(press Enter to cancel)");
                name = sc.nextLine();
                if(name.equals("")){
                    System.out.println("Canceling...");
                    return;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Pet's breed: ");
                System.out.println("(press Enter to cancel)");
                breed = sc.nextLine();
                if(breed.equals("")){
                    System.out.println("Canceling...");
                    return;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Kind of Pet: ");
                System.out.println("(press Enter to cancel)");
                kind = sc.nextLine();
                if(kind.equals("")){
                    System.out.println("Canceling...");
                    return;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Pet's owner: ");
                System.out.println("(press Enter to cancel)");
                owner = sc.nextLine();
                if(owner.toString().equals("")){
                    System.out.println("Canceling...");
                    return;
                }                
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Pets's weight: ");
                System.out.println("(press Enter to cancel)");
                weight = sc.nextInt();                
                if(Integer.valueOf(weight).toString().equals("")){
                    System.out.println("Canceling");
                    return;
                }
                condition = false;
            } while (condition);            
            
            Pet pet = new Pet(name, breed, weight, kind, owner);
            System.out.println("Pet created " + name);
            ReadnWrite bdd = new ReadnWrite("Pet.csv");
            bdd.write(pet.toString());
            System.out.println("Pet saved");
            System.out.println("Want to add more? (Y/N)");
            String continuar = sc.nextLine();
            if(!continuar.equals("Y")){
                break;
            }            
        } while (true);
    }

     /**
     * Method to write a new VetSalon into de CSV file.
     */
    public static void addVetSalon() {
        Scanner sc = new Scanner(System.in);
        do {
            String phone;
            String name;
            Address address;
            String officeHours;
            boolean condition;      
            do {
                condition = true;
                System.out.println("Vet Salon name: ");
                System.out.println("(press Enter to cancel)");
                name = sc.nextLine();
                if(name.equals("")){
                    System.out.println("Canceling...");
                    return;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Vet Salon phone: ");
                System.out.println("(press Enter to cancel)");
                phone = sc.nextLine();
                if(phone.equals("")){
                    System.out.println("Canceling...");
                    return;
                }
                condition = false;
            } while (condition);

            do {
                condition = true;
                System.out.println("Vet Salon hours: ");
                System.out.println("(press Enter to cancel)");
                officeHours = sc.nextLine();
                if(officeHours.equals("")){
                    System.out.println("Canceling...");
                    return;
                }
                condition = false;
            } while (condition);            
            do {
                condition = true;
                System.out.println("Address: ");
                System.out.println("(press Enter to cancel)");
                System.out.println("State: ");
                String state = sc.nextLine();
                if(state.toString().equals("")){
                    System.out.println("Canceling...");
                    return;
                }                           
                System.out.println("Street: ");
                String street = sc.nextLine();
                System.out.println("Number: ");
                int number = sc.nextInt();
                System.out.println("ZIP: ");
                int zip = sc.nextInt();                                
                address = new Address(state, street, number, zip);                
                condition = false;
            } while (condition);
            PetVetSalon salon = new PetVetSalon(name, address, officeHours, phone);
            System.out.println("Salon created " + name);
            ReadnWrite bdd = new ReadnWrite("PetVetSalon.csv");
            bdd.write(salon.toString());
            System.out.println("Salon saved");
            System.out.println("Want to add more? (Y/N)");
            String continuar = sc.nextLine();
            if(!continuar.equals("Y")){
                break;
            }
            
        } while (true);
    }
}
