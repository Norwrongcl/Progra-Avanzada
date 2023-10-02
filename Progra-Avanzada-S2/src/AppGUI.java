import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class AppGUI extends JFrame {

    private GestionClientes gestion;
    private JTextArea textArea;

    public AppGUI() {
        gestion = new GestionClientes();

     
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 2));
        
        JButton cargarButton = new JButton("Cargar Datos");
        cargarButton.addActionListener(e -> cargarDatos());
        buttonPanel.add(cargarButton);

        JButton mostrarButton = new JButton("Mostrar Clientes");
        mostrarButton.addActionListener(e -> mostrarClientes());
        buttonPanel.add(mostrarButton);

        JButton agregarButton = new JButton("Agregar Cliente");
        agregarButton.addActionListener(e -> agregarCliente());
        buttonPanel.add(agregarButton);

        JButton eliminarButton = new JButton("Eliminar Cliente");
        eliminarButton.addActionListener(e -> eliminarCliente());
        buttonPanel.add(eliminarButton);
        
        JButton agregarOrdenButton = new JButton("Agregar Orden de Trabajo");
        agregarOrdenButton.addActionListener(e -> agregarOrdenTrabajo());
        buttonPanel.add(agregarOrdenButton);

        JButton modificarOrdenButton = new JButton("Modificar Orden de Trabajo");
        modificarOrdenButton.addActionListener(e -> modificarOrdenTrabajo());
        buttonPanel.add(modificarOrdenButton);
        
        JButton eliminarOrdenButton = new JButton("Eliminar Orden de Trabajo");
        eliminarOrdenButton.addActionListener(e -> eliminarOrdenTrabajo());
        buttonPanel.add(eliminarOrdenButton);

        JButton generarReporteButton = new JButton("Generar Reporte");
        generarReporteButton.addActionListener(e -> generarReporte());
        buttonPanel.add(generarReporteButton);

        JButton cambiarEstadoOrdenButton = new JButton("Cambiar Estado de Orden de Trabajo");
        cambiarEstadoOrdenButton.addActionListener(e -> cambiarEstadoOrden());
        buttonPanel.add(cambiarEstadoOrdenButton);
        
        JButton mostrarOrdenesFiltradasButton = new JButton("Mostrar Órdenes de Trabajo Filtradas");
        mostrarOrdenesFiltradasButton.addActionListener(e -> mostrarOrdenesFiltradas());
        buttonPanel.add(mostrarOrdenesFiltradasButton);
        
        JButton exportarDatosButton = new JButton("Exportar datos a CSV");
        exportarDatosButton.addActionListener(e -> exportarDatos());
        buttonPanel.add(exportarDatosButton);
        
       
        
        add(buttonPanel, BorderLayout.SOUTH);
        setTitle("Gestión de Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void cargarDatos() {
        try {
            gestion.inicializarDatos();
            textArea.append("Datos cargados exitosamente.\n");
        } catch (IOException e) {
            textArea.append("Error al cargar los datos: " + e.getMessage() + "\n");
        }
    }
    private void mostrarClientes() {
        String infoClientes = gestion.obtenerInfoClientes();
        if (infoClientes.isEmpty()) {
            textArea.append("No hay clientes registrados.\n");
        } else {
            textArea.append(infoClientes + "\n");
        }
    }
    private void agregarCliente() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del cliente:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String rutStr = JOptionPane.showInputDialog(this, "Ingrese el RUT del cliente:");
        try {
            int rut = Integer.parseInt(rutStr);
            if (rut <= 0) throw new NumberFormatException();
            gestion.agregarCliente(nombre, rut);
            textArea.append("Cliente agregado exitosamente.\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "RUT inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void eliminarCliente() {
        String rutStr = JOptionPane.showInputDialog(this, "Ingrese el RUT del cliente a eliminar:");
        try {
            int rut = Integer.parseInt(rutStr);
            if (rut <= 0) throw new NumberFormatException();
            gestion.eliminarCliente(rut);
            textArea.append("Cliente eliminado exitosamente.\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "RUT inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void agregarOrdenTrabajo() {
        String rutStr = JOptionPane.showInputDialog(this, "Ingrese el RUT del cliente:");
        try {
            int rut = Integer.parseInt(rutStr);
            if (rut <= 0) throw new NumberFormatException();

            String descripcion = JOptionPane.showInputDialog(this, "Ingrese la descripción de la orden de trabajo:");
            if (descripcion == null || descripcion.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Descripción inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            gestion.agregarOrdenTrabajo(rut, descripcion);
            textArea.append("Orden de trabajo agregada exitosamente.\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "RUT inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cambiarEstadoOrden() {
        String rutStr = JOptionPane.showInputDialog(this, "Ingrese el RUT del cliente:");
        try {
            int rut = Integer.parseInt(rutStr);
            if (rut <= 0) throw new NumberFormatException();

            String indiceStr = JOptionPane.showInputDialog(this, "Ingrese el índice de la orden de trabajo:");
            int indice = Integer.parseInt(indiceStr);

            boolean marcarComoResuelta = JOptionPane.showConfirmDialog(this, "¿Desea marcar la orden como resuelta?", "Cambiar Estado de Orden de Trabajo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            gestion.cambiarEstadoOrden(rut, indice, marcarComoResuelta);
            textArea.append("Estado de la orden de trabajo actualizado exitosamente.\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "RUT o índice inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClienteNoEncontradoException | IndiceOrdenInvalidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void generarReporte() {
        boolean mostrarDetalles = JOptionPane.showConfirmDialog(this, "¿Desea un reporte detallado?", "Generar Reporte", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        Reporte reporte = new Reporte();
        reporte.generar(gestion, mostrarDetalles);
    }
    private void eliminarOrdenTrabajo() {
        String rutStr = JOptionPane.showInputDialog(this, "Ingrese el RUT del cliente:");
        try {
            int rut = Integer.parseInt(rutStr);
            if (rut <= 0) throw new NumberFormatException();

            String indiceStr = JOptionPane.showInputDialog(this, "Ingrese el índice de la orden de trabajo:");
            int indice = Integer.parseInt(indiceStr);

            gestion.eliminarOrdenTrabajo(rut, indice);
            textArea.append("Orden de trabajo eliminada exitosamente.\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "RUT o índice inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void modificarOrdenTrabajo() {
        String rutStr = JOptionPane.showInputDialog(this, "Ingrese el RUT del cliente:");
        try {
            int rut = Integer.parseInt(rutStr);
            if (rut <= 0) throw new NumberFormatException();

            String indiceStr = JOptionPane.showInputDialog(this, "Ingrese el índice de la orden de trabajo:");
            int indice = Integer.parseInt(indiceStr);

            String nuevaDescripcion = JOptionPane.showInputDialog(this, "Ingrese la nueva descripción de la orden de trabajo:");
            if (nuevaDescripcion == null || nuevaDescripcion.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Descripción inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            gestion.modificarOrdenTrabajo(rut, indice, nuevaDescripcion);
            textArea.append("Orden de trabajo modificada exitosamente.\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "RUT o índice inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarOrdenesFiltradas() {
        boolean mostrarResueltas = JOptionPane.showConfirmDialog(this, "¿Desea mostrar órdenes resueltas?", "Mostrar Órdenes de Trabajo Filtradas", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        gestion.mostrarOrdenesFiltradas(mostrarResueltas);
    }
    
    private void exportarDatos() {
        try {
            gestion.exportarDatos();
            textArea.append("Datos exportados exitosamente.\n");
        } catch (IOException e) {
            textArea.append("Error al exportar los datos: " + e.getMessage() + "\n");
        }
    }
     
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppGUI app = new AppGUI();
            app.setVisible(true);
        });
    }
}