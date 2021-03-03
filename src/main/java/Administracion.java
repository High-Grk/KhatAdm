import java.util.ArrayList;
import java.util.Scanner;

public class Administracion {

    Scanner teclado = new Scanner(System.in);
    ArrayList<String> libros = new ArrayList<String>();
    ArrayList<String> materiales = new ArrayList<String>();
    int opcion;

    public void mostrar_menu(){
        do {
            System.out.println("====================================================");
            System.out.println(               "Khat administración                  ");
            System.out.println("====================================================");
            System.out.println("1. Registrar Libro                                  ");
            System.out.println("2. Registrar Material (paquete)                     ");
            System.out.println("3. Mostrar lista de libros                          ");
            System.out.println("4. Ingreso personal                                 ");
            System.out.println("5. Salida personal                                  ");
            System.out.println("6. Salir                                            ");
            System.out.println("====================================================");
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    registrar_libro();
                    mostrar_menu();
                    break;
                case 2:
                    break;
                case 3:
                    lista_libros();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
        while(opcion!=5);

    }

    public void registrar_libro(){
        String nro_serie;
        System.out.println("================Registro de libros==================");
        System.out.println("Ingrese el numero de serie:");
        nro_serie = teclado.next();
        libros.add(nro_serie);
        System.out.println("====================================================");

    }

    public void registrar_material(){
        String nro_paquete;
        System.out.println("================Registro de libros==================");
        System.out.println("Ingrese el numero de serie:");
        nro_paquete = teclado.next();
        materiales.add(nro_paquete);
        System.out.println("====================================================");
    }

    public void lista_libros() {
        System.out.println("==================Lista de libros===================");
        for(int i = 0; i < libros.size(); i++){
            System.out.print(libros.get(i));
            System.out.println("\n");
        }
        System.out.println("====================================================");
    }



}
