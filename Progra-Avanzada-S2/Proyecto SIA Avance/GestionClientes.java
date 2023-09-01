import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestionClientes {

    private HashMap<Integer, Cliente> clientes;
    private BufferedReader reader;


    public GestionClientes() {
        this.clientes = new HashMap<>();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void agregarCliente() throws IOException {
        System.out.println("Ingrese el RUT del cliente:");
        int rut = Integer.parseInt(reader.readLine());

        if (clientes.containsKey(rut)) {
            System.out.println("Ya existe un cliente con ese RUT.");
            return;
        }

        System.out.println("Ingrese el nombre del cliente:");
        String nombre = reader.readLine();

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setRut(rut);

        clientes.put(rut, nuevoCliente);
        System.out.println("Cliente agregado exitosamente.");
    }

    public void eliminarCliente() throws IOException {
        System.out.println("Ingrese el RUT del cliente a eliminar:");
        int rut = Integer.parseInt(reader.readLine());

        if (clientes.containsKey(rut)) {
            clientes.remove(rut);
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("Cliente con el RUT proporcionado no existe.");
        }
    }

    // Puedes agregar un método main para probar la clase si lo deseas
    public static void main(String[] args) throws IOException {
        GestionClientes gestion = new GestionClientes();
        gestion.agregarCliente();
        gestion.eliminarCliente();
    }


}
