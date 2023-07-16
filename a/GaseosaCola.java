package VIII.patrones.factoryMethod.a;
/*Clase del producto concreto que hereda de la abstracta*/
public class GaseosaCola extends Gaseosa {
    String nombre = "Coca Cool";
    Double precio = 2.00;

    @Override
    public String getNombre() { return nombre;}
    @Override
    public Double getPrecio() { return precio;}
    @Override
    public void abrir() {
        super.abrir();
    }
}
