package states;

import entities.Empleado;
import entities.Vivero;
import utilities.RobotAyuda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EstadoBuscando implements EstadosDelRobot {
    RobotAyuda robot;

    public EstadoBuscando(){
    }
    /**
     * Clase para el estado buscar en este estado se buscan ya sea empleados o vivero.
     * Los unicos metodos son buscarVivero y y buscarEmpleado que hace lo que dice el nombre.
     * Ademas del setter del robot que es el que lo llama.
     */
    @Override
    public void buscarEmpleado() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el identificador del empleado a buscar");
        Integer identificador;
        try {
            identificador = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException ime) {
            System.out.println("Número inválido:");
            this.buscarEmpleado();
            return;
        }
        if(!robot.getRegistro().empleados.containsKey(identificador)){
            System.out.println("No se encontro el empleado con dicho identificador en los registros.");
            return;
        }
        Empleado empleado = robot.getRegistro().getRegistrosDeEmpleados().get(identificador);
        String mensaje = "Se encontro el empleado: " + empleado.getNombre() + " " + empleado.getApellidoP();
        mensaje += " " + empleado.getApellidoM() + "\n Con identificador: "+  String.format("%05d", identificador)+"\n";
        mensaje += "Trabaja en el vivero: "+ empleado.getVivero().getNombre() + "\nUbicado en: " +empleado.getVivero().getDireccion();
        System.out.println(mensaje);
    }

    @Override
    public void buscarVivero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el identificador del com.fbd.Entities.Vivero a buscar:");
        Integer identificador;
        try {
            identificador = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException ime) {
            System.out.println("Número inválido:");
            this.buscarVivero();
            return;
        }
        if(!robot.getRegistro().viveros.containsKey(identificador)){
            System.out.println("No se encontro el vivero con dicho identificador en los registros.");
            return;
        }
        Vivero vivero = robot.getRegistro().getRegistrosDeViveros().get(identificador);
        String mensaje = "Se encontro el vivero: " + vivero.getNombre() + "\nUbicado en: " +vivero.getDireccion();
        mensaje += "\nCon identificador: "+ identificador+"\n";
        mensaje += "Trabajan en el vivero: \n"+ vivero.getEmpleadosString();
        System.out.println(mensaje);
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
        // TODO Auto-generated method stub

    }

    @Override
    public void modificarVivero() {
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
