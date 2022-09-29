package fund2.CotizaPoli;

public class Cotizar {
    private static String  Material;
    private static Integer Cantidad;
    private static Double Precio;


    public Cotizar(String material, Integer cantidad, Double precio) {
        Material = material;
        Cantidad = cantidad;
        Precio = precio;
    }

    public Cotizar() {

    }

    @Override
    public String toString() {
        return "Cotizar{" +
                "Material='" + Material + '\'' +
                ", Cantidad=" + Cantidad +
                ", Precio=" + Precio +
                '}';
    }

    public String getMaterial() {
        return Material;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public Double getPrecio() {
        return Precio;
    }

    public static void setMaterial(String material) {
        Material = material;
    }

    public static void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }

    public static void setPrecio(Double precio) {
        Precio = precio;
    }
}
