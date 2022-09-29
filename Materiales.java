package fund2.CotizaPoli;

public abstract class Materiales {
    private String  Codigo;
    private String  Descripcion;
    private double  Precio;

    public Materiales(String codigo, String descripcion, double precio) {
        Codigo = codigo;
        Descripcion = descripcion;
        Precio = precio;
    }

    @Override
    public String toString() {
        return "Codigo='" + Codigo + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Precio=" + Precio;
    }
}
