package Cotizacion;

public class Usuarios {
    private String  Cuenta;
    private String  Password;

    public String getCuenta() {
        return Cuenta;
    }

    public void setCuenta(String cuenta) {
        Cuenta = cuenta;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Usuarios(String cuenta, String password) {
        Cuenta = cuenta;
        Password = password;
    }
}
