package Cotizacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GestionCotizacion {
    static List<Material> materialList = new ArrayList<Material>();
    static List<Cotizacion> cotizacionList = new ArrayList<Cotizacion>();

    static List<Usuarios> usuarioList = new ArrayList<Usuarios>();
    public static void cargarMaterial() {
          //Seteo de valores a la clase generada
            Material obj1 = new Material("001", "Coaxial", 5);
            Material obj2 = new Material("002", "Fibra",15);
            Material obj3 = new Material("003", "Tubo",7);
            Material obj4 = new Material("004", "Canaleta",6);
            Material obj5 = new Material("005", "Cable",2.5);
            materialList.add(obj1);
            materialList.add(obj2);
            materialList.add(obj3);
            materialList.add(obj4);
            materialList.add(obj5);
     }

    public static void cargarUsusarios() {
        //Seteo de valores a la clase generada
        Usuarios obj1 = new Usuarios("Admin", "12345");
        Usuarios obj2 = new Usuarios("Usuario", "123456");
        usuarioList.add(obj1);
        usuarioList.add(obj2);
    }

    public static String ObtienePassword(List<Usuarios> usuarioList) {
        String Password="";
        for (int i = 0; i < usuarioList.size(); i++){

            if (usuarioList.get(i).getCuenta().equals("Admin")) {
                Password= usuarioList.get(i).getPassword();
            } else if (cotizacionList.get(i).getMaterial().equals("Usuario")) {
                Password= usuarioList.get(i).getPassword();

            }

        }
        return Password;
    }



    public static void listarMaterial(List<Material>  materialList) {
        System.out.println("############################################");
        System.out.println("######  Listado de Materiales      #########");
        System.out.println("############################################");
        for (int i = 0; i < materialList.size(); i++) {
            System.out.print(materialList.get(i));
        }
        System.out.println("############################################");
    }


    public static void listar(List<Cotizacion> cotizacionList) {
        Double totalCotizacion,ganancia,igv,total;
        for (int i = 0; i < cotizacionList.size(); i++) {

        System.out.print("Producto: " + cotizacionList.get(i).getMaterial() +" "+ "Cantidad: " + cotizacionList.get(i).getCantidad() +" "+ "Precio: " + cotizacionList.get(i).getPrecio() + "\n");

        }
        total=calculaTotal(cotizacionList);
        System.out.println("************************************************************");
        ganancia=total * 0.3;
        igv= ((total + ganancia) * 0.18);
        totalCotizacion = total + ganancia + igv;
        double totalManodeObra = totalCotizacion - total;
        System.out.printf("Mano de obra: S/ %.2f", totalManodeObra);
        System.out.println("");
        System.out.println("************************************************************");
        System.out.print("Monto total de la Cotización S/: " + totalCotizacion);
    }

    public static double calculaTotal(List<Cotizacion> cotizacionList) {
        double total=0.0,totalgeneral=0.0;
        for (int i = 0; i < cotizacionList.size(); i++){

            if (cotizacionList.get(i).getMaterial().equals("Cable")) {
                total= cotizacionList.get(i).getCantidad() * 2.5;
            } else if (cotizacionList.get(i).getMaterial().equals("Canaleta")) {
                total= cotizacionList.get(i).getCantidad() * 6;
            } else if (cotizacionList.get(i).getMaterial().equals("Tubo")) {
                total= cotizacionList.get(i).getCantidad() * 7;
            } else if (cotizacionList.get(i).getMaterial().equals("Coaxial")) {
                total= cotizacionList.get(i).getCantidad() * 5;
            } else if (cotizacionList.get(i).getMaterial().equals("Fibra")) {
                total= cotizacionList.get(i).getCantidad() * 15;
            }
             totalgeneral=totalgeneral+total;
        }
        return totalgeneral;
    }

    public static double ObtenerPrecio ( String material,Integer cantidad) {
        double total=0.0;
        if (material.equals("Cable")) {
            total= cantidad * 2.5;
        } else if (material.equals("Canaleta")) {
            total= cantidad * 6;
        } else if (material.equals("Tubo")) {
            total= cantidad * 7;
        } else if (material.equals("Coaxial")) {
            total= cantidad * 5;
        } else if (material.equals("Fibra")) {
            total= cantidad * 15;
        }

      return total;

    }

    public static void ingresaDatos() {
        String material, resp;
        Integer cantidad, cantItem;
        Double precioProducto;
        Cotizacion cotizacion = new Cotizacion() ;

        Scanner dato1 = new Scanner(System.in);
        //System.out.println("Ingrese Empresa:");
        System.out.println("###############################");
        System.out.println("Ingrese los Productos a Comprar:");
        System.out.println("###############################");
        System.out.print("Ingrese tipo de material:");
        material = dato1.next();
        System.out.print("Ingrese la cantidad en metros:");
        cantItem = dato1.nextInt();
        cotizacion.setMaterial(material);
        cotizacion.setCantidad(cantItem);
        precioProducto = ObtenerPrecio(material,cantItem);
        cotizacion.setPrecio(precioProducto);
        cargaLista(cotizacion);

        System.out.println("¿Desea ingresar más Productos?(S/N):");
        resp = dato1.next();

        if(resp.equals("S")){
            ingresaDatos();
        }
        else{
            listar(cotizacionList);
        }
    }

    public static List<Cotizacion> cargaLista(Cotizacion cotizacion) {
        cotizacionList.add(cotizacion);
        return cotizacionList;
    }

    public static void Menu(){
        int opcion;
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        cargarMaterial();
        do {


            System.out.println("\n\nIntroduzca la opción que desea realizar:\n"
                    + "1. Listar Materiales\n" + "2. Ingresar Cotización\n"
                    + "3. Detalle Cotización\n"
                    + "SALIR --> Pulse cualquier otro número\n");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    listarMaterial(materialList);
                    break;
                case 2:
                    ingresaDatos();
                    break;
                case 3:
                    listar(cotizacionList);
                    break;
                default:
                    // Se sale del programa

                    continuar = false;
            }

        } while (continuar);
        System.out.println("---- Gracias por usar la aplicación. ----");


    }







    public static void main(String[] args) {

        String usuario,clave;
        Scanner sc = new Scanner(System.in);
        System.out.print ("Introduzca el nombre de usuario:");
        usuario=sc.next();
        System.out.print ("Introduzca la contraseña:");
        clave=sc.next();

        if (usuario.equals("Admin")&& clave.equals("123456")){
            Menu();
        }else{
            System.out.print ("¡El nombre de usuario y la clave no coinciden! No tiene Acceso para el modulo");

        }





    }

    }




