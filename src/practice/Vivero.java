package entities;

import exceptions.ExcepcionLineaInvalida;

import java.util.HashMap;

public class Vivero implements Comparable<Vivero>{
    private String nombre;
    private String direccion;
    private Long telefono;
    private HashMap<Integer, Empleado> empleados;
    private Integer identificador;
    public Vivero(){
        empleados = new HashMap<>();

        this.nombre = null;
        this.direccion = null;
        this.telefono = null;
        this.identificador = null;

    }
    public Vivero(String nombre, String direccion, Long telefono,
                  Integer identificador){
        empleados = new HashMap<>();

        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.identificador = identificador;

    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setTelefono(Long telefono){
        this.telefono = telefono;
    }
    public void setIdentificador(Integer identificador){
        this.identificador = identificador;
    }

    public HashMap<Integer,Empleado> getEmpleados(){
        return empleados;
    }

    public String getNombre(){
        return nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public Long getTelefono(){
        return telefono;
    }
    public Integer getIdentificador(){
        return identificador;
    }
    public void eliminarEmpleado(Integer identificador){
        try {
            empleados.remove(identificador);
        } catch (Exception e) {
            System.out.println("No hay empleado con ese ID en este vivero.");
        }
    }
    public void annadirEmpleado(Empleado empleado){
        Integer identificador = empleado.getIdentificador();
        empleados.put(identificador, empleado);
    }
    public String aLinea() {
        String linea = String.format("%s,%05d,%s,%10d\n",
                this.nombre,this.identificador,this.direccion,this.telefono);
        return linea;
    }
    public void leeLinea(String linea) {
        if (linea == null || linea.equals("")){
            throw new ExcepcionLineaInvalida();
        }

        String[] partesillas = linea.trim().split(",");
        if(partesillas.length != 4){
            throw new ExcepcionLineaInvalida();
        }
        Integer id;
        Long telefono;

        try {

            id = Integer.valueOf(partesillas[1].replaceAll(" ", ""));
            telefono = Long.valueOf(partesillas[3].replaceAll(" ", ""));

        }
        catch(NumberFormatException a){
            System.err.println(a);
            throw new ExcepcionLineaInvalida();
        }
        this.direccion = partesillas[2];
        this.nombre = partesillas[0];
        identificador = id;
        this.telefono = telefono;
    }

    @Override
    public int compareTo(Vivero arg0) {
        return this.identificador - arg0.getIdentificador();
    }
    public void actualiza(Vivero vivero){
        if(vivero == null){
            throw new IllegalArgumentException();
        }
        this.direccion = vivero.getDireccion();
        this.identificador = vivero.getIdentificador();
        this.telefono = vivero.getTelefono();
        this.nombre = vivero.getNombre();
        for(Empleado empleado: empleados.values()){
            empleado.actualizaVivero(this);
        }
    }
    public void actualizaEmpleado(Empleado empleado,Integer antiguoID){
        empleados.remove(antiguoID);
        empleados.put(empleado.getIdentificador(), empleado);
    }
    public String getEmpleadosString(){
        String empleados = "Empleados: \n";
        for (Empleado empleado : this.empleados.values()) {
            empleados += "Nombre: "+ empleado.getNombre() +" "+ empleado.getApellidoP()+" "+empleado.getApellidoM()+"\n";
            empleados += "ID: "+  String.format("%05d", empleado.getIdentificador()) + "\n";
        }
        return empleados;
    }

}
