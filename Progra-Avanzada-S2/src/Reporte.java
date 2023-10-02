import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Reporte {
    public void generar(GestionClientes gestion) {
        // Genera un reporte básico
        System.out.println("Generando reporte básico...");
        gestion.mostrarClientes();
    }

    public void generar(GestionClientes gestion, boolean mostrarDetalles) {
        // Genera un reporte detallado si mostrarDetalles es true
        System.out.println("Generando reporte " + (mostrarDetalles ? "detallado" : "básico") + "...");
        gestion.mostrarClientes();
        if (mostrarDetalles) {
            // Lógica adicional para mostrar detalles
        }
    }
}
