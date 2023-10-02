import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class OrdenTrabajo {
    private String descripcion;
    private boolean resuelto;

    public OrdenTrabajo(String descripcion) {
        this.descripcion = descripcion;
        this.resuelto = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isResuelto() {
        return resuelto;
    }

    public void marcarComoResuelto() {
        this.resuelto = true;
    }
    public void setDescripcion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }
    
    public void marcarComoNoResuelto() {
        this.resuelto = false;
    }
}
