package VIII.patrones.factoryMethod.b;
public class Caja extends Producto{
    private Double altura;
    private Double longitud;
    private Double ancho;

    public Caja(Double peso, Double altura, Double longitud, Double ancho) {
        super(peso);
        this.altura = altura;
        this.longitud = longitud;
        this.ancho = ancho;
    }
    @Override
    public Double calcularEspacio() {
        return ancho*altura*longitud;
    }
}
