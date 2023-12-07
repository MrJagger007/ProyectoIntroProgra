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

    public void EditarCategoria() {

        JOptionPane.showMessageDialog(null, "Esta opción edita todos los aspectos de una categoría.", "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
        // Se le solicita al usuario ingresar el nombre de la categoría a editar.
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre de la categoría a editar:");

        // Buscamos la categoría en el arreglo.
        for (int elemento = 0; elemento < totalCategorias; elemento++) {
            if (datosCategorias[elemento] != null && datosCategorias[elemento].getCategoryName().equals(nombreEditar)) {
                // Pedimos nueva información.
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la categoría:");
                String nuevasAtributos = JOptionPane.showInputDialog("Ingrese las nuevas características:");
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado de la categoría (Activo/Inactivo):");

                // Actualizamos la información de la categoría.
                datosCategorias[elemento].setCategoryName(nuevoNombre);
                datosCategorias[elemento].setAtributes(nuevasAtributos);
                datosCategorias[elemento].setCategoryStatus(nuevoEstado);

                JOptionPane.showMessageDialog(null, "Categoría actualizada correctamente.", "Actualización de Categoría", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró una categoría con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void EditarCaracteristicaCategoria() {
        // Mensaje informativo.
        JOptionPane.showMessageDialog(null, "Esto solo edita la característica de la categoría que usted ingrese.", "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

        // Se le solicita al usuario ingresar el nombre de la categoría a editar.
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre de la categoría cuya característica desea editar:");

        // Buscamos la categoría en el arreglo.
        for (int elemento = 0; elemento < totalCategorias; elemento++) {
            if (datosCategorias[elemento] != null && datosCategorias[elemento].getCategoryName().equals(nombreEditar)) {
                // Pedimos la nueva característica.
                String nuevasAtributos = JOptionPane.showInputDialog("Ingrese las nuevas características de la categoría:");

                // Actualizamos solo la característica de la categoría.
                datosCategorias[elemento].setAtributes(nuevasAtributos);

                JOptionPane.showMessageDialog(null, "Característica de categoría actualizada correctamente.", "Actualización de Característica de Categoría", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró una categoría con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void EditarEstadoCategoria() {
        // Se le solicita al usuario ingresar el nombre de la categoría a editar.
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre de la categoría cuyo estado desea editar:");

        // Buscamos la categoría en el arreglo.
        for (int elemento = 0; elemento < totalCategorias; elemento++) {
            if (datosCategorias[elemento] != null && datosCategorias[elemento].getCategoryName().equals(nombreEditar)) {
                // Solicitamos el nuevo estado.
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado de la categoría (Activo/Inactivo):");

                // Verificamos que el estado ingresado sea válido.
                if (nuevoEstado.equals("Activo") || nuevoEstado.equals("Inactivo")) {
                    // Actualizamos el estado de la categoría.
                    datosCategorias[elemento].setCategoryStatus(nuevoEstado);
                    JOptionPane.showMessageDialog(null, "Estado de la categoría actualizado correctamente.", "Actualización de Estado de Categoría", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese 'Activo' o 'Inactivo'.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró una categoría con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void MostrarCategoria() {
        int datos;
        String informacionCategorias = "";

        // En este bucle "for" obtenemos los "Get" de la información que anteriormente introdujimos en los "Set".
        for (datos = 0; datos < totalCategorias; datos++) {
            informacionCategorias = informacionCategorias + "Nombre de la categoría: " + datosCategorias[datos].getCategoryName() + " \nCaracteristicas: " + datosCategorias[datos].getAtributes()
                    + "\nEstado de categoría: " + datosCategorias[datos].getCategoryStatus() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, "Las categorías registradas son:\n \n" + informacionCategorias, "Categorías registradas", JOptionPane.INFORMATION_MESSAGE);
    }

    private Equipos datosEquipos[] = new Equipos[5];
    private int totalEquipos = 0;

    // En la clase donde está definido el menú Equipos
    public void AgregarNuevoEquipo() {
        if (totalEquipos < 5) {

            Equipos llenarDatos = new Equipos();

            llenarDatos.setName(JOptionPane.showInputDialog(null, "Escriba el nombre del equipo:", "Nombre del equipo", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setDescription(JOptionPane.showInputDialog(null, "Escriba la descripción del equipo:", "Descripción del equipo", JOptionPane.QUESTION_MESSAGE));

            while (true) {
                String estadoInput = JOptionPane.showInputDialog(null, "Establezca el estado de la sucursal (Ingresado/En reparación/Reparado/Entregado):", "Estado de la Sucursal", JOptionPane.QUESTION_MESSAGE);

                // Verifica si el estado ingresado es uno de los estados válidos
                if (estadoInput.equals("Ingresado") || estadoInput.equals("En reparación") || estadoInput.equals("Reparado") || estadoInput.equals("Entregado")) {
                    llenarDatos.setStatusName(estadoInput);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un estado válido (Ingresado/En reparación/Reparado/Entregado).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Lógica para ingresar usuario
            //while (true) {
            //String nombreUsuario = JOptionPane.showInputDialog(null, "Escriba el nombre del usuario a cargo del equipo:", "Usuario a cargo", JOptionPane.QUESTION_MESSAGE);
            //if (llenarDatos.existeUsuario(nombreUsuario, datosUsuarios)) {
            //    llenarDatos.setUser(nombreUsuario);
            //    break;
            //} else {
            //    JOptionPane.showMessageDialog(null, "Error: El usuario no existe. Por favor, ingrese un usuario válido.", "Error", JOptionPane.ERROR_MESSAGE);
            //}
            //}
            // Lógica para ingresar categoría
            while (true) {
                String nombreCategoria = JOptionPane.showInputDialog(null, "Escriba el nombre de la categoría del equipo:", "Categoría del equipo", JOptionPane.QUESTION_MESSAGE);
                if (llenarDatos.existeCategoria(nombreCategoria, datosCategorias)) {
                    llenarDatos.setCategory(nombreCategoria);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: La categoría no existe. Por favor, ingrese una categoría válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Lógica para ingresar sucursal
            while (true) {
                String nombreSucursal = JOptionPane.showInputDialog(null, "Escriba el nombre de la sucursal de procedencia del equipo:", "Sucursal de procedencia", JOptionPane.QUESTION_MESSAGE);
                if (llenarDatos.existeSucursal(nombreSucursal, datosSucursales)) {
                    llenarDatos.setSucursal(nombreSucursal);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: La sucursal no existe. Por favor, ingrese una sucursal válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Agregar llenarDatos al arreglo de equipos
            datosEquipos[totalEquipos] = llenarDatos;
            totalEquipos++;
        }
    }

    // Método para editar un equipo
    public void EditarEquipo() {
        // Se le solicita al usuario ingresar el nombre del equipo a editar.
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre del equipo a editar:");

        // Buscamos el equipo en el arreglo.
        for (int elemento = 0; elemento < totalEquipos; elemento++) {
            if (datosEquipos[elemento] != null && datosEquipos[elemento].getName().equals(nombreEditar)) {
                // Mensaje informativo.
                JOptionPane.showMessageDialog(null, "Estimado usuario, esta opción edita toda la información correspondiente al equipo.", "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

                // Pedimos nueva información.
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del equipo:");
                String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción del equipo:");

                // Actualizamos la información del equipo.
                datosEquipos[elemento].setName(nuevoNombre);
                datosEquipos[elemento].setDescription(nuevaDescripcion);

                // Lógica para editar el estado del equipo
                while (true) {
                    String nuevoEstado = JOptionPane.showInputDialog(null, "Establezca el nuevo estado del equipo (Ingresado/En reparación/Reparado/Entregado):", "Estado del Equipo", JOptionPane.QUESTION_MESSAGE);

                    if (nuevoEstado.equals("Ingresado") || nuevoEstado.equals("En reparación") || nuevoEstado.equals("Reparado") || nuevoEstado.equals("Entregado")) {
                        datosEquipos[elemento].setStatusName(nuevoEstado);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un estado válido (Ingresado/En reparación/Reparado/Entregado).", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                // Lógica para editar la categoría del equipo
                while (true) {
                    String nombreCategoria = JOptionPane.showInputDialog(null, "Escriba el nombre de la nueva categoría del equipo:", "Categoría del equipo", JOptionPane.QUESTION_MESSAGE);
                    if (datosEquipos[elemento].existeCategoria(nombreCategoria, datosCategorias)) {
                        datosEquipos[elemento].setCategory(nombreCategoria);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: La categoría no existe. Por favor, ingrese una categoría válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                // Lógica para editar la sucursal del equipo
                while (true) {
                    String nombreSucursal = JOptionPane.showInputDialog(null, "Escriba el nombre de la nueva sucursal de procedencia del equipo:", "Sucursal de procedencia", JOptionPane.QUESTION_MESSAGE);
                    if (datosEquipos[elemento].existeSucursal(nombreSucursal, datosSucursales)) {
                        datosEquipos[elemento].setSucursal(nombreSucursal);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: La sucursal no existe. Por favor, ingrese una sucursal válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                JOptionPane.showMessageDialog(null, "Equipo actualizado correctamente.", "Actualización de Equipo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un equipo con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Método para editar la categoría de un equipo
    public void EditarCategoriaEquipo() {
        // Se le solicita al usuario ingresar el nombre del equipo a editar.
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre del equipo cuya categoría desea editar:");

        // Buscamos el equipo en el arreglo.
        for (int elemento = 0; elemento < totalEquipos; elemento++) {
            if (datosEquipos[elemento] != null && datosEquipos[elemento].getName().equals(nombreEditar)) {
                // Mensaje informativo.
                JOptionPane.showMessageDialog(null, "Estimado usuario, esta opción edita únicamente la categoría del equipo.", "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

                // Lógica para editar la categoría del equipo
                while (true) {
                    String nombreCategoria = JOptionPane.showInputDialog(null, "Escriba el nombre de la nueva categoría del equipo:", "Categoría del equipo", JOptionPane.QUESTION_MESSAGE);
                    if (datosEquipos[elemento].existeCategoria(nombreCategoria, datosCategorias)) {
                        datosEquipos[elemento].setCategory(nombreCategoria);
                        JOptionPane.showMessageDialog(null, "Categoría del equipo actualizada correctamente.", "Actualización de Categoría de Equipo", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: La categoría no existe. Por favor, ingrese una categoría válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un equipo con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Método para editar la sucursal de un equipo
    public void EditarSucursalEquipo() {
        // Se le solicita al usuario ingresar el nombre del equipo a editar.
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre del equipo cuya sucursal desea editar:");

        // Buscamos el equipo en el arreglo.
        for (int elemento = 0; elemento < totalEquipos; elemento++) {
            if (datosEquipos[elemento] != null && datosEquipos[elemento].getName().equals(nombreEditar)) {
                // Mensaje informativo.
                JOptionPane.showMessageDialog(null, "Estimado usuario, esta opción edita únicamente la sucursal del equipo.", "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

                // Lógica para editar la sucursal del equipo
                while (true) {
                    String nombreSucursal = JOptionPane.showInputDialog(null, "Escriba el nombre de la nueva sucursal del equipo:", "Sucursal del equipo", JOptionPane.QUESTION_MESSAGE);
                    if (datosEquipos[elemento].existeSucursal(nombreSucursal, datosSucursales)) {
                        datosEquipos[elemento].setSucursal(nombreSucursal);
                        JOptionPane.showMessageDialog(null, "Sucursal del equipo actualizada correctamente.", "Actualización de Sucursal de Equipo", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: La sucursal no existe. Por favor, ingrese una sucursal válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un equipo con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Método para editar el estado de un equipo
    public void EditarEstadoEquipo() {
        // Se le solicita al usuario ingresar el nombre del equipo a editar.
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre del equipo cuyo estado desea editar:");

        // Buscamos el equipo en el arreglo.
        for (int elemento = 0; elemento < totalEquipos; elemento++) {
            if (datosEquipos[elemento] != null && datosEquipos[elemento].getName().equals(nombreEditar)) {
                // Mensaje informativo.
                JOptionPane.showMessageDialog(null, "Estimado usuario, esta opción edita únicamente el estado del equipo.", "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

                // Lógica para editar el estado del equipo
                while (true) {
                    String nuevoEstado = JOptionPane.showInputDialog(null, "Ingrese el nuevo estado del equipo (Ingresado/En reparación/Reparado/Entregado):", "Estado del equipo", JOptionPane.QUESTION_MESSAGE);

                    // Verifica si el estado ingresado es uno de los estados válidos
                    if (nuevoEstado.equals("Ingresado") || nuevoEstado.equals("En reparación") || nuevoEstado.equals("Reparado") || nuevoEstado.equals("Entregado")) {
                        datosEquipos[elemento].setStatusName(nuevoEstado);
                        JOptionPane.showMessageDialog(null, "Estado del equipo actualizado correctamente.", "Actualización de Estado de Equipo", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un estado válido (Ingresado/En reparación/Reparado/Entregado).", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un equipo con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void MostrarEquipos() {
        int datos;
        String informacionEquipos = "";

        // En este bucle "for" obtenemos los "Get" de la información que anteriormente introdujimos en los "Set".
        for (datos = 0; datos < totalEquipos; datos++) {
            informacionEquipos = informacionEquipos + "Nombre del equipo: " + datosEquipos[datos].getName() + " \nDescripción: " + datosEquipos[datos].getDescription()
                    + "\nEstado: " + datosEquipos[datos].getStatusName() + "\nCategoría: " + datosEquipos[datos].getCategory()
                    + "\nSucursal de procedencia: " + datosEquipos[datos].getSucursal() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, "Los equipos registrados son:\n \n" + informacionEquipos, "Equipos registrados", JOptionPane.INFORMATION_MESSAGE);
    }

}
