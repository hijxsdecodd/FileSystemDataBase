package states;

import utilities.RobotAyuda;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
/**
 * Estado del robot terminando en este se cargan los datos de los registros obtenidos a los archivos csv dados.
 */
public class EstadoTerminando implements EstadosDelRobot {
    RobotAyuda robot;
    Scanner escaner;
    public EstadoTerminando(){
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
        try {
            FileOutputStream fileOut = new FileOutputStream(nombreArchivoV);
            OutputStreamWriter osOut = new OutputStreamWriter(fileOut);
            BufferedWriter out = new BufferedWriter(osOut);
            robot.getRegistro().guardaViveros(out);
            out.close();
        } catch (IOException ioe) {
            System.out.printf("No pude guardar en el archivo \"%s\".\n",
                    nombreArchivoV);
            System.exit(1);
        }
        try {
            FileOutputStream fileOut = new FileOutputStream(nombreArchivoE);
            OutputStreamWriter osOut = new OutputStreamWriter(fileOut);
            BufferedWriter out = new BufferedWriter(osOut);
            robot.getRegistro().guardaEmpleados(out);
            out.close();
        } catch (IOException ioe) {
            System.out.printf("No pude guardar en el archivo \"%s\".\n",
                    nombreArchivoE);
            System.exit(1);
        }
        System.out.println("Listo se han guardado los archivos adioooos :D");
    }
    @Override
    public void setRobot(RobotAyuda robot) {
        this.robot = robot;

    }


}
