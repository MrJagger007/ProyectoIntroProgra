package proyectofinal;

import javax.swing.JOptionPane;

public class Registro_Clientes_Usuarios {

    // Arreglo para almacenar información de los usuarios de Fix Tech.
    private Usuarios_FixTech datosUsuarios[] = new Usuarios_FixTech[15];

    // Se desarrolla un contador. No vamos a trabajar con "For" porque se tendrían que llenar una cantidad de datos
    // específicos a la vez, con el contador hacemos que el usuario repita el proceso si asi lo desea.
    private int totalUsuarios = 0;

    // Método para agregar nuevos usuarios
    public void AgregarUsuarios() {

        //De momento se establece que el total de usuario que podrá almacenar el arreglo será de 15.
        if (totalUsuarios < 15) {

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

                if (estadoInput.equals("Activo") || estadoInput.equals("Inactivo")) {
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
            informacionUsuarios = informacionUsuarios + datosUsuarios[datos].getName() + "  " + datosUsuarios[datos].getLastname()
                    + " \n  - ESTADO: " + datosUsuarios[datos].getStatusName() + " \n  - Username: " + datosUsuarios[datos].getUsername() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, "Los usuarios registrados son:\n \n" + informacionUsuarios, "Usuarios registrados", JOptionPane.INFORMATION_MESSAGE);

    }
    

    //Esta parte no se va a comentar dado que sigue exactamente la misma lógica que se usó para Usuarios_FixTech
    private Clientes_FixTech datosClientes[] = new Clientes_FixTech[30];
    private int totalClientes = 0;

    public void AgregarClientes() {

        if (totalClientes < 30) {

            Clientes_FixTech llenarDatos = new Clientes_FixTech();
            llenarDatos.setName(JOptionPane.showInputDialog(null, "Escriba el nombre del cliente:", "Nombre del Cliente", JOptionPane.QUESTION_MESSAGE));
            llenarDatos.setLastname(JOptionPane.showInputDialog(null, "Escriba el apellido del cliente:", "Apellido del Cliente", JOptionPane.QUESTION_MESSAGE));

            // Establecemos un bucle "while" para garantizar que se ingrese correctamente "Activo" o "Inactivo"
            while (true) {
                String estadoInput = JOptionPane.showInputDialog(null, "Establezca el estado del cliente (Activo/Inactivo):", "Estado del Cliente", JOptionPane.QUESTION_MESSAGE);

                if (estadoInput.equals("Activo") || estadoInput.equals("Inactivo")) {
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
        String clienteAEliminar = JOptionPane.showInputDialog("Ingrese el nombre de usuario a eliminar:");

        for (int indiceUsuario = 0; indiceUsuario < totalClientes; indiceUsuario++) {

            if (datosClientes[indiceUsuario] != null && datosClientes[indiceUsuario].getName().equals(clienteAEliminar)) {
                if (indiceUsuario < totalClientes - 1) {
                    for (int posicionUsuario = indiceUsuario; posicionUsuario < totalClientes - 1; posicionUsuario++) {
                        datosClientes[posicionUsuario] = datosClientes[posicionUsuario + 1];
                    }
                }
                datosClientes[totalClientes - 1] = null;

                totalClientes--;
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.", "Eliminación de Usuario", JOptionPane.INFORMATION_MESSAGE);
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
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente:");
                String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente:");
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
            informacionClientes = informacionClientes + datosClientes[datos].getName() + "  " + datosClientes[datos].getLastname()
                    + " \n  - ESTADO: " + datosClientes[datos].getStatus() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, "Los clientes registrados son:\n \n" + informacionClientes, "Clientes registrados", JOptionPane.INFORMATION_MESSAGE);

    }

}