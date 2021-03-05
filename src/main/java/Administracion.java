import java.util.ArrayList;
import java.util.Scanner;


public class Administracion {

    Scanner teclado = new Scanner(System.in);
    int opcion;
    ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
    ArrayList<Cliente>clientes = new ArrayList<Cliente>();
    int cantidad_habitacion;

    Reserva r1 = new Reserva();


    public void mostrarMenu(){
        System.out.println("¿Cuántas habitaciones requiere el hotel?");
        cantidad_habitacion = teclado.nextInt();
        while (cantidad_habitacion<0 || cantidad_habitacion>50){
            System.out.println("Ingrese un valor válido. ");
            cantidad_habitacion = teclado.nextInt();
        }
        for (int i=0; i<cantidad_habitacion; i++){
            habitaciones.add(new Habitacion(i));
        }
        do {
            System.out.println("\n");
            System.out.println("====================================================");
            System.out.println("                      Menu                          ");
            System.out.println("====================================================");
            System.out.println("1. Ver habitaciones disponibles                     ");
            System.out.println("2. Reservar habitación                              ");
            System.out.println("3. Eliminar reserva                                 ");
            System.out.println("4. Mostrar lista de clientes                        ");
            System.out.println("5. Salir                                            ");
            System.out.println("====================================================");
            System.out.println("");

            System.out.print("Ingrese una opcion: ");
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    verHabitacionesDisponibles(habitaciones);
                    break;
                case 2:
                    int habitacion = validacionHabitacion("Reservar");
                    if (habitaciones.get(habitacion).isDisponibilidad()){
                        realizarReserva(habitaciones, clientes, habitacion);
                        int opServicio = validacionServicio();
                        switch (opServicio){
                            case 1:
                                clientes.get(clientes.size()-1).setServicio(ServiciosTipo.ALIMENTACION);
                                break;
                            case 2:
                                clientes.get(clientes.size()-1).setServicio(ServiciosTipo.LIMPIEZA);
                                break;
                            case 3:
                                clientes.get(clientes.size()-1).setServicio(ServiciosTipo.LAVANDERIA);
                                break;
                            case 4:
                                clientes.get(clientes.size()-1).setServicio(ServiciosTipo.BASICO);
                                break;
                        }
                    }else{
                        System.out.println("La habitación se encuentra ocupoada.");
                        System.out.println("Se te reedigirirá al menú principal.");
                    }
                    break;
                case 3:
                    int habitacionEliminar = validacionHabitacion("Eliminar");
                    if (!habitaciones.get(habitacionEliminar).isDisponibilidad()){
                        eliminarReserva(habitaciones, clientes, habitacionEliminar);
                    }else{
                        System.out.println("La habitación ya está vacía.");
                        System.out.println("Se te reedigirirá al menú principal.");
                    }
                    break;
                case 4:
                    mostrarListaCliente(clientes);
                    break;
                case 5:

                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida, serás reedirigido al menu.");
            }

        }
        while (opcion!=8);

    }

    private int validacionHabitacion(String texto) {
        System.out.println("¿Qué número de habitación desea "+texto+"?");
        int num_habitacion = teclado.nextInt();
        while (num_habitacion<0 || num_habitacion>cantidad_habitacion){
            System.out.println("El numero de habitación no existe.");
            num_habitacion = teclado.nextInt();
        }
        return num_habitacion-1;
    }


    public void verHabitacionesDisponibles(ArrayList<Habitacion>habitaciones){

        // como caso de prueba usamos un hotel que tiene una cantidad determinada de habitaciones

        System.out.println("==========Lista de habitaciones disponibles=========");
        for (int i=0; i<cantidad_habitacion; i++){
            System.out.println(habitaciones.get(i).toString());
        }
        System.out.println("====================================================");
    }

    public void realizarReserva(ArrayList<Habitacion> habitaciones,ArrayList<Cliente>clientes, int habitacion){

        String telefono, direccion, nombre;
        Scanner teclado = new Scanner(System.in);
        System.out.println("=============Ingrese datos del cliente==============");
        do {
            System.out.println("Ingrese su telefono anteponiendo el 9");
            telefono = teclado.next();
        } while (telefono.matches("9[0-9]{9,9}")); //validación
        System.out.println("Ingrese su dirección");
        direccion = teclado.next();
        System.out.println("Ingrese su nombre");
        nombre = teclado.next();


        clientes.add(new Cliente(clientes.size(), telefono, direccion, nombre, habitaciones.get(habitacion)));
        habitaciones.get(habitacion).setDisponibilidad(false);
        //habitaciones.get(habitacion).setCliente(clientes.get());

        System.out.println("====================================================");


    }
    public int validacionServicio (){
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Desea añadir un servicio? 1. Si 2. No");
        int opcionServicio;
        int op = teclado.nextInt();
        while (op<0 || op>2){
            System.out.println("Opcion inválida, intente nuevamente.");
            op = teclado.nextInt();
        }if (op==1){
            System.out.println("---------Seleccione un servicio----------");
            System.out.println("1. Alimentación.");
            System.out.println("2. Limpieza.");
            System.out.println("3. Lavanderia.");
            opcionServicio = teclado.nextInt();
            while (opcionServicio<1 || opcionServicio>3){
                System.out.println("Opción inválida. Vuelva a intentarlo.");
                opcionServicio = teclado.nextInt();
            }
        }else{
            opcionServicio = 4;
        }
        return opcionServicio;
    }

    public int validarEliminacion(){
        System.out.println("¿Qué número de habitación desea eliminar?");
        int num_habitacion = teclado.nextInt();
        while (num_habitacion<0 || num_habitacion>cantidad_habitacion){
            System.out.println("El numero de habitación no existe.");
            num_habitacion = teclado.nextInt();
        }
        return num_habitacion;
    }

    public void eliminarReserva(ArrayList<Habitacion> habitaciones, ArrayList<Cliente> clientes, int habitacionEliminar){
        System.out.println("====================================================");
        String telefono, direccion, nombre;
        Scanner teclado = new Scanner(System.in);

        try{
            clientes.remove(habitaciones.get(habitacionEliminar).getCliente());
            habitaciones.get(habitacionEliminar).setCliente(null);
            System.out.println("La reserva se ha eliminado con exito.");
            habitaciones.get(habitacionEliminar).setDisponibilidad(true);
        }catch(Exception e){

            System.out.println("Eliminación no posible.");
        }

    }

    public void mostrarListaCliente(ArrayList<Cliente> cliente){
        System.out.println("===============Lista de clientes====================");
        for (int i=0; i<cliente.size(); i++){
            String clienteAux = cliente.toString();
            System.out.println(clienteAux);
        }
        System.out.println("====================================================");
    }

    public void calcularEstadia(){

    }



}