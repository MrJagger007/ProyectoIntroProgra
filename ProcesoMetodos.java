package proyectofixtech;

import javax.swing.JOptionPane;

public class ProcesoMetodos {

    //------ MÉTODOS PARA ALMACENAR LOS DATOS DE LOS USUARIOS FIXTECH
    // Arreglo para almacenar información de los usuarios de Fix Tech.
    public Usuarios_FixTech datosUsuarios[] = new Usuarios_FixTech[15];

    // Se desarrolla un contador. No vamos a trabajar con "For" porque se tendrían que llenar una cantidad de datos
    // específicos a la vez, con el contador hacemos que el usuario repita el proceso si asi lo desea.
    private int totalUsuarios = 0;
    //variables para almacenar los ingresos del día
    private double ingresosDelDia = 0.0;

    // Método para agregar nuevos usuarios
    public void AgregarUsuarios() {

        //De momento se establece que el total de usuario que podrá almacenar el arreglo será de 15.
        if (totalUsuarios < datosUsuarios.length) {

            // Creamos una nueva instancia de Usuarios_FixTech para luego asociarla con datosUsuarios
            Usuarios_FixTech llenarDatos = new Usuarios_FixTech();

            //En esta parte llamamos a los "Set" de la clase Usuarios_FixTech
            llenarDatos.setName(JOptionPane.showInputDialog(null, "Escriba el nombre del usuario:", "Nombre del Usuario", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setLastname(JOptionPane.showInputDialog(null, "Escriba el apellido del usuario:", "Apellido del Usuario", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setUsername(JOptionPane.showInputDialog(null, "Establezca un nombre de usuario:", "Nombre de usuario del Usuario", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setPassword(JOptionPane.showInputDialog(null, "Establezca una contraseña:", "Contraseña del Usuario", JOptionPane.QUESTION_MESSAGE));

            // Establecemos un bucle "while" para garantizar que se ingrese correctamente "Activo" o "Inactivo"
            while (true) {
                String estadoInput = JOptionPane.showInputDialog(null, "Establezca el estado del usuario (Activo/Inactivo):", "Estado del Usuario", JOptionPane.QUESTION_MESSAGE);

                if (estadoInput.equals("Activo") || estadoInput.equals("activo") || estadoInput.equals("Inactivo") || estadoInput.equals("inactivo")) {
                    llenarDatos.setStatusName(estadoInput);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese 'Activo' o 'Inactivo'.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Almacenamos la instancia de Usuarios_FixTech en el arreglo de datosUsuarios.
            datosUsuarios[totalUsuarios] = llenarDatos;
            //Incrementamos el contador de totalUsuarios cada vez que se llene un formulario para usuarios.
            totalUsuarios++;
        }
    }

    // Método para eliminar un usuario
    public void EliminarUsuario() {

        //Se le solicita al usuario ingresar el username a eliminar.
        String usernameAEliminar = JOptionPane.showInputDialog("Ingrese el nombre de usuario a eliminar:");

        // Verificamos si el usuario existe.
        for (int indiceUsuario = 0; indiceUsuario < totalUsuarios; indiceUsuario++) {

            // Si el usernameAEliminar es igual a el username registrado...
            if (datosUsuarios[indiceUsuario] != null && datosUsuarios[indiceUsuario].getUsername().equals(usernameAEliminar)) {

                // Mueve los elementos restantes si el usuario que se desea eliminar no está en la última posición.
                if (indiceUsuario < totalUsuarios - 1) {
                    for (int posicionUsuario = indiceUsuario; posicionUsuario < totalUsuarios - 1; posicionUsuario++) {
                        datosUsuarios[posicionUsuario] = datosUsuarios[posicionUsuario + 1];
                    }
                }
                // Eliminamos el usuario y reducimos por tanto el contador totalUsuarios.
                datosUsuarios[totalUsuarios - 1] = null;
                totalUsuarios--;
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.", "Eliminación de Usuario", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un usuario con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void EstadoUsuario() {
        String usernameEditar = JOptionPane.showInputDialog("Ingrese el nombre del usuario a editar:");

        for (int elemento = 0; elemento < totalUsuarios; elemento++) {
            if (datosUsuarios[elemento] != null && datosUsuarios[elemento].getName().equals(usernameEditar)) {

                // Solicitud de la nueva información
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado del usuario (Activo/Inactivo):");

                // Actualizamos la información del estado
                datosUsuarios[elemento].setStatusName(nuevoEstado);

                JOptionPane.showMessageDialog(null, "Estado de usuario actualizado correctamente.", "Estado de usuario", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un usuario con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void EditarUsuario() {
        String usernameEditar = JOptionPane.showInputDialog("Ingrese el nombre de usuario a editar:");

        for (int elemento = 0; elemento < totalUsuarios; elemento++) {
            if (datosUsuarios[elemento] != null && datosUsuarios[elemento].getUsername().equals(usernameEditar)) {
                // Pedimos nueva información
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del usuario:");
                String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del usuario:");
                String nuevoUsername = JOptionPane.showInputDialog("Ingrese el nuevo nombre de usuario:");
                String nuevaPassword = JOptionPane.showInputDialog("Ingrese la nueva contraseña:");
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado del usuario (Activo/Inactivo):");

                // Actualizamos la información del usuario
                datosUsuarios[elemento].setName(nuevoNombre);
                datosUsuarios[elemento].setLastname(nuevoApellido);
                datosUsuarios[elemento].setUsername(nuevoUsername);
                datosUsuarios[elemento].setPassword(nuevaPassword);
                datosUsuarios[elemento].setStatusName(nuevoEstado);

                JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.", "Actualización de Usuario", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un usuario con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Método para mostrar usuarios previamente agregados.
    public void MostrarUsuarios() {

        int datos;
        String informacionUsuarios = "";

        //En este "For" obtenemos los "Get" de la información que anteriormente introdujimos en los "Set"
        for (datos = 0; datos < totalUsuarios; datos++) {
            informacionUsuarios = informacionUsuarios + "\n - NOMBRE COMPLETO: " + datosUsuarios[datos].getName() + " " + datosUsuarios[datos].getLastname()
                    + " \n  - ESTADO: " + datosUsuarios[datos].getStatusName() + " \n  - USERNAME: " + datosUsuarios[datos].getUsername() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, "Los usuarios registrados son: \n\n" + informacionUsuarios, "Usuarios registrados", JOptionPane.INFORMATION_MESSAGE);

    }
    //------ MÉTODOS PARA ALMACENAR LOS DATOS DE LOS CLIENTES FIXTECH
    //Esta parte no se va a comentar dado que sigue exactamente la misma lógica que se usó para Usuarios_FixTech
    private Clientes_FixTech datosClientes[] = new Clientes_FixTech[30];
    private int totalClientes = 0;

    public void AgregarClientes() {

        if (totalClientes < datosClientes.length) {

            Clientes_FixTech llenarDatos = new Clientes_FixTech();
            llenarDatos.setName(JOptionPane.showInputDialog(null, "Escriba el nombre del cliente:", "Nombre del Cliente", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setLastname(JOptionPane.showInputDialog(null, "Escriba el apellido del cliente:", "Apellido del Cliente", JOptionPane.QUESTION_MESSAGE));

            // Establecemos un bucle "while" para garantizar que se ingrese correctamente "Activo" o "Inactivo"
            while (true) {
                String estadoInput = JOptionPane.showInputDialog(null, "Establezca el estado del cliente (Activo/Inactivo):", "Estado del Cliente", JOptionPane.QUESTION_MESSAGE);

                if (estadoInput.equals("Activo") || estadoInput.equals("activo") || estadoInput.equals("Inactivo") || estadoInput.equals("inactivo")) {
                    llenarDatos.setStatus(estadoInput);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese 'Activo' o 'Inactivo'.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            datosClientes[totalClientes] = llenarDatos;
            totalClientes++;
        }
    }

    public void EliminarCliente() {
        String clienteAEliminar = JOptionPane.showInputDialog("Ingrese el nombre del cliente a eliminar:");

        for (int indiceUsuario = 0; indiceUsuario < totalClientes; indiceUsuario++) {

            if (datosClientes[indiceUsuario] != null && datosClientes[indiceUsuario].getName().equals(clienteAEliminar)) {
                if (indiceUsuario < totalClientes - 1) {
                    for (int posicionUsuario = indiceUsuario; posicionUsuario < totalClientes - 1; posicionUsuario++) {
                        datosClientes[posicionUsuario] = datosClientes[posicionUsuario + 1];
                    }
                }
                datosClientes[totalClientes - 1] = null;

                totalClientes--;
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.", "Eliminación de Cliente", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un usuario con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void Estadocliente() {
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre del cliente a editar:");

        for (int elemento = 0; elemento < totalClientes; elemento++) {
            if (datosClientes[elemento] != null && datosClientes[elemento].getName().equals(nombreEditar)) {

                // Solicitud de la nueva información
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado del cliente (Activo/Inactivo):");

                // Actualizamos la información del estado
                datosClientes[elemento].setStatus(nuevoEstado);

                JOptionPane.showMessageDialog(null, "Estado de cliente actualizado correctamente.", "Estado de Cliente", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un cliente con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void EditarCliente() {
        String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre del cliente a editar:");

        for (int elemento = 0; elemento < totalClientes; elemento++) {
            if (datosClientes[elemento] != null && datosClientes[elemento].getName().equals(nombreEditar)) {

                // Pedimos la nueva información
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente: ");
                String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente: ");
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado del cliente (Activo/Inactivo):");

                // Actualizamos la información del cliente
                datosClientes[elemento].setName(nuevoNombre);
                datosClientes[elemento].setLastname(nuevoApellido);
                datosClientes[elemento].setStatus(nuevoEstado);

                JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.", "Actualización de Cliente", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un cliente con ese nombre. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void MostrarClientes() {

        int datos;
        String informacionClientes = "";
        for (datos = 0; datos < totalClientes; datos++) {
            informacionClientes = informacionClientes + "\n - NOMBRE CLIENTE: " + datosClientes[datos].getName() + " " + datosClientes[datos].getLastname()
                    + " \n  - ESTADO: " + datosClientes[datos].getStatus() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, "Los clientes registrados son:\n\n" + informacionClientes, "Clientes registrados", JOptionPane.INFORMATION_MESSAGE);

    }

    //------ MÉTODOS PARA ALMACENAR LOS DATOS DE LAS SUCURSALES
    private Sucursales datosSucursales[] = new Sucursales[5];
    private int totalSucursales = 0;

    // Método para agregar nuevas sucursales
    public void AgregarSucursales() {

        // De momento se establece que el total de sucursales que podrá almacenar el arreglo será de 5.
        if (totalSucursales < datosSucursales.length) {

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

                if (estadoInput.equals("Activo") || estadoInput.equals("activo") || estadoInput.equals("Inactivo") || estadoInput.equals("inactivo")) {
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
            informacionSucursales = informacionSucursales + "\n - NOMBRE SUCURSAL: " + datosSucursales[datos].getName() + " \n - Ciudad: " + datosSucursales[datos].getCity()
                    + "\n - DIRECCIÓN: " + datosSucursales[datos].getAddress() + "\n - TELÉFONO: " + datosSucursales[datos].getPhone()
                    + "\n - CORREO ELECTRÓNICO: " + datosSucursales[datos].getEmail() + " \n - ESTADO: " + datosSucursales[datos].getStatusName() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, "Las sucursales registradas son: \n\n" + informacionSucursales, "Sucursales registradas", JOptionPane.INFORMATION_MESSAGE);
    }
    //------ MÉTODOS PARA ALMACENAR LOS DATOS DE LAS CATEGORIAS

    //Métodos de categorías de equipos
    private Categorias_Equipos datosCategorias[] = new Categorias_Equipos[5];
    private int totalCategorias = 0;

    public void AgregarInformacionCategoria() {

        if (totalCategorias < datosCategorias.length) {

            Categorias_Equipos llenarDatos = new Categorias_Equipos();

            llenarDatos.setCategoryName(JOptionPane.showInputDialog(null, "Escriba el nombre de la categoria:", "Nombre de la categoría", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setAtributes(JOptionPane.showInputDialog(null, "Escriba las características:", "Caracteristicas", JOptionPane.QUESTION_MESSAGE));

            while (true) {
                String estadoInput = JOptionPane.showInputDialog(null, "Establezca el estado de la categoría (Activo/Inactivo):", "Estado de la categoría", JOptionPane.QUESTION_MESSAGE);

                if (estadoInput.equals("Activo") || estadoInput.equals("activo") || estadoInput.equals("Inactivo") || estadoInput.equals("inactivo")) {
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
                if (nuevoEstado.equals("Activo") && nuevoEstado.equals("activo") || nuevoEstado.equals("Inactivo") && nuevoEstado.equals("inactivo")) {
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
            informacionCategorias = informacionCategorias + "\n - NOMBRE CATEGORÍA: " + datosCategorias[datos].getCategoryName() + "\n - CARACTERÍSTICAS: " + datosCategorias[datos].getAtributes()
                    + "\n - ESTADO DE CATEGORÍA: " + datosCategorias[datos].getCategoryStatus() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, "Las categorías registradas son:\n \n" + informacionCategorias, "Categorías registradas", JOptionPane.INFORMATION_MESSAGE);
    }
//------ MÉTODOS PARA ALMACENAR LOS DATOS DE LOS EQUIPOS
    private Equipos datosEquipos[] = new Equipos[5];
    private int totalEquipos = 0;

    // En la clase donde está definido el menú Equipos
    public void AgregarNuevoEquipo() {
        if (totalEquipos < datosEquipos.length) {

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
            while (true) {
                String nombreUsuario = JOptionPane.showInputDialog(null, "Escriba el nombre de usuario del empleado a cargo del equipo:", "Usuario a cargo", JOptionPane.QUESTION_MESSAGE);
                if (llenarDatos.existeUsuario(nombreUsuario, datosUsuarios)) {
                    llenarDatos.setUser(nombreUsuario);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: El usuario no existe. Por favor, ingrese un usuario válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

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

    // Método para editar el usuario a cargo de un equipo
    public void EditarEmpleado() {
        // Se le solicita al usuario ingresar el nombre del equipo a editar.
        String nombreEquipoEditar = JOptionPane.showInputDialog("Ingrese el nombre del equipo para editar el usuario:");

        // Buscamos el equipo en el arreglo.
        for (int elemento = 0; elemento < totalEquipos; elemento++) {
            if (datosEquipos[elemento] != null && datosEquipos[elemento].getName().equals(nombreEquipoEditar)) {
                // Verificación del nombre del equipo

                // Mensaje informativo.
                JOptionPane.showMessageDialog(null, "Estimado usuario, esta opción edita únicamente el usuario a cargo del equipo.", "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

                // Lógica para editar el usuario a cargo del equipo
                while (true) {
                    String nuevoUsuario = JOptionPane.showInputDialog(null, "Escriba el nuevo nombre del usuario a cargo del equipo:", "Usuario a cargo", JOptionPane.QUESTION_MESSAGE);
                    if (datosEquipos[elemento].existeUsuario(nuevoUsuario, datosUsuarios)) {
                        datosEquipos[elemento].setUser(nuevoUsuario);
                        JOptionPane.showMessageDialog(null, "Usuario a cargo del equipo actualizado correctamente.", "Actualización de Usuario a cargo", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: El usuario no existe. Por favor, ingrese un usuario válido.", "Error", JOptionPane.ERROR_MESSAGE);
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
            informacionEquipos = informacionEquipos + "\n - NOMBRE EQUIPO: " + datosEquipos[datos].getName() + "\n - DESCRIPCIÓN: " + datosEquipos[datos].getDescription()
                    + "\n - ESTADO: " + datosEquipos[datos].getStatusName() + "\n - CATEGORÍA: " + datosEquipos[datos].getCategory()
                    + "\n - SUCURSALES DE PROCEDENCIA: " + datosEquipos[datos].getSucursal() + "\n - EMPLEADO A CARGO: " + datosEquipos[datos].getUser() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, "Los equipos registrados son:\n \n" + informacionEquipos, "Equipos registrados", JOptionPane.INFORMATION_MESSAGE);
    }

    //METODOS DE FACTURACIÓN
    public Facturacion datosFacturacion[] = new Facturacion[15];
    private int totalFacturas = 0;

    public void NuevaFactura() {
        // Crear una nueva instancia de Facturacion
        Facturacion nuevaFactura = new Facturacion();

        // Verificar si el cliente existe
        while (true) {
            String nombreCliente = JOptionPane.showInputDialog(null, "Escriba el nombre del cliente a facturar:", "Cliente a facturar", JOptionPane.QUESTION_MESSAGE);
            if (nuevaFactura.existeCliente(nombreCliente, datosClientes)) {
                nuevaFactura.setClientName(nombreCliente);
                nuevaFactura.setFixDescription(JOptionPane.showInputDialog(null, "Ingrese la descripción de la reparación:", "Nueva Factura", JOptionPane.QUESTION_MESSAGE));
                nuevaFactura.setHour(JOptionPane.showInputDialog(null, "Ingrese la hora (hh:mm) de la compra ", "Nueva Factura", JOptionPane.QUESTION_MESSAGE));
                nuevaFactura.setDate(JOptionPane.showInputDialog(null, "Ingrese la fecha (dd/mm/hhhh) de la compra: ", "Nueva Factura", JOptionPane.QUESTION_MESSAGE));
                nuevaFactura.setTotalToPay(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el costo de la reparación: ", "Nueva Factura", JOptionPane.QUESTION_MESSAGE)));

                // Agregar la nueva factura al arreglo
                datosFacturacion[totalFacturas] = nuevaFactura;
                totalFacturas++;

                JOptionPane.showMessageDialog(null, "Factura creada correctamente.", "Nueva Factura", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Error: El cliente no existe. Por favor, ingrese un cliente válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        ingresosDelDia = ingresosDelDia + nuevaFactura.getTotalToPay();

    }

    public void mostrarFacturas() {
        int datosFactura;
        String informacionFacturas = "";

        // En este bucle "for" obtenemos los "Get" de la información que anteriormente introdujimos en los "Set".
        for (datosFactura = 0; datosFactura < totalFacturas; datosFactura++) {
            informacionFacturas = informacionFacturas
                    + "- FACTURA " + (datosFactura + 1) + ":\n"
                    + "- CLIENTE: " + datosFacturacion[datosFactura].getClientName() + "\n"
                    + "- DESCRIPCIÓN: " + datosFacturacion[datosFactura].getFixDescription() + "\n"
                    + "- HORA: " + datosFacturacion[datosFactura].getHour() + "\n"
                    + "- FECHA: " + datosFacturacion[datosFactura].getDate() + "\n\n"
                    + "- MONTO A PAGAR: ₡" + datosFacturacion[datosFactura].getTotalToPay();
        }

        JOptionPane.showMessageDialog(null, "Facturas ingresadas:\n\n" + informacionFacturas, "Facturas", JOptionPane.INFORMATION_MESSAGE);
    }

//METODOS DE CAJAS
    public void MostraringresosDía() {
        Facturacion infoFecha = new Facturacion();
        String fechaCompleta = JOptionPane.showInputDialog(null, "Ingrese la fecha para mostrar los ingresos del día (dd/mm/hhhh):", "Ingresos del Día", JOptionPane.QUESTION_MESSAGE);

        if (infoFecha.existeFecha(fechaCompleta, datosFacturacion)) {
            String mostrasCajadelDia = "";

            for (int i = 0; i < totalFacturas; i++) {
                Facturacion factura = datosFacturacion[i];
                if (factura != null && factura.getDate().equals(fechaCompleta)) {
                    mostrasCajadelDia += "\n - Cliente: " + factura.getClientName()
                            + "\n - Ingresos del día: " + factura.getTotalToPay() + "\n";
                }
            }

            JOptionPane.showMessageDialog(null, "Los ingresos del día para la fecha " + fechaCompleta + " son: " + mostrasCajadelDia + "El total de ingresos del día es: " + ingresosDelDia, "Cajas", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay ingresos registrados para la fecha ingresada.", "Ingresos del Día", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
