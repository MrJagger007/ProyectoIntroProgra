package proyectofinal;

import javax.swing.JOptionPane;

public class Catalogos {

    // Arreglo para almacenar información de las sucursales de Fix Tech.
    private Sucursales datosSucursales[] = new Sucursales[5];
    private int totalSucursales = 0;

    // Método para agregar nuevas sucursales
    public void AgregarSucursales() {

        // De momento se establece que el total de sucursales que podrá almacenar el arreglo será de 5.
        if (totalSucursales < 5) {

            // Creamos una nueva instancia de Sucursales para luego asociarla con datosSucursales.
            Sucursales llenarDatos = new Sucursales();

            // En esta parte llamamos a los "Set" de la clase Sucursales.
            llenarDatos.setName(JOptionPane.showInputDialog(null, "Escriba el nombre de la sucursal:", "Nombre de la Sucursal", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setCity(JOptionPane.showInputDialog(null, "Escriba la ciudad de la sucursal:", "Ciudad de la Sucursal", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setAddress(JOptionPane.showInputDialog(null, "Escriba la dirección de la sucursal:", "Dirección de la Sucursal", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setPhone(JOptionPane.showInputDialog(null, "Escriba el teléfono de la sucursal:", "Teléfono de la Sucursal", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setEmail(JOptionPane.showInputDialog(null, "Escriba el correo de la sucursal:", "Correo de la Sucursal", JOptionPane.QUESTION_MESSAGE));

            // Establecemos un bucle "while" para garantizar que se ingrese correctamente "Activo" o "Inactivo".
            while (true) {
                String estadoInput = JOptionPane.showInputDialog(null, "Establezca el estado de la sucursal (Activo/Inactivo):", "Estado de la Sucursal", JOptionPane.QUESTION_MESSAGE);

                if (estadoInput.equals("Activo") || estadoInput.equals("Inactivo")) {
                    llenarDatos.setStatusName(estadoInput);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese 'Activo' o 'Inactivo'.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Almacenamos la instancia de Sucursales en el arreglo de datosSucursales.
            datosSucursales[totalSucursales] = llenarDatos;
            // Incrementamos el contador de totalSucursales cada vez que se llene un formulario para sucursales.
            totalSucursales++;
        }
    }

    // Método para eliminar una sucursal
    public void EliminarSucursal() {

        // Se le solicita al usuario ingresar el nombre de la sucursal a eliminar.
        String nombreAEliminar = JOptionPane.showInputDialog("Ingrese el nombre de la sucursal a eliminar:");

        // Verificamos si la sucursal existe.
        for (int indiceSucursal = 0; indiceSucursal < totalSucursales; indiceSucursal++) {

            // Si el nombreAEliminar es igual al nombre registrado...
            if (datosSucursales[indiceSucursal] != null && datosSucursales[indiceSucursal].getName().equals(nombreAEliminar)) {

                // Mueve los elementos restantes si la sucursal que se desea eliminar no está en la última posición.
                if (indiceSucursal < totalSucursales - 1) {
                    for (int posicionSucursal = indiceSucursal; posicionSucursal < totalSucursales - 1; posicionSucursal++) {
                        datosSucursales[posicionSucursal] = datosSucursales[posicionSucursal + 1];
                    }
                }
                // Eliminamos la sucursal y reducimos por tanto el contador totalSucursales.
                datosSucursales[totalSucursales - 1] = null;
                totalSucursales--;
                JOptionPane.showMessageDialog(null, "Sucursal eliminada correctamente.", "Eliminación de Sucursal", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró una sucursal con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    //Método para editar estado de la sucursal
    public void EstadoSucursal() {
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre de la sucursal a editar:");

        for (int elemento = 0; elemento < totalSucursales; elemento++) {
            if (datosSucursales[elemento] != null && datosSucursales[elemento].getName().equals(nombreEditar)) {

                // Solicitud de la nueva información
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado de la sucursal (Activo/Inactivo):");

                // Actualizamos la información del estado
                datosSucursales[elemento].setStatusName(nuevoEstado);

                JOptionPane.showMessageDialog(null, "Estado de la sucursal actualizado correctamente.", "Estado Sucursal", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un cliente con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Método para editar una sucursal
    public void EditarSucursal() {
        // Se le solicita al usuario ingresar el nombre de la sucursal a editar.
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre de la sucursal a editar:");

        // Buscamos la sucursal en el arreglo.
        for (int elemento = 0; elemento < totalSucursales; elemento++) {
            if (datosSucursales[elemento] != null && datosSucursales[elemento].getName().equals(nombreEditar)) {
                // Pedimos nueva información.
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la sucursal:");
                String nuevaCiudad = JOptionPane.showInputDialog("Ingrese la nueva ciudad de la sucursal:");
                String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección de la sucursal:");
                String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono de la sucursal:");
                String nuevoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo correo de la sucursal:");
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado de la sucursal (Activo/Inactivo):");

                // Actualizamos la información de la sucursal.
                datosSucursales[elemento].setName(nuevoNombre);
                datosSucursales[elemento].setCity(nuevaCiudad);
                datosSucursales[elemento].setAddress(nuevaDireccion);
                datosSucursales[elemento].setPhone(nuevoTelefono);
                datosSucursales[elemento].setEmail(nuevoCorreo);
                datosSucursales[elemento].setStatusName(nuevoEstado);

                JOptionPane.showMessageDialog(null, "Sucursal actualizada correctamente.", "Actualización de Sucursal", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró una sucursal con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Método para mostrar sucursales previamente agregadas.
    public void MostrarSucursales() {
        int datos;
        String informacionSucursales = "";

        // En este bucle "for" obtenemos los "Get" de la información que anteriormente introdujimos en los "Set".
        for (datos = 0; datos < totalSucursales; datos++) {
            informacionSucursales = informacionSucursales + datosSucursales[datos].getName() + " \nCiudad: " + datosSucursales[datos].getCity()
                    + "\nDirección: " + datosSucursales[datos].getAddress() + "\nTeléfono: " + datosSucursales[datos].getPhone()
                    + "\nCorreo Electrónico: " + datosSucursales[datos].getEmail() + " \nESTADO: " + datosSucursales[datos].getStatusName() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, "Las sucursales registradas son:\n \n" + informacionSucursales, "Sucursales registradas", JOptionPane.INFORMATION_MESSAGE);
    }

    //Métodos de categorías de equipos
    private Categorias_Equipos datosCategorias[] = new Categorias_Equipos[5];
    private int totalCategorias = 0;

    public void AgregarInformacionCategoria() {

        if (totalCategorias < 5) {

            Categorias_Equipos llenarDatos = new Categorias_Equipos();

            llenarDatos.setCategoryName(JOptionPane.showInputDialog(null, "Escriba el nombre de la categoria:", "Nombre de la categoría", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setAtributes(JOptionPane.showInputDialog(null, "Escriba las características:", "Caracteristicas", JOptionPane.QUESTION_MESSAGE));

            while (true) {
                String estadoInput = JOptionPane.showInputDialog(null, "Establezca el estado de la categoría (Activo/Inactivo):", "Estado de la categoría", JOptionPane.QUESTION_MESSAGE);

                if (estadoInput.equals("Activo") || estadoInput.equals("Inactivo")) {
                    llenarDatos.setCategoryStatus(estadoInput);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese 'Activo' o 'Inactivo'.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            datosCategorias[totalCategorias] = llenarDatos;

            totalCategorias++;
        }
    }

    public void MostrarCategoria() {
        int datos;
        String informacionCategorias = "";

        // En este bucle "for" obtenemos los "Get" de la información que anteriormente introdujimos en los "Set".
        for (datos = 0; datos < totalCategorias; datos++) {
            informacionCategorias = informacionCategorias + "Nombre de la categoría:" + datosCategorias[datos].getCategoryName() + " \nCaracteristicas: " + datosCategorias[datos].getAtributes()
                    + "\nEstado de categoría: " + datosCategorias[datos].getCategoryStatus() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, "Las sucursales registradas son:\n \n" + informacionCategorias, "Sucursales registradas", JOptionPane.INFORMATION_MESSAGE);
    }

}
