package states;

import utilities.RobotAyuda;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EstadoIniciando implements EstadosDelRobot {
    RobotAyuda robot;
    public EstadoIniciando(){
    }
    @Override
    public void buscarEmpleado() {
        EstadosDelRobot estado = new EstadoBuscando();
        estado.setRobot(robot);

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
        try {
            FileInputStream fileIn = new FileInputStream(nombreArchivoV);
            InputStreamReader isIn = new InputStreamReader(fileIn);
            BufferedReader in = new BufferedReader(isIn);
            robot.getRegistro().cargaVivero(in);
            in.close();
        } catch (IOException ioe) {
            System.out.printf("Error: No pude cargar del archivo \"%s\".\n",
                    nombreArchivoV);
            System.exit(1);
        }


        System.out.printf("Base de datos cargada exitosamente de \"%s\".\n\n",
                nombreArchivoV);
        try {
            FileInputStream fileIn = new FileInputStream(nombreArchivoE);
            InputStreamReader isIn = new InputStreamReader(fileIn);
            BufferedReader in = new BufferedReader(isIn);
            robot.getRegistro().cargaEmpleados(in);
            in.close();
        } catch (IOException ioe) {
            System.out.printf("Error: No pude cargar del archivo \"%s\".\n",
                    nombreArchivoE);
            System.exit(1);
        }

        System.out.printf("Base de datos cargada exitosamente de \"%s\".\n\n",
                nombreArchivoE);

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

