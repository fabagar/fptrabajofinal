package Cotizacion;

public class Material {

    private String  Codigo;
    private String  Descripcion;
    private double  Precio;

    public Material(String codigo, String descripcion, double precio) {
        Codigo = codigo;
        Descripcion = descripcion;
        Precio = precio;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
          return "Codigo:" + Codigo +" "+ "Descripcion:" + Descripcion  + " Precio: S/ " + Precio + "\n";
    }
}
