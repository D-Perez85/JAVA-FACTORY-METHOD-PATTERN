package VIII.patrones.factoryMethod.c;
public class EmpleadoRelacionDependencia extends Empleado {
    private Double sueldoMensual;
    public EmpleadoRelacionDependencia(String nombre, String apellido, Integer legajo, Double sueldoMensual) {
        super(nombre, apellido, legajo);
        this.sueldoMensual = sueldoMensual;
    }
    @Override
    public Double calcularSueldo(int dias) {
        double sueldo = 0;
        if (dias >= 0) {
            sueldo = sueldoMensual * dias / 30;
        } else {
            sueldo = 0;
        };
        return sueldo;
    }


}