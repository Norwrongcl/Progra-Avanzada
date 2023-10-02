import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class GestionClientes {
    private HashMap<Integer, Cliente> clientes;
    private BufferedReader reader;

    public GestionClientes() {
        this.clientes = new HashMap<>();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void agregarCliente(Cliente cliente) {
        if (clientes.containsKey(cliente.getRut())) {
            System.out.println("Ya existe un cliente con ese RUT.");
            return;
        }
        clientes.put(cliente.getRut(), cliente);
        System.out.println("Cliente agregado exitosamente.");
    }
    
    public void agregarCliente(String nombre, int rut) {
        if (nombre != null && !nombre.isEmpty() && rut > 0) {
            Cliente nuevoCliente = new Cliente(nombre, rut);
            this.clientes.put(rut, nuevoCliente);
        } else {
            System.out.println("Nombre o RUT inválido, el cliente no puede ser agregado.");
        }
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
    public void eliminarCliente(int rut) {
        if (clientes.containsKey(rut)) {
            clientes.remove(rut);
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("Cliente con el RUT proporcionado no existe.");
        }
    }

    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Listado de Clientes:");
        for (Cliente cliente : clientes.values()) {
            System.out.println("RUT: " + cliente.getRut() + ", Nombre: " + cliente.getNombre());
            ArrayList<OrdenTrabajo> ordenes = cliente.getOrdenesTrabajo();
            for (int i = 0; i < ordenes.size(); i++) {
                OrdenTrabajo orden = ordenes.get(i);
                System.out.println("    Orden " + (i + 1) + ": " + orden.getDescripcion() + (orden.isResuelto() ? " (Resuelta)" : " (Pendiente)"));
            }
        }
    }

    public void agregarOrdenTrabajo(int rut, OrdenTrabajo orden) {
        Cliente cliente = clientes.get(rut);
        if (cliente != null) {
            cliente.agregarOrdenTrabajo(orden);
            System.out.println("Orden de trabajo agregada exitosamente.");
        } else {
            System.out.println("Cliente con el RUT proporcionado no existe.");
        }
    }
    
    public void agregarOrdenTrabajo(int rut, String descripcionOrden) {
        OrdenTrabajo nuevaOrden = new OrdenTrabajo(descripcionOrden);
        agregarOrdenTrabajo(rut, nuevaOrden);  // Llama al método original agregarOrdenTrabajo
    }
    
    public void modificarOrdenTrabajo(int rut, int indiceOrden, String nuevaDescripcion) {
        Cliente cliente = clientes.get(rut);
        if (cliente != null) {
            ArrayList<OrdenTrabajo> ordenes = cliente.getOrdenesTrabajo();
            if (indiceOrden >= 0 && indiceOrden < ordenes.size()) {
                OrdenTrabajo orden = ordenes.get(indiceOrden);
                orden.setDescripcion(nuevaDescripcion);  // Suponiendo que hay un método setDescripcion en OrdenTrabajo
                System.out.println("Orden de trabajo modificada exitosamente.");
            } else {
                System.out.println("Índice de orden de trabajo inválido.");
            }
        } else {
            System.out.println("Cliente con el RUT proporcionado no existe.");
        }
    }
    
    public void eliminarOrdenTrabajo(int rut, int indiceOrden) {
        Cliente cliente = clientes.get(rut);
        if (cliente != null) {
            ArrayList<OrdenTrabajo> ordenes = cliente.getOrdenesTrabajo();
            if (indiceOrden >= 0 && indiceOrden < ordenes.size()) {
                ordenes.remove(indiceOrden);
                System.out.println("Orden de trabajo eliminada exitosamente.");
            } else {
                System.out.println("Índice de orden de trabajo inválido.");
            }
        } else {
            System.out.println("Cliente con el RUT proporcionado no existe.");
        }
    }

    public HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }
    
    public void cambiarEstadoOrden(int rut, int indiceOrden, boolean marcarComoResuelta)
            throws ClienteNoEncontradoException, IndiceOrdenInvalidoException {
        Cliente cliente = clientes.get(rut);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente con el RUT proporcionado no existe.");
        }

        ArrayList<OrdenTrabajo> ordenes = cliente.getOrdenesTrabajo();
        if (indiceOrden < 0 || indiceOrden >= ordenes.size()) {
            throw new IndiceOrdenInvalidoException("Índice de orden de trabajo inválido.");
        }

        OrdenTrabajo orden = ordenes.get(indiceOrden);
        if (marcarComoResuelta) {
            orden.marcarComoResuelto();
        } else {
            orden.marcarComoNoResuelto();
        }

        System.out.println("Estado de la orden de trabajo actualizado exitosamente.");
    }

    
    
    public void mostrarOrdenesFiltradas(boolean mostrarResueltas) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("Listado de Órdenes de Trabajo " + (mostrarResueltas ? "Resueltas" : "No Resueltas") + ":");
        for (Cliente cliente : clientes.values()) {
            System.out.println("Cliente RUT: " + cliente.getRut() + ", Nombre: " + cliente.getNombre());
            ArrayList<OrdenTrabajo> ordenes = cliente.getOrdenesTrabajo();
            for (int i = 0; i < ordenes.size(); i++) {
                OrdenTrabajo orden = ordenes.get(i);
                if (orden.isResuelto() == mostrarResueltas) {
                    System.out.println("    Orden " + (i + 1) + ": " + orden.getDescripcion() + (orden.isResuelto() ? " (Resuelta)" : " (Pendiente)"));
                }
            }
        }
    }
    
    public void inicializarDatos() throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get("data.csv"));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(",");
            int rut = Integer.parseInt(campos[0]);
            String nombre = campos[1];
            String descripcionOrden = campos[2];
            boolean resuelta = campos[3].equalsIgnoreCase("TRUE");

            Cliente cliente = new Cliente(nombre, rut);
            OrdenTrabajo orden = new OrdenTrabajo(descripcionOrden);
            if (resuelta) {
                orden.marcarComoResuelto();
            }
            cliente.agregarOrdenTrabajo(orden);
            this.clientes.put(rut, cliente);
        }
        br.close();
    }
      
    public void exportarDatos() throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(Paths.get("data.csv"));
        for (Cliente cliente : clientes.values()) {
            for (OrdenTrabajo orden : cliente.getOrdenesTrabajo()) {
                String linea = String.format("%d,%s,%s,%s\n",
                    cliente.getRut(),
                    cliente.getNombre(),
                    orden.getDescripcion(),
                    orden.isResuelto() ? "TRUE" : "FALSE"
                );
                bw.write(linea);
            }
        }
        bw.close();
    }
    
    public String obtenerInfoClientes() {
        if (clientes.isEmpty()) {
            return "No hay clientes registrados.";
        }

        StringBuilder info = new StringBuilder();
        info.append("Listado de Clientes:\n");
        
        for (Cliente cliente : clientes.values()) {
            info.append("RUT: ").append(cliente.getRut())
                .append(", Nombre: ").append(cliente.getNombre()).append("\n");

            ArrayList<OrdenTrabajo> ordenes = cliente.getOrdenesTrabajo();
            if (ordenes.isEmpty()) {
                info.append("    No hay órdenes de trabajo registradas para este cliente.\n");
            } else {
                info.append("    Órdenes de Trabajo:\n");
                for (int i = 0; i < ordenes.size(); i++) {
                    OrdenTrabajo orden = ordenes.get(i);
                    info.append("        Orden ").append(i + 1).append(": ")
                        .append(orden.getDescripcion())
                        .append(orden.isResuelto() ? " (Resuelta)" : " (Pendiente)").append("\n");
                }
            }
        }
        return info.toString();
    }
}