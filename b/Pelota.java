package VIII.patrones.factoryMethod.b;
public class Pelota extends Producto{
    private Double radio;
    public Pelota(Double peso, Double radio) {
        super(peso);
        this.radio = radio;
    }
    @Override
    public Double calcularEspacio() {
        return (4/3)* Math.PI * Math.pow(radio,3);
    }
}
