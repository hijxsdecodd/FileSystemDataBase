package states;

import entities.Empleado;
import entities.Vivero;
import utilities.RobotAyuda;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase para el estado agregar en este estado se agregan ya sea empleados o vivero.
 * Los unicos metodos son agregarVivero y y agregarEmpleado que hace lo que dice el nombre.
 * Ademas del setterRobot que es para tener enlazado el objeto que lo llama.
 */
public class EstadoAgregando implements EstadosDelRobot {
    RobotAyuda robot;
    public EstadoAgregando(){
    }
    @Override
    public void buscarEmpleado() {
    }
    @Override
    public void buscarVivero() {
    }
    @Override
    public void agregarEmpleado() {
        Scanner sc = new Scanner(System.in);
        do {
            String nombre;
            String apellidoP;
            String apellidoM;
            Integer identificador = null;
            Double salario = null;
            Long telefono = null;
            String puesto;
            String nombreDelVivero;
            boolean condition;
            Vivero vivero = null;
            do {
                condition = true;
                System.out.println("Nombre del vivero en el que trabajara el empleado: ");
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
            Empleado empleado = new Empleado(identificador, nombre, apellidoP, apellidoM, telefono, salario, vivero, puesto);
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
    @Override
    public void agregarVivero() {
        Scanner sc = new Scanner(System.in);
        do {
            String nombre;
            String direccion;
            Integer identificador = null;
            Long telefono = null;
            boolean condition;
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
                System.out.println("Direccion: ");
                System.out.println("(presione solo Enter sin escribir algo para cancelar)");
                direccion = sc.nextLine();
                if(direccion.equals("")){
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
                if(robot.existeVivConID(identificador)){
                    System.out.println("Ya existe un vivero con este identificador, ponga otro.");
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
                    System.out.println("Ingresar un numero positivo de 10 digitos por favor (Dato: Ningun numero telefonico inicia con 0)");
                    continue;
                }
                condition = false;
            } while (condition);
            Vivero vivero = new Vivero(nombre, direccion, telefono, identificador);
            System.out.println("Listo se creo el vivero " + nombre);
            robot.getRegistro().agregaVivero(vivero);
            System.out.println("Se ha agregado el vivero a los registros");
            System.out.println("Desea agregar otro vivero (Y/N)");
            sc.nextLine();
            String continuar = sc.nextLine();
            if(!continuar.equals("Y")){
                break;
            }
        } while (true);
    }
    @Override
    public void modificarEmpleado() {

    }
    @Override
    public void modificarVivero() {

    }
    @Override
    public void eliminarEmpleado() {

    }
    @Override
    public void eliminarVivero() {

    }
    @Override
    public void iniciar(String nombreArchivoE,String nombreArchivoV) {

    }
    @Override
    public void terminando(String nombreArchivoE,String nombreArchivoV) {

    }
    @Override
    public void setRobot(RobotAyuda robot) {
        this.robot = robot;
    }
}
