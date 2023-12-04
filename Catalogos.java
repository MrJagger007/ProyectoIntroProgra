package proyectofinal;

import javax.swing.JOptionPane;

public class Catalogos {

    private final Sucursales[] sucursales = new Sucursales[5];
    private int totalSucursales = 0;

    private final Categorias_Equipos[] categorias = new Categorias_Equipos[5];
    private int totalCategorias = 0;

    public void AgregarSucursales() {
        if (totalSucursales < 5) {
            Sucursales nuevaSucursal = new Sucursales();
            llenarDatosSucursal(nuevaSucursal);
            sucursales[totalSucursales++] = nuevaSucursal;
        }
    }

    public void MostrarSucursales() {
        StringBuilder informacionSucursales = new StringBuilder();
        for (Sucursales sucursal : sucursales) {
            if (sucursal != null) {
                informacionSucursales.append("Nombre: ").append(sucursal.getNombre()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, "Las sucursales registradas son:\n \n" + informacionSucursales, "Sucursales registradas", JOptionPane.INFORMATION_MESSAGE);
    }

    public void AgregarInformacionCategoria() {
        if (totalCategorias < 5) {
            Categorias_Equipos nuevaCategoria = new Categorias_Equipos();
            llenarDatosCategoria(nuevaCategoria);
            categorias[totalCategorias++] = nuevaCategoria;
        }
    }

    public void MostrarCategoria() {
        StringBuilder informacionCategorias = new StringBuilder();
        for (Categorias_Equipos categoria : categorias) {
            if (categoria != null) {
                informacionCategorias.append("Nombre de la categoría: ").append(categoria.getCategoryName()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, "Las categorías registradas son:\n \n" + informacionCategorias, "Categorías registradas", JOptionPane.INFORMATION_MESSAGE);
    }

    private void llenarDatosSucursal(Sucursales sucursal) {
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

    private void llenarDatosCategoria(Categorias_Equipos categoria) {
        categoria.setCategoryName(JOptionPane.showInputDialog(null, "Ingrese el nombre de la categoría:", "Nombre de la Categoría", JOptionPane.QUESTION_MESSAGE));
        categoria.setAtributes(JOptionPane.showInputDialog(null, "Ingrese las características de la categoría:", "Características de la Categoría", JOptionPane.QUESTION_MESSAGE));

        // Bucle para garantizar que se ingrese "Activo" o "Inactivo"
        while (true) {
            String estadoInput = JOptionPane.showInputDialog(null, "Establezca el estado de la categoría (Activo/Inactivo):", "Estado de la Categoría", JOptionPane.QUESTION_MESSAGE);

            if (estadoInput.equals("Activo") || estadoInput.equals("Inactivo")) {
                categoria.setCategoryStatus(estadoInput);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese 'Activo' o 'Inactivo'.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
