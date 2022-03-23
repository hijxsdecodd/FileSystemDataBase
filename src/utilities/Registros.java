package utilities;

import entities.Vivero;
import entities.Empleado;
import exceptions.ExcepcionLineaInvalida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

public class Registros {
    public HashMap<Integer, Vivero> viveros;
    public HashMap<Integer, Empleado> empleados;
    RobotAyuda robot;
    private  String metadatosEmpleados;
    private  String metadatosVivero;
    public Registros(RobotAyuda robot){
        viveros = new HashMap<>();
        empleados = new HashMap<>();
        this.robot = robot;
    }
    /**
     * Buscamos un vivero en los registros dado su nombre.
     */
    public Vivero busquedaPorNombre(String nombre){
        for(Vivero vivero1: this.viveros.values()){
            System.out.println("nop");
            String nombrevivero = vivero1.getNombre().replaceAll(" ", "");
            nombre = nombre.replaceAll(" ", "");
            if(nombrevivero.equals(nombre)){
                return vivero1;
            }
        }
        return null;


    }
    /**
     * Buscamos un vivero en los registros dado su ID.
     */
    public Vivero busquedaV(Integer identificador) {
        try {
            return viveros.get(identificador);
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * Getters de los numeros de viveros y empleados registrados.
     */
    public int getNumeroDeViveros(){
        return viveros.size();
    }
    public int getNumeroDeEmpleados(){
        return empleados.size();
    }
    /**
     * Getter de los registrosd de viveros y empleados.
     */
    public HashMap<Integer,Vivero> getRegistrosDeViveros(){
        HashMap<Integer,Vivero> copia = new HashMap<>(viveros);
        return copia;
    }
    public HashMap<Integer,Empleado> getRegistrosDeEmpleados(){
        HashMap<Integer,Empleado> copia = new HashMap<>(empleados);
        return copia;
    }
    /**
     * Eliminadores de empleado y vivero de los registros.
     */
    public void eliminarEmpleado(Empleado empleado){
        empleados.remove(empleado.getIdentificador());
    }
    public void eliminarVivero(Vivero vivero){
        HashMap<Integer,Empleado> empleadosDelVivero = vivero.getEmpleados();
        for(Integer identificador: empleadosDelVivero.keySet()){
            empleados.remove(identificador);
        }
        viveros.remove(vivero.getIdentificador());
    }
    /**
     * Nos devuelve los empleados de un vivero dado.
     */
    public HashMap<Integer,Empleado> getEmpleadosDeUnVivero(Vivero vivero){
        return vivero.getEmpleados();
    }
    /**
     * Agregadores de empleados y viveros a los registros.
     */
    public void agregaVivero(Vivero vivero){
        viveros.put(vivero.getIdentificador(), vivero);
    }
    public void agregarEmpleado(Empleado empleado, Vivero vivero){
        vivero.annadirEmpleado(empleado);
        empleados.put(empleado.getIdentificador(), empleado);
    }
    public void limpia(){
        viveros.clear();
        empleados.clear();
    }
    /**
     * Metodos para guardar los registros de empleados y viveros en los archivos.
     */
    public void guardaEmpleados(BufferedWriter out) throws IOException {
        out.write(metadatosEmpleados);
        for (Empleado empleado : empleados.values()) {
            out.write(empleado.aLinea());
        }
    }
    public void guardaViveros(BufferedWriter out) throws IOException {
        out.write(metadatosVivero);
        for (Vivero vivero: viveros.values()){
            out.write(vivero.aLinea());
        }
    }
    /**
     * Metodos para cargar los registros de empleados y viveros de los archivos.
     */
    public void cargaVivero(BufferedReader in) throws IOException {
        viveros.clear();
        String linea;
        Vivero vivero;
        int i = 0;
        while ((linea = in.readLine())!= null && !(linea = linea.trim()).equals("")){
            if(i==0){
                metadatosVivero = linea + "\n";
                i++;
                continue;
            }
            vivero = new Vivero();
            try{
                vivero.leeLinea(linea);
            }catch (ExcepcionLineaInvalida a){
                throw new IOException();
            }
            agregaVivero(vivero);
        }
    }
    public void cargaEmpleados(BufferedReader in) throws IOException {
        empleados.clear();
        String linea;
        Empleado empleado;
        int i =0;
        while ((linea = in.readLine())!= null && !(linea = linea.trim()).equals("")){
            if(i==0){
                metadatosEmpleados = linea + "\n";
                i++;
                continue;
            }
            empleado = new Empleado();
            try{
                empleado.leeLinea(linea, this);
            }catch (ExcepcionLineaInvalida a){
                throw new IOException();
            }catch (NullPointerException n){
                System.out.println("El com.fbd.Entities.Vivero donde trabaja el epmleado: "+linea+ " no existe.\n No se cargara ese empleado.");
                continue;
            }
            agregarEmpleado(empleado, empleado.getVivero());
        }
    }
    /**
     * Metodos para recibir la lista de los empleados y viveros de forma String para imprimirlos.
     */
    public String getEmpleadosString(){
        String empleados = "Empleados: \n";
        for (Empleado empleado : this.empleados.values()) {
            empleados += "Nombre: "+ empleado.getNombre() +" "+ empleado.getApellidoP()+" "+empleado.getApellidoM()+"\n";
            empleados += "ID: "+ String.format("%05d", empleado.getIdentificador()) + "\n";
        }
        return empleados;
    }
    public String getViverosStringID(){
        String viveros = "Viveros: \n";
        for(Vivero vivero: this.viveros.values()){
            viveros += "com.fbd.Entities.Vivero: " + vivero.getNombre()+"\n";
            viveros += "ID: "+  String.format("%05d", vivero.getIdentificador()) +"\n";
        }
        return viveros;
    }
    public String getViverosStringDireccion(){
        String viveros = "Viveros: \n";
        for(Vivero vivero: this.viveros.values()){
            viveros += "com.fbd.Entities.Vivero: " + vivero.getNombre()+"\n";
            viveros += "Direccion: "+ vivero.getDireccion() +"\n";
        }
        return viveros;
    }
    /**
     * Metodo que nos dice ya existe un empleado con un identificador dado.
     */
    public boolean existeEmpleadoID(Integer identificador){
        return empleados.containsKey(identificador);
    }
}

