package VIII.patrones.factoryMethod.a;
/*Clase del producto concreto que hereda de la abstracta*/
public class GaseosaNaranja extends Gaseosa{
    String nombre = "Naranja dulce";
    Double precio = 1.57;

    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public Double getPrecio(){
        return precio;
    }
    @Override
    public void abrir() {
        super.abrir();
    }
}
