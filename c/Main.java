package VIII.patrones.factoryMethod.c;

public class Main {
    public static void main(String[] args) {
    Empresa empresa = new Empresa("Acustermic");

    EmpleadoFactory fabrica = EmpleadoFactory.getInstance19S();

    empresa.agregarEmpleado(fabrica.crearEmpleado("EMP-RD"));
    empresa.agregarEmpleado(fabrica.crearEmpleado("EMP-PH"));
    empresa.agregarEmpleado(fabrica.crearEmpleado("EMP-PH"));

    System.out.println("El total de sueldo de la empresa en dolares es " + empresa.calcularSueldosTotal(30));
}
}
