package VIII.patrones.factoryMethod.d;
public abstract class OfertaAcademica {
    private String nombre;
    private String descripcion;

    public OfertaAcademica(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public abstract Double calcularPrecio();

    @Override
    public String toString() {
        return "Nombre: "+nombre+" Precio: $"+calcularPrecio();
    }
}
