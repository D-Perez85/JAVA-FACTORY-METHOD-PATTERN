package VIII.patrones.factoryMethod.c;

public class EmpleadoContratado extends Empleado {
    private Double importePorHora;
    private Double retencionImpuesto;

    public EmpleadoContratado(String nombre, String apellido, Integer legajo, Double importePorHora, Double retencionImpuesto) {
        super(nombre, apellido, legajo);
        this.importePorHora = importePorHora;
        this.retencionImpuesto = retencionImpuesto;
    }

    @Override
    public Double calcularSueldo(int dias) {
        double sueldo = importePorHora * 8 * dias;
        double impuesto = sueldo * retencionImpuesto / 100;
        if (dias >= 0) {
            sueldo -= impuesto;
        } else {
            sueldo = 0;
        }
        ;
        return sueldo;
    }
}