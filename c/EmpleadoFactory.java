package VIII.patrones.factoryMethod.c;
public class EmpleadoFactory {
    private static EmpleadoFactory instance;

    private EmpleadoFactory() {};

    public static EmpleadoFactory getInstance19S(){
        if (instance == null) {
            instance = new EmpleadoFactory();
        }
        return instance;
    }

    public Empleado crearEmpleado(String codigo){
        switch (codigo) {
            case "EMP-RD":
                return new EmpleadoRelacionDependencia("Pepito","Álvarez",1,1000.0);
            case "EMP-PH":
                return new EmpleadoContratado("Lucia", "Perez", 2, 7.0, 14.0);
        }
        return null;
    }
}