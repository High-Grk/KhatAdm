import java.util.ArrayList;

public class Habitacion {

    private int id;
    private Cliente cliente;
    private boolean disponibilidad;


    public Habitacion(int id) {
        this.id = id;
        this.disponibilidad = true;
    }


    public boolean isDisponibilidad() {

        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String validacionDisponibilidad(){
        String texto;
        if (isDisponibilidad()){
            texto = "Se encuentra disponible.";
        }else{
            texto = "No disponible.";
        }
        return texto;
    }

    @Override
    public String toString() {
        return "Habitacion "+(id+1)+ ", disponibilidad: "+validacionDisponibilidad();
    }

}

