package states;

import entities.Empleado;
import entities.Vivero;
import exceptions.ExcepcionLineaInvalida;
import utilities.RobotAyuda;

import java.util.Scanner;
/**
 * Clase para el estado eliminar en este estado se eliminan ya sea empleados o vivero.
 * Los unicos metodos son eliminarVivero y y eliminarEmpleado que hace lo que dice el nombre.
 * Ademas del setterRobot que es para tener enlazado el objeto que lo llama.
 */
public class EstadoEliminando implements EstadosDelRobot{
    RobotAyuda robot;

    public EstadoEliminando(){
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
        // TODO Auto-generated method stub

    }

    @Override
    public void modificarVivero() {
        // TODO Auto-generated method stub

    }

    @Override
    public void eliminarEmpleado() {
        Scanner escaner = new Scanner(System.in);
        System.out.println("Ingrese el identificador del empleado que quiera eliminar.");
        System.out.println(robot.getRegistro().getEmpleadosString());
        Integer identificador;
        try {
            identificador = escaner.nextInt();
            escaner.nextLine();
        } catch (Exception e) {
            throw new ExcepcionLineaInvalida();
        }
        if(!robot.getRegistro().getRegistrosDeEmpleados().containsKey(identificador)){
            System.out.println("No existe empleado con esa identificacion;");
            this.eliminarEmpleado();
            return;
        }
        Empleado empleado = robot.getRegistro().getRegistrosDeEmpleados().get(identificador);
        empleado.getVivero().eliminarEmpleado(identificador);
        robot.getRegistro().eliminarEmpleado(empleado);
        System.out.println("Listo se elimino el empleado");
    }

    @Override
    public void eliminarVivero() {
        Scanner escaner = new Scanner(System.in);
        System.out.println("Ingrese el identificador del vivero que quiera eliminar.");
        System.out.println(robot.getRegistro().getViverosStringID());
        Integer identificador;
        try {
            identificador = escaner.nextInt();
            escaner.nextLine();
        } catch (Exception e) {
            throw new ExcepcionLineaInvalida();
        }
        if(!robot.getRegistro().getRegistrosDeViveros().containsKey(identificador)){
            System.out.println("No existe vivero con esa identificacion;");
            this.eliminarVivero();
            return;
        }
        Vivero vivero = robot.getRegistro().getRegistrosDeViveros().get(identificador);
        robot.getRegistro().eliminarVivero(vivero);

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
