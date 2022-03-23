package entities;

import exceptions.ExcepcionLineaInvalida;
import utilities.Registros;

public class Empleado implements Comparable<Empleado>{
    private Integer identificador;
    private String nombres;
    private String apellidoP;
    private String apellidoM;
    private Long telefono;
    private Double salario;
    private String puesto;
    private Vivero vivero;
    private Integer viveroID;

    public Empleado(){
        this.apellidoM = null;
        this.apellidoP = null;
        this.identificador = null;
        this. nombres = null;
        this.telefono = null;
        this.salario = null;
        this.puesto = null;
        this.vivero = null;
        viveroID = null;
    }
    public Empleado(Integer identificador,
                    String nombre, String apellidoP, String apellidoM, Long telefono,
                    Double salario, Vivero vivero, String puesto){
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
        this.identificador = identificador;
        this. nombres = nombre;
        this.telefono = telefono;
        this.salario = salario;
        this.puesto = puesto;
        this.vivero = vivero;
        viveroID = vivero.getIdentificador();
    }
    /**
     * Getters y setters de los datos del empleado.
     */
    public Integer getViveroID(){
        return viveroID;
    }
    public void setViveroID(Integer viveroID){
        this.viveroID = viveroID;
    }
    public void setIdentificador(Integer identificador){
        this.identificador = identificador;
    }
    public void setNombre(String nombre){
        this.nombres = nombre;
    }
    public void setApellidoP(String apellido){
        this.apellidoP = apellido;
    }
    public void setApellidoM(String apellido){
        this.apellidoM = apellido;
    }
    public void setSalario(Double salario){
        this.salario = salario;
    }
    public void setPuesto(String puesto){
        this.puesto = puesto;
    }
    public void setTelefono(Long telefono){
        this.telefono = telefono;
    }
    public void designarVivero(Vivero vivero){
        this.vivero = vivero;
    }
    public Double getSalario(){
        return salario;
    }
    public String getPuesto(){
        return puesto;
    }
    public Vivero getVivero(){
        return vivero;
    }
    public Long getTelefono(){
        return telefono;
    }
    public String getNombre(){
        return nombres;
    }
    public String getApellidoP(){
        return apellidoP;
    }
    public String getApellidoM(){
        return apellidoM;
    }
    public Integer getIdentificador(){
        return identificador;
    }
    /**
     * Metodo para actualizar los datos del empleado.
     */
    public void actualiza(Empleado empleado){
        if(empleado == null){
            throw new IllegalArgumentException("");
        }
        Integer antiguoID = identificador;
        this.identificador = empleado.getIdentificador();
        this.nombres = empleado.getNombre();
        this.puesto = empleado.getPuesto();
        this.salario = empleado.getSalario();
        this.telefono = empleado.getTelefono();
        this.apellidoM = empleado.getApellidoM();
        this.apellidoP = empleado.getApellidoP();
        vivero.actualizaEmpleado(this, antiguoID);
    }
    /**
     * Metodo para actualizar el vivero del empleado.
     */
    public void actualizaVivero(Vivero vivero){
        this.vivero = vivero;
        viveroID = vivero.getIdentificador();
    }
    /**
     * Metodo para crear la cadena con la inf del empleado para cargarlo al archivo.
     */
    public String aLinea() {

        String linea = String.format("%s, %s, %s, %05d, %s, %s, %05d, %7.2f, %10d\n",
                this.nombres, this.apellidoP, this.apellidoM, this.identificador,
                this.puesto,this.vivero.getNombre(),
                this.viveroID,this.salario,this.telefono);
        return linea;
    }
    /**
     * Metodo para leer los datos del empleado de la cadena tomado del archivo.
     */
    public void leeLinea(String linea, Registros registros) {
        if (linea == null || linea.equals("")){
            throw new ExcepcionLineaInvalida();
        }
        String[] partesillas = linea.trim().split(",");
        if(partesillas.length != 9){
            throw new ExcepcionLineaInvalida();
        }

        Integer id;
        Long telefono;
        double salario;
        Integer vID;
        try {
            vID = Integer.valueOf(partesillas[6].replaceAll(" ",""));
        } catch (NumberFormatException e) {
            throw new ExcepcionLineaInvalida();
        }
        Vivero vi = registros.busquedaV(vID);
        if(vi == null ){
            throw new NullPointerException();
        }
        try {
            id = Integer.valueOf(partesillas[3].replaceAll(" ",""));
            salario = Double.valueOf(partesillas[7].replaceAll(" ",""));
            telefono = Long.valueOf(partesillas[8].replaceAll(" ",""));

        }
        catch(NumberFormatException a){
            throw new ExcepcionLineaInvalida();
        }
        this.apellidoM = partesillas[2];
        this.apellidoP = partesillas[1];
        viveroID = vID;
        this.vivero = vi;
        nombres = partesillas[0];
        identificador = id;
        this.salario = salario;
        this.telefono = telefono;
        this.puesto = partesillas[4];
    }
    @Override
    public int compareTo(Empleado empleado) {
        return (this.identificador - empleado.getIdentificador());
    }


}
