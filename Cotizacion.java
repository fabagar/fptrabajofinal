package fund2.CotizaPoli;

import java.util.ArrayList;
import java.util.List;

public class Cotizacion {
    private List<Materiales> listamateriales;
    private List<Usuario> listausuarios;

    public Cotizacion(){

        listamateriales= new ArrayList<>();
        listausuarios= new ArrayList<>();
    }
    public void agregarMaterial(Materiales a) {
        listamateriales.add(a);
    }
    public void agregarUsuario(Usuario u){listausuarios.add(u);}

    public void listarMateriales(){
        for (Materiales t : listamateriales){
            System.out.println(t);
        }
    }
    public boolean listaUsusarios(String user, String password) {
        for (Usuario u : listausuarios){
            if (u.getUsuario().equals(user) && u.getContrasena().equals(password)){
                return true;
            }
        }
        return false;
    }






}
