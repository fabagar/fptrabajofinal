package Cotizacion;

public class Cotizacion {

    private String  Material;
    private Integer Cantidad;

    private Double Precio;

    public Cotizacion() {
    }

    public Cotizacion(String material, Integer cantidad, Double precio) {
        Material = material;
        Cantidad = cantidad;
        Precio = precio;
    }

    @Override
    public String toString() {
        return "Cotizacion{" +
                "Material='" + Material + '\'' +
                ", Cantidad=" + Cantidad +
                ", Precio=" + Precio +
                '}';
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }
}
