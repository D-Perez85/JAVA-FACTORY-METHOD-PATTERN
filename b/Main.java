package VIII.patrones.factoryMethod.b;
public class Main {
    public static void main(String[] args) {
        ProductoFactory fabrica = ProductoFactory.getInstance();
        Almacen almacen = new Almacen();

        almacen.agregarProducto(fabrica.crearProducto("CAJA10X10"));
        almacen.agregarProducto(fabrica.crearProducto("PELOTAFUTBOL"));
        almacen.agregarProducto(fabrica.crearProducto("PELOTATENIS"));

        System.out.println("El total del espacio requerido en cm es: " + almacen.calculcarEspacioNecesario());

    }
}
