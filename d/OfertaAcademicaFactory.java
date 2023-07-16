package VIII.patrones.factoryMethod.d;
public class OfertaAcademicaFactory {
    private static OfertaAcademicaFactory instance;

    private OfertaAcademicaFactory(){

    }
    public static OfertaAcademicaFactory getInstance() {
        if (instance==null){
            instance = new OfertaAcademicaFactory();
        }
        return instance;
    }
    public OfertaAcademica crearOfertaAcademica(String codigo){
        switch (codigo){
            case "FRONTEND":
                return new Curso("Front-end","Javascript",16.0,1000.0,2.0);
            case "BACKEND":
                return new Curso("Back-end","Java",20.0,900.0,2.0);
            case "FULLSTACK":
                ProgramaIntensivo programaIntensivo = new ProgramaIntensivo("Full-Stack","Completo",0.20);
                programaIntensivo.agregarOferta(crearOfertaAcademica("FRONTEND"));
                programaIntensivo.agregarOferta(crearOfertaAcademica("BACKEND"));
                return programaIntensivo;
        }
        return null;
    }
}
