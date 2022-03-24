package unam.bdd;

import java.util.Scanner;

public class FileAdd {
    
    public void agregarEmpleado() {
        Scanner sc = new Scanner(System.in);
        do {
            String firstName;
            String lastNameP;
            String lastNameM;
            String email;         
            String dob;
            Address address;
            String curp;
            String phone;
            boolean condition;
            do {
                condition = true;
                System.out.println("Nombre del cloente en el que trabajara el empleado: ");
                System.out.println("Te mostraremos los viveros existentes");
                System.out.println(robot.getViverosStringDireccion());
                System.out.println("(presione solo Enter sin escribir algo para cancelar)");
                nombreDelVivero = sc.nextLine();
                if(nombreDelVivero.equals("")){
                    System.out.println("Cancelando operacion");
                    return;
                }
                if(robot.getRegistro().busquedaPorNombre(nombreDelVivero) != null){
                    System.out.println("Listo. Nombre del vivero anotado.");
                    vivero = robot.getRegistro().busquedaPorNombre(nombreDelVivero);
                    condition = false;
                    continue;
                }
                System.out.println("No hay registros de viveros con ese nombre, eliga uno de la lista.");
            } while (condition);
            do {
                condition = true;
                System.out.println("Nombre: ");
                System.out.println("(presione solo Enter sin escribir algo para cancelar)");
                nombre = sc.nextLine();
                if(nombre.equals("")){
                    System.out.println("Cancelando operacion");
                    return;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Apellido Paterno: ");
                System.out.println("(presione solo Enter sin escribir algo para cancelar)");
                apellidoP = sc.nextLine();
                if(apellidoP.equals("")){
                    System.out.println("Cancelando operacion");
                    return;
                }
                condition = false;
            } while (condition);

            do {
                condition = true;
                System.out.println("Apellido Materno: ");
                System.out.println("(presione solo Enter sin escribir algo para cancelar)");
                apellidoM = sc.nextLine();
                if(apellidoM.equals("")){
                    System.out.println("Cancelando operacion");
                    return;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Puesto: ");
                System.out.println("(presione solo Enter sin escribir algo para cancelar)");
                puesto = sc.nextLine();
                if(puesto.equals("")){
                    System.out.println("Cancelando operacion");
                    return;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Identificador (5 digitos): ");
                System.out.println("(presione solo Enter sin escribir algo para cancelar)");
                try {
                    identificador = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Ocurrio un error al ingresar el identificador");
                    continue;
                }
                if(identificador.toString().equals("")){
                    System.out.println("Cancelando operacion");
                    return;
                }
                if(identificador < 0 || identificador > 99999){
                    System.out.println("Ingresar un numero positivo de 5 digitos por favor");
                    continue;
                }
                if(robot.existeEmpConID(identificador)){
                    System.out.println("Ya existe un empleado con este identificador, ponga otro.");
                    continue;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Telefono (10 digitos): ");
                System.out.println("(presione solo Enter sin escribir algo para cancelar)");
                try {
                    telefono = sc.nextLong();
                } catch (InputMismatchException e) {
                    System.out.println("Ocurrio un error al ingresar el identificador");
                    continue;
                }
                if(telefono.toString().equals("")){
                    System.out.println("Cancelando operacion");
                    return;
                }
                if(telefono < 0 || telefono.toString().length() != 10){
                    System.out.println("Ingresar un numero positivo de 10 digitos por favor.(Dato: Ningun numero telefonico inicia con 0)");
                    continue;
                }
                condition = false;
            } while (condition);
            do {
                condition = true;
                System.out.println("Salaraio: ");
                System.out.println("(presione solo Enter sin escribir algo para cancelar)");
                try {
                    salario = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Ocurrio un error al ingresar el identificador");
                    continue;
                }
                if(salario.toString().equals("")){
                    System.out.println("Cancelando operacion");
                    return;
                }
                if(salario < 0){
                    System.out.println("Ingresar un numero positivo por favor");
                    continue;
                }
                condition = false;
            } while (condition);
            // (String firstName, String lastNameP, String lastNameM, String email, String curp, String dob, String phone, Address address) {
            PetOwner owner = new PetOwner(firstName, lastNameP, lastNameM, email, curp, dob, phone, address);
            System.out.println("Listo se creo el empleado " + nombre);
            robot.getRegistro().agregarEmpleado(empleado, vivero);
            System.out.println("Se ha agregado el empleado a los registros");
            System.out.println("Desea agregar otro empleado (Y/N)");
            String continuar = sc.nextLine();
            if(!continuar.equals("Y")){
                break;
            }
            
        } while (true);
    }
}
