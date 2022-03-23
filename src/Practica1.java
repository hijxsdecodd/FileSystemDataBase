import states.*;
import utilities.RobotAyuda;

import java.util.Scanner;

public class Practica1 {
    public static void main(String[] args ) {

        Scanner sc = new Scanner(System.in);
        String nombreArchivoE = "Empleados.csv";
        String nombreArchivoV = "Viveros.csv";

        EstadosDelRobot estadoInicial = new EstadoIniciando();
        EstadosDelRobot estadoAgregando = new EstadoAgregando();
        EstadosDelRobot estadoModificando = new EstadoModificando();
        EstadosDelRobot estadoEliminando = new EstadoEliminando();
        EstadosDelRobot estadoBuscando = new EstadoBuscando();
        EstadosDelRobot estadoTerminando = new EstadoTerminando();
        RobotAyuda robot = new RobotAyuda(estadoInicial);
        estadoInicial.setRobot(robot);
        estadoAgregando.setRobot(robot);
        estadoBuscando.setRobot(robot);
        estadoEliminando.setRobot(robot);
        estadoTerminando.setRobot(robot);
        estadoModificando.setRobot(robot);
        robot.iniciar(nombreArchivoE, nombreArchivoV);
        boolean condition = true;
        String mensaje = "Menu: \n" +"[1] Add \n";
        mensaje += "[2] Modify \n";
        mensaje += "[3] Erase \n";
        mensaje += "[4] Search\n";
        mensaje += "[0] Exit";

        do {
            System.out.println(mensaje);
            int opcion = sc.nextInt();
            if( opcion > 4 || opcion < 0){
                System.out.println("Only valid options must be selected");
                continue;
            }
            switch (opcion) {
                case 1:
                    robot.cambioDeEstado(estadoAgregando);
                    robot.agregar();
                    break;
                case 2:
                    robot.cambioDeEstado(estadoModificando);
                    robot.modificar();
                    break;
                case 3:
                    robot.cambioDeEstado(estadoEliminando);
                    robot.eliminar();
                    break;
                case 4:
                    robot.cambioDeEstado(estadoBuscando);
                    robot.buscar();
                    break;
                case 0:
                    condition = false;
                    break;
                default:
                    System.out.println("Escriba solo las opciones dadas del menu por favor");
                    continue;
            }
        } while (condition);
        robot.cambioDeEstado(estadoTerminando);
        robot.terminar(nombreArchivoE, nombreArchivoV);
        sc.close();
    }
}

