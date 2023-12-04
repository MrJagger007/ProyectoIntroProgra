package proyectofinal;

import javax.swing.JOptionPane;

public class Catalogos {

    private final Sucursal[] sucursales = new Sucursal[5];
    private int totalSucursales = 0;

    private final CategoriaEquipo[] categorias = new CategoriaEquipo[5];
    private int totalCategorias = 0;

    public void agregarSucursal() {
        if (totalSucursales < 5) {
            Sucursal nuevaSucursal = new Sucursal();
            llenarDatosSucursal(nuevaSucursal);
            sucursales[totalSucursales++] = nuevaSucursal;
        }
    }

    public void mostrarSucursales() {
        StringBuilder informacionSucursales = new StringBuilder();
        for (Sucursal sucursal : sucursales) {
            if (sucursal != null) {
                informacionSucursales.append("Nombre: ").append(sucursal.getNombre()).append("\n");
                // ... Otros detalles de la sucursal
            }
        }
        JOptionPane.showMessageDialog(null, "Las sucursales registradas son:\n \n" + informacionSucursales, "Sucursales registradas", JOptionPane.INFORMATION_MESSAGE);
    }

    public void agregarCategoria() {
        if (totalCategorias < 5) {
            CategoriaEquipo nuevaCategoria = new CategoriaEquipo();
            llenarDatosCategoria(nuevaCategoria);
            categorias[totalCategorias++] = nuevaCategoria;
        }
    }

    public void mostrarCategorias() {
        StringBuilder informacionCategorias = new StringBuilder();
        for (CategoriaEquipo categoria : categorias) {
            if (categoria != null) {
                informacionCategorias.append("Nombre de la categoría: ").append(categoria.getNombre()).append("\n");
                // ... Otros detalles de la categoría
            }
        }
        JOptionPane.showMessageDialog(null, "Las categorías registradas son:\n \n" + informacionCategorias, "Categorías registradas", JOptionPane.INFORMATION_MESSAGE);
    }

    public Sucursal buscarSucursalPorNombre(String nombre) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal != null && sucursal.getNombre().equals(nombre)) {
                return sucursal;
            }
        }
        return null; // No se encontró la sucursal
    }

    public CategoriaEquipo buscarCategoriaPorNombre(String nombre) {
        for (CategoriaEquipo categoria : categorias) {
            if (categoria != null && categoria.getNombre().equals(nombre)) {
                return categoria;
            }
        }
        return null; // No se encontró la categoría
    }

    public int getTotalSucursales() {
        return totalSucursales;
    }

    public int getTotalCategorias() {
        return totalCategorias;
    }

private void llenarDatosSucursal(Sucursal sucursal) {
    sucursal.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre de la sucursal:", "Nombre de la Sucursal", JOptionPane.QUESTION_MESSAGE));
    sucursal.setCiudad(JOptionPane.showInputDialog(null, "Ingrese la ciudad de la sucursal:", "Ciudad de la Sucursal", JOptionPane.QUESTION_MESSAGE));
    sucursal.setDireccion(JOptionPane.showInputDialog(null, "Ingrese la dirección de la sucursal:", "Dirección de la Sucursal", JOptionPane.QUESTION_MESSAGE));
    sucursal.setTelefono(JOptionPane.showInputDialog(null, "Ingrese el teléfono de la sucursal:", "Teléfono de la Sucursal", JOptionPane.QUESTION_MESSAGE));
    sucursal.setCorreo(JOptionPane.showInputDialog(null, "Ingrese el correo de la sucursal:", "Correo de la Sucursal", JOptionPane.QUESTION_MESSAGE));

    // Bucle para garantizar que se ingrese "Activo" o "Inactivo"
    while (true) {
        String estadoInput = JOptionPane.showInputDialog(null, "Establezca el estado de la sucursal (Activo/Inactivo):", "Estado de la Sucursal", JOptionPane.QUESTION_MESSAGE);

        if (estadoInput.equals("Activo") || estadoInput.equals("Inactivo")) {
            sucursal.setEstado(estadoInput);
            break;
        } else {
            JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese 'Activo' o 'Inactivo'.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

private void llenarDatosCategoria(CategoriaEquipo categoria) {
    categoria.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre de la categoría:", "Nombre de la Categoría", JOptionPane.QUESTION_MESSAGE));
    categoria.setCaracteristicas(JOptionPane.showInputDialog(null, "Ingrese las características de la categoría:", "Características de la Categoría", JOptionPane.QUESTION_MESSAGE));

    // Bucle para garantizar que se ingrese "Activo" o "Inactivo"
    while (true) {
        String estadoInput = JOptionPane.showInputDialog(null, "Establezca el estado de la categoría (Activo/Inactivo):", "Estado de la Categoría", JOptionPane.QUESTION_MESSAGE);

        if (estadoInput.equals("Activo") || estadoInput.equals("Inactivo")) {
            categoria.setEstado(estadoInput);
            break;
        } else {
            JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese 'Activo' o 'Inactivo'.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
