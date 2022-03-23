package utilities;

import states.EstadosDelRobot;

import java.util.Scanner;

public class RobotAyuda {
    private EstadosDelRobot estado;
    private Registros registros;

    public Registros getRegistro(){
        return registros;
    }
    public RobotAyuda(EstadosDelRobot estadoInicial){
        estado = estadoInicial;
        registros = new Registros(this);
    }

    public void cambioDeEstado(EstadosDelRobot estado){
        this.estado = estado;
    }

    /**
     * Los metodos del programa
     * Iniciar: Cargar los datos de los archivos.
     * Agregar: Crea un nuevo vivero o empleado y los agrega a los registros.
     * Eliminar: Elimina un vivero o empleado de los registros.
     * Modificar: Modifica un vivero o empleado de los registros.
     * Buscar: Busca un vivero o empleado de los registro e imprime ciertos datos de estos.
     * Terminar:Guarda los datos de los registros a los archivos
     */
    public void iniciar(String nombreArchivoE,String nombreArchivoV){
        estado.iniciar(nombreArchivoE, nombreArchivoV);;
    }
    public void agregar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Desea agregar un empleado o un vivero (E/V): ");
        String opcion = sc.nextLine();
        if(opcion.equals("E")){
            estado.agregarEmpleado();
            return;
        }
        if(opcion.equals("V")){
            estado.agregarVivero();
            return;
        }
        System.out.println("Escriba solo E o V para eligir su opcion");
        this.agregar();
    }
    public void eliminar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Desea eliminar un empleado o un vivero (E/V): ");
        String opcion = sc.nextLine();
        if(opcion.equals("E")){
            estado.eliminarEmpleado();
            return;
        }
        if(opcion.equals("V")){
            estado.eliminarVivero();
            return;
        }
        System.out.println("Escriba solo E o V para eligir su opcion");
        this.eliminar();
    }
    public void modificar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Desea modificar un empleado o un vivero (E/V): ");
        String opcion = sc.nextLine();
        if(opcion.equals("E")){
            estado.modificarEmpleado();
            return;
        }
        if(opcion.equals("V")){
            estado.modificarVivero();
            return;
        }
        System.out.println("Escriba solo E o V para eligir su opcion");
        this.modificar();

    }
    public void buscar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Desea buscar un empleado o un vivero (E/V): ");
        String opcion = sc.nextLine();
        if(opcion.equals("E")){
            estado.buscarEmpleado();
            return;
        }
        if(opcion.equals("V")){
            estado.buscarVivero();
            return;
        }
        System.out.println("Escriba solo E o V para eligir su opcion");
        this.buscar();

    }
    public void terminar(String nombreArchivoE, String nombreArchivoV ){
        estado.terminando(nombreArchivoE, nombreArchivoV);
    }
    /**
     * Metodos para que las demas clases no accedan directamente a los registros muy seguido.
     */
    public String getViveroStringID(){
        return registros.getViverosStringID();
    }
    public String getViverosStringDireccion(){
        return registros.getViverosStringDireccion();
    }
    public String getEmpleadoString(){
        return registros.getEmpleadosString();
    }
    public boolean existeEmpConID(Integer id){
        for(Integer i: registros.getRegistrosDeEmpleados().keySet()){
            System.out.println(i);
        }
        return registros.getRegistrosDeEmpleados().containsKey(id);
    }
    public boolean existeVivConID(Integer id){
        return registros.getRegistrosDeViveros().containsKey(id);
    }


}
