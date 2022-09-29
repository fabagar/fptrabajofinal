package fund2.CotizaPoli;

import fund2.EjercicioExcepcion.Empresa;
import fund2.EjercicioExcepcion.ExcepcionDniDuplicado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejecutora {
    static List<Cotizar> cotizacionList = new ArrayList<Cotizar>();
    public static void Menu(){
        int opcion;
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        do {


            System.out.println("\n\nIntroduzca la opción que desea realizar:\n"
                    + "1. Listar Materiales\n" + "2. Ingresar Cotización\n"
                    + "3. Detalle Cotización\n"
                    + "SALIR --> Pulse cualquier otro número\n");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    listarMaterial();
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
    public static void listarMaterial() {
        Cotizacion cot = new Cotizacion();
        cot.agregarMaterial(new MatRed("101001", "Cable", 2.5, "Material", 0.3));
        cot.agregarMaterial(new MatRed("101002", "Canaleta", 6, "Material", 1.15));
        cot.agregarMaterial(new MatRed("101003", "Tubo", 7, "Material", 1.3));
        cot.agregarMaterial(new MatHerramienta("201001", "Coaxial", 5, "Herramienta", 1));
        cot.agregarMaterial(new MatHerramienta("201002", "Fibra", 15, "Herramienta", 0.5));



        System.out.println("############################################");
        System.out.println("######  Listado de Materiales      #########");
        System.out.println("############################################");
        cot.listarMateriales();
        System.out.println("############################################");
    }
    public static double calculaTotal(List<Cotizar> cotizacionList) {
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

    public static void listar(List<Cotizar> cotizacionList) {
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

    public static void ingresaDatos() {
        String material;
        String resp;
        int cantItem;
        Double precioProducto;
        Cotizar cotizacion = new Cotizar() ;

        Scanner dato1 = new Scanner(System.in);
        //System.out.println("Ingrese Empresa:");
        System.out.println("###############################");
        System.out.println("Ingrese los Productos a Comprar:");
        System.out.println("###############################");
        System.out.print("Ingrese tipo de material:");
        material = dato1.next();
        System.out.print("Ingrese la cantidad en metros:");
        cantItem = dato1.nextInt();
        Cotizar.setMaterial(material);
        Cotizar.setCantidad(cantItem);
        precioProducto = ObtenerPrecio(material,cantItem);
        Cotizar.setPrecio(precioProducto);
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
    public static List<Cotizar> cargaLista(Cotizar cotizacion) {
        cotizacionList.add(cotizacion);
        return cotizacionList;
    }
    public static void main(String[] args) {
        Cotizacion cot = new Cotizacion();

        cot.agregarUsuario(new Usuario("admin","admin"));


        //cot.listarMateriales();

        String usuario;
        String clave;
        Scanner sc = new Scanner(System.in);
        System.out.print ("Introduzca el nombre de usuario:");
        usuario=sc.next();
        System.out.print ("Introduzca la contraseña:");
        clave=sc.next();

        try {
            if (cot.listaUsusarios(usuario, clave)==true){
                Menu();
            } else {
                throw new ExcepcionUsuarionoEncontrado("El usuario: "+ usuario + " no existe o la contraseña es erronea");
            }
        } catch (ExcepcionUsuarionoEncontrado e){
            System.out.println(e.getMessage());
        }

    }



}
