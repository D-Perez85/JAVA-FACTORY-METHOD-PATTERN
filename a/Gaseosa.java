package VIII.patrones.factoryMethod.a;
/*Clase abstracta de la que herederán los productos concretos*/
public abstract class Gaseosa {
    private  String nombre;
    private Double precio;

    public String getNombre(){
        return nombre;
    }
    public Double getPrecio() {
        return precio;
    }

    /*método muestra mensaje concatenando el nombre de la gaseosa*/
    public void abrir(){
        System.out.println("Por " + getPrecio() + " dolares abriste una gaseosa de " + getNombre() + "!.");
    }
}
