package VIII.patrones.factoryMethod.d;
import java.util.ArrayList;
import java.util.List;

public class ProgramaIntensivo extends OfertaAcademica{
    private List<OfertaAcademica> ofertaAcademicaList;
    private Double porcentajeDescuento;

    public ProgramaIntensivo(String nombre, String descripcion, Double porcentajeDescuento) {
        super(nombre, descripcion);
        this.porcentajeDescuento = porcentajeDescuento;
        ofertaAcademicaList = new ArrayList<>();
    }
    public void agregarOferta(OfertaAcademica ofertaAcademica){
        ofertaAcademicaList.add(ofertaAcademica);
    }
    @Override
    public Double calcularPrecio() {
        Double precioTotal =0.0;
        for (OfertaAcademica ofertaAcademica : ofertaAcademicaList) {
            precioTotal += ofertaAcademica.calcularPrecio();
        }
        return precioTotal-(precioTotal*porcentajeDescuento);
    }
}
