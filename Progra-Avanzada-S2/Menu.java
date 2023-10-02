import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static void main(String[] args) throws IOException {
        GestionClientes gestion = new GestionClientes();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Reporte reporte = new Reporte();
        Validador validador = new Validador();

        int resp = 0;
        boolean continuar = true;
        do {
            System.out.println("Director");
            System.out.println("1) Inicializar datos");
            System.out.println("2) Agregar Cliente");
            System.out.println("3) Eliminar Cliente");
            System.out.println("4) Mostrar Clientes");
            System.out.println("5) Agregar Orden de Trabajo");
            System.out.println("6) Modificar Orden de Trabajo");
            System.out.println("7) Eliminar Orden de Trabajo");
            System.out.println("8) Generar Reporte");
            System.out.println("9) Cambiar Estado de Orden de Trabajo");
            System.out.println("10) Mostrar Órdenes de Trabajo Filtradas");
            System.out.println("11) Exportar datos a CSV");

            
            System.out.println("Otherwise: Salir");

            resp = Integer.parseInt(reader.readLine());
            try {

            switch (resp) {
                case 1:
                	gestion.inicializarDatos();
                	break;
                case 2:
                    System.out.println("Ingrese el RUT del cliente:");
                    int rut = Integer.parseInt(reader.readLine());
                    System.out.println("Ingrese el nombre del cliente:");
                    String nombre = reader.readLine();
                    Cliente cliente = new Cliente(nombre, rut);
                    gestion.agregarCliente(cliente);
                    break;
                case 3:
                    gestion.eliminarCliente();
                    break;
                case 4:
                    gestion.mostrarClientes();
                    break;
                case 5:
                    System.out.println("Ingrese el RUT del cliente:");
                    int rutt = Integer.parseInt(reader.readLine());
                    System.out.println("Ingrese la descripción de la orden de trabajo:");
                    String descripcion = reader.readLine();
                    OrdenTrabajo orden = new OrdenTrabajo(descripcion);
                    gestion.agregarOrdenTrabajo(rutt, orden);
                    break;
                case 6:
                    System.out.println("Ingrese el RUT del cliente:");
                    int rutModificar = Integer.parseInt(reader.readLine());
                    System.out.println("Ingrese el índice de la orden de trabajo a modificar:");
                    int indiceModificar = Integer.parseInt(reader.readLine());
                    System.out.println("Ingrese la nueva descripción de la orden de trabajo:");
                    String nuevaDescripcion = reader.readLine();
                    gestion.modificarOrdenTrabajo(rutModificar, indiceModificar, nuevaDescripcion);
                    break;
                case 7:
                    System.out.println("Ingrese el RUT del cliente:");
                    int rutEliminar = Integer.parseInt(reader.readLine());
                    System.out.println("Ingrese el índice de la orden de trabajo a eliminar:");
                    int indiceEliminar = Integer.parseInt(reader.readLine());
                    gestion.eliminarOrdenTrabajo(rutEliminar, indiceEliminar);
                    break;
                case 8:
                    System.out.println("¿Desea un reporte detallado? (s/n):");
                    String detalleResp = reader.readLine();
                    boolean mostrarDetalles = detalleResp.equalsIgnoreCase("s");
                    reporte.generar(gestion, mostrarDetalles);
                    break;
                    
                case 9:
                    System.out.println("Ingrese el RUT del cliente:");
                    int rutEstado = Integer.parseInt(reader.readLine());
                    System.out.println("Ingrese el índice de la orden de trabajo a cambiar:");
                    int indiceEstado = Integer.parseInt(reader.readLine());
                    System.out.println("¿Desea marcar la orden como resuelta? (s/n):");
                    String respuestaEstado = reader.readLine();
                    boolean marcarComoResuelta = respuestaEstado.equalsIgnoreCase("s");
                    gestion.cambiarEstadoOrden(rutEstado, indiceEstado, marcarComoResuelta);
                    break;
                    
                case 10:
                    System.out.println("¿Desea mostrar órdenes resueltas? (s/n):");
                    String respuestaFiltro = reader.readLine();
                    boolean mostrarResueltas = respuestaFiltro.equalsIgnoreCase("s");
                    gestion.mostrarOrdenesFiltradas(mostrarResueltas);
                    break; 
                    
                case 11:
                    System.out.println("Ingrese la ruta donde desea guardar el archivo CSV:");
                    gestion.exportarDatos();
                    break;
                    
                default:
                    System.out.println("Saliendo...\n");
                    continuar = false;
                    break;
            }
            } catch (ClienteNoEncontradoException | IndiceOrdenInvalidoException e) {
                System.out.println(e.getMessage());
            }
        } while (continuar);
    }
}