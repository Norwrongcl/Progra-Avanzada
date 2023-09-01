import java.io.IOException;

public class Menu {
    public static void main(String[] args) throws IOException {
        GestionClientes gestion = new GestionClientes();
        gestion.agregarCliente();
        gestion.eliminarCliente();
    }

}
