import javax.sound.midi.Soundbank;
import java.awt.event.HierarchyBoundsAdapter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;
    private ServiciosTipo servicio;
    ArrayList<Habitacion> reservas = new ArrayList<Habitacion>();


    public Cliente(int id, String telefono, String direccion, String nombre, Habitacion habitacion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.reservas.add(habitacion);
    }
    public Cliente(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ServiciosTipo getServicio() {
        return servicio;
    }

    public void setServicio(ServiciosTipo servicio) {
        this.servicio = servicio;
    }

    public ArrayList<Habitacion> getReservas() {
        return reservas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String texto = ""+
                "\n Nombre: "+this.nombre+
                "\n Direccion: "+this.direccion+
                "\n Telefono: "+this.telefono;
        return texto;
    }
}
