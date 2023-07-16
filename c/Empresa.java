package VIII.patrones.factoryMethod.c;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String razonSocial;
    private List<Empleado> empleadoList;

    public Empresa(String razonSocial) {
        this.razonSocial = razonSocial;
        empleadoList = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleadoList.add(empleado);
    }

    public Double calcularSueldosTotal(int dias) {
        double sueldoTotal = 0;
        for (Empleado empleado : empleadoList) {
            sueldoTotal += empleado.calcularSueldo(dias);
        }
        return sueldoTotal;
    }
}