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
        // Llenar los datos de la sucursal
        // Puedes utilizar JOptionPane o cualquier otro método de entrada de datos
    }

    private void llenarDatosCategoria(CategoriaEquipo categoria) {
        // Llenar los datos de la categoría
        // Puedes utilizar JOptionPane o cualquier otro método de entrada de datos
    }

    // ... Otros métodos según las necesidades de tu aplicación

}
