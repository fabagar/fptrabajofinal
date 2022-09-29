package fund2.CotizaPoli;

public class MatRed extends Materiales {
    private String tipo;
    private double extraPrecio;

    public MatRed(String codigo, String descripcion, double precio, String tipo, double extraPrecio) {
        super(codigo, descripcion, precio);
        this.tipo = tipo;
        this.extraPrecio = extraPrecio;
    }

    @Override
    public String toString() {
        return "MatRed{" + super.toString()+
                " tipo='" + tipo + '\'' +
                ", extraPrecio=" + extraPrecio +
                '}';
    }
}
