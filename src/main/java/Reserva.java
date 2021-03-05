import java.util.ArrayList;
import java.util.Scanner;

public class Reserva implements  Reservable {

    Habitacion habitacion;
    Cliente cliente;
    ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public Reserva() {

    }

    public Reserva(Habitacion habitacion, Cliente cliente) {
        this.habitacion = habitacion;
        this.cliente = cliente;
    }

    @Override
    public void eliminarReserva() {
        System.out.println("La reserva fue eliminada.");
    }

    @Override
    public void reservar() {
        System.out.println("la reserva fue hecha");
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return  "Reserva " +
                "habitacion = " + habitacion +
                "cliente = " + cliente +
                "reservas = " + reservas;
    }
}