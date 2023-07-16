package VIII.patrones.factoryMethod.d;
public class Curso extends OfertaAcademica{
    private Double horasMensuales;
    private Double valorPorHora;
    private Double duracionMeses;
    public Curso(String nombre, String descripcion, Double horasMensuales, Double valorPorHora, Double duracionMeses) {
        super(nombre, descripcion);
        this.horasMensuales = horasMensuales;
        this.valorPorHora = valorPorHora;
        this.duracionMeses = duracionMeses;
    }
    @Override
    public Double calcularPrecio() {
        return horasMensuales * valorPorHora * duracionMeses;
    }
}
