package fund2.CotizaPoli;

public class MatHerramienta extends Materiales {
    private String tipo;
    private double extraPrecio;

    public MatHerramienta(String codigo, String descripcion, double precio, String tipo, double extraPrecio) {
        super(codigo, descripcion, precio);
        this.tipo = tipo;
        this.extraPrecio = extraPrecio;
    }

    @Override
    public String toString() {
        return "MatHerramienta{" + super.toString()+
                " tipo='" + tipo + '\'' +
                ", extraPrecio=" + extraPrecio +
                '}';
    }
}
