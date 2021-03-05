public enum ServiciosTipo {
    ALIMENTACION("Alimentación"),
    LIMPIEZA("Limpieza"),
    LAVANDERIA("Lavandería"),
    BASICO("Básico");

    private final String tipo;

    ServiciosTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }
}