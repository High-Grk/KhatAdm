import java.util.Scanner;

public class Administracion {

    Scanner teclado = new Scanner(System.in);
    int opcion;

    public void mostrar_menu(){
        System.out.println("====================================================");
        System.out.println("Khat administración");
        System.out.println("====================================================");
        System.out.println("1. Registrar Libro                                  ");
        System.out.println("2. Registrar Material (paquete)                     ");
        System.out.println("3. Ingreso personal                                 ");
        System.out.println("4. Salida personal                                  ");
        System.out.println("5. Salir                                            ");
        System.out.println("====================================================");
        opcion = teclado.nextInt();
        switch (opcion){
            case 1:
                ingresar_libro();
                break;
            case 2:

        }
    }

    public void ingresar_libro(){

    }
}
