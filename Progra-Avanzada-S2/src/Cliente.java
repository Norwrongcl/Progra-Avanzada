import java.util.ArrayList;

class Cliente {
    private String nombre;
    private int rut;
    private ArrayList<OrdenTrabajo> ordenesTrabajo;

    public Cliente(String nombre, int rut) {
        this.nombre = nombre;
        this.rut = rut;
        this.ordenesTrabajo = new ArrayList<>();
    }

    public void agregarOrdenTrabajo(OrdenTrabajo orden) {
        this.ordenesTrabajo.add(orden);
    }

    public ArrayList<OrdenTrabajo> getOrdenesTrabajo() {
        return ordenesTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRut() {
        return rut;
    }
}

