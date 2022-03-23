package states;

import utilities.RobotAyuda;

public interface EstadosDelRobot {

    public void buscarEmpleado();
    public void buscarVivero();

    public void agregarEmpleado();
    public void agregarVivero();

    public void modificarEmpleado();
    public void modificarVivero();

    public void eliminarEmpleado();
    public void eliminarVivero();

    public void iniciar(String nombreArchivoE,String nombreArchivoV);
    public void terminando(String nombreArchivoE,String nombreArchivoV);

    void setRobot(RobotAyuda robot);
}
