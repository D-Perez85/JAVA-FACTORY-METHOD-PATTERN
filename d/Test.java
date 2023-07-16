package VIII.patrones.factoryMethod.d;
public class Test {
    public static void main(String[] args) {
        Instituto instituto = new Instituto();

        OfertaAcademicaFactory ofertaAcademicaFactory = OfertaAcademicaFactory.getInstance();

        instituto.agregarOferta(ofertaAcademicaFactory.crearOfertaAcademica("FRONTEND"));
        instituto.agregarOferta(ofertaAcademicaFactory.crearOfertaAcademica("BACKEND"));
        instituto.agregarOferta(ofertaAcademicaFactory.crearOfertaAcademica("FULLSTACK"));

        instituto.generarInforme();
    }
}
