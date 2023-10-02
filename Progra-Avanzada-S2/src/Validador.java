import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


class Validador {
    public boolean validar(String nombre) {
        // Valida que el nombre no esté vacío
        return nombre != null && !nombre.isEmpty();
    }

    public boolean validar(int rut) {
        // Valida que el RUT sea un número positivo
        return rut > 0;
    }
}
