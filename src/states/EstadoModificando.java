package states;

import entities.Empleado;
import entities.Vivero;
import exceptions.ExcepcionLineaInvalida;
import utilities.RobotAyuda;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase para el estado modificar en este estado se modifican ya sea empleados o vivero.
 * Los unicos metodos son modifciarVivero  y modificarEmpleado que hace lo que dice el nombre.
 * Ademas del setterRobot que es para tener enlazado el objeto que lo llama.
 */
public class EstadoModificando implements EstadosDelRobot {
    RobotAyuda robot;

    public EstadoModificando(){
    }

    @Override
    public void buscarEmpleado() {
        // TODO Auto-generated method stub

    }

    @Override
    public void buscarVivero() {
        // TODO Auto-generated method stub

    }

    @Override
    public void agregarEmpleado() {
        // TODO Auto-generated method stub

    }

    @Override
    public void agregarVivero() {
        // TODO Auto-generated method stub

    }

    @Override
    public void modificarEmpleado() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el identificador del empleado que quiera modificar.");
        System.out.println(robot.getEmpleadoString());
        Integer identificador;
        Integer identificadorViejo;
        try {
            identificador = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            throw new ExcepcionLineaInvalida();
        }
        if(!robot.existeEmpConID(identificador)){
            System.out.println("No existe empleado con esa identificacion.");
            this.modificarEmpleado();
            return;
        }
        Empleado empleadoAModificar = robot.getRegistro().getRegistrosDeEmpleados().get(identificador);
        String nombre;
        String apellidoP;
        String apellidoM;
        identificadorViejo = identificador;
        identificador = null;
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
            System.out.println(robot.getViveroStringID());
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
            if(robot.existeEmpConID(identificador)&& !identificador.equals(identificadorViejo)){
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
                System.out.println("Ingresar un numero positivo de 10 digitos por favor (Dato: Ningun numero telefonico inicia con 0)");
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

        Empleado empleadoN = new Empleado(identificador, nombre, apellidoP, apellidoM, telefono, salario, vivero, puesto);
        empleadoAModificar.getVivero().eliminarEmpleado(empleadoAModificar.getIdentificador());
        robot.getRegistro().eliminarEmpleado(empleadoAModificar);
        robot.getRegistro().agregarEmpleado(empleadoN, empleadoN.getVivero());
        System.out.println("Listo se ha modificado el empleado " + nombre);
        // TODO Auto-generated method stub

    }

    @Override
    public void modificarVivero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el identificador del vivero que quiera modificar.");
        System.out.println(robot.getViveroStringID());
        Integer identificador;
        Integer identificadorViejo;
        try {
            identificador = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            throw new ExcepcionLineaInvalida();
        }
        if(!robot.existeVivConID(identificador)){
            System.out.println("No existe vivero con esa identificacion;");
            this.modificarVivero();
            return;
        }
        Vivero viveroAModificar = robot.getRegistro().getRegistrosDeViveros().get(identificador);
        String nombre;
        String direccion;
        identificadorViejo = identificador;
        identificador = null;
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
            if(robot.existeVivConID(identificador)&& (!identificador.equals(identificadorViejo))){
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
                System.out.println("Ingresar un numero positivo de 10 digitos por favor. (Dato: Ningun numero telefonico inicia con 0)");
                continue;
            }
            condition = false;
        } while (condition);
        Vivero viveroNuevo = new Vivero(nombre, direccion, telefono, identificador);
        robot.getRegistro().eliminarVivero(viveroAModificar);
        robot.getRegistro().agregaVivero(viveroNuevo);
        System.out.println("Listo se ha modificado el vivero " + nombre);
        // TODO Auto-generated method stub
    }

    @Override
    public void eliminarEmpleado() {
        // TODO Auto-generated method stub

    }

    @Override
    public void eliminarVivero() {
        // TODO Auto-generated method stub

    }

    @Override
    public void iniciar(String nombreArchivoE,String nombreArchivoV) {
        // TODO Auto-generated method stub

    }

    @Override
    public void terminando(String nombreArchivoE,String nombreArchivoV) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRobot(RobotAyuda robot) {
        this.robot = robot;

    }

}
