package proyectofinal;

import javax.swing.JOptionPane;

public class Menu {

    private Registro_Clientes_Usuarios informacion;
    private Catalogos informacionCatalogos;

    // Este es nuestro constructor que recibe la instancia de Registro_Clientes_Usuarios
    public Menu(Registro_Clientes_Usuarios informacion, Catalogos informacionCatalogos) {
        this.informacion = informacion;
        this.informacionCatalogos = informacionCatalogos;
    }

    public void mostrarMenu() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(" Menú Principal:\n "
                    + "1. Acciones Cliente\n"
                    + "2. Acciones Usuario\n"
                    + "3. Acciones Sucursales\n"
                    + "4. Acciones Catálogo de Categorías de Equipos\n"
                    + "5. Acciones Catálogo de Equipos\n"
                    + "6. Facturación\n"
                    + "7. Cajas\n"
                    + "8. Salir");

            switch (opcion) {
                case "1":
                    // Acciones Cliente
                    accionesCliente();
                    break;
                case "2":
                    accionesUsuario();
                    break;
                case "3":
                    accionesSucursales();
                    break;
                case "4":
                    AccionesCategoriasEquipos();
                    break;
                case "5":
                    //Acciones Catálogo de Categorías de Equipos\n
                    break;
                case "6":
                    // Facturación 
                    break;
                case "7":
                    // Cajas 
                    break;
                case "8":
                    JOptionPane.showMessageDialog(null, "Saliendo del programa. ¡Hasta luego!", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del menú.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void accionesCliente() {
        while (true) {
            String opcionCliente = JOptionPane.showInputDialog("Acciones Cliente:\n"
                    + "1. Nuevo cliente\n"
                    + "2. Eliminar cliente\n"
                    + "3. Cambiar estado cliente\n"
                    + "4. Editar cliente\n"
                    + "5. Mostrar clientes\n"
                    + "6. Regresar");

            switch (opcionCliente) {
                case "1":
                    // Llamamos al método AgregarClientes de Registro_Clientes_Usuarios
                    informacion.AgregarClientes();
                    break;
                case "2":
                    // Llamamos al método EliminarCliente de Registro_Clientes_Usuarios
                    informacion.EliminarCliente();
                    break;
                case "3":
                    // Lógica para inactivar cliente
                    informacion.Estadocliente();
                    break;
                case "4":
                    // Llamamos al método EditarCliente de Registro_Clientes_Usuarios
                    informacion.EditarCliente();
                    break;
                case "5":
                    // Llama al método MostrarClientes de Registro_Clientes_Usuarios
                    informacion.MostrarClientes();
                    break;
                case "6":
                    return; // Regresar al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del menú.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void accionesUsuario() {
        while (true) {
            String opcionUsuario = JOptionPane.showInputDialog("Acciones Usuario:\n"
                    + "1. Nuevo usuario\n"
                    + "2. Eliminar usuario\n"
                    + "3. Cambiar estado usuario\n"
                    + "4. Editar usuario\n"
                    + "5. Mostrar usuarios\n"
                    + "6. Regresar");

            switch (opcionUsuario) {
                case "1":
                    // Llamamos al método AgregarUsuarios de Registro_Clientes_Usuarios
                    informacion.AgregarUsuarios();
                    break;
                case "2":
                    // Llamamos al método EliminarUsuario de Registro_Clientes_Usuarios
                    informacion.EliminarUsuario();
                    break;
                case "3":
                    // Lógica para inactivar usuario
                    informacion.EstadoUsuario();
                    break;
                case "4":
                    // Llamamos al método EditarUsuario de Registro_Clientes_Usuarios
                    informacion.EditarUsuario();
                    break;
                case "5":
                    // Llama al método MostrarUsuarios de Registro_Clientes_Usuarios
                    informacion.MostrarUsuarios();
                    break;
                case "6":
                    return; // Regresa al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del menú.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void accionesSucursales() {
        while (true) {
            String opcionSucursal = JOptionPane.showInputDialog("Acciones Sucursal:\n"
                    + "1. Nueva sucursal\n"
                    + "2. Eliminar sucursal\n"
                    + "3. Inactivar sucursal\n"
                    + "4. Editar sucursal\n"
                    + "5. Mostrar sucursales\n"
                    + "6. Regresar");

            switch (opcionSucursal) {
                case "1":
                    // Llamamos al método AgregarSucursales de la clase Catalogos
                    informacionCatalogos.AgregarSucursales();
                    break;
                case "2":
                    // Llamamos al método EliminarSucursal de la clase Catalogos
                    informacionCatalogos.EliminarSucursal();
                    break;
                case "3":
                    // Llamamos al método InactivarSucursal de la clase Catalogos
                    informacionCatalogos.EstadoSucursal();
                    break;
                case "4":
                    // Llamamos al método EditarSucursal de la clase Catalogos
                    informacionCatalogos.EditarSucursal();
                    break;
                case "5":
                    // Llama al método MostrarSucursales de la clase Catalogos
                    informacionCatalogos.MostrarSucursales();
                    break;
                case "6":
                    return; // Regresa al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del menú.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void AccionesCategoriasEquipos() {
        while (true) {
            String opcionCategoria = JOptionPane.showInputDialog("Acciones categoría de equipos:\n"
                    + "1. Información de categorías\n"
                    + "2. Editar categoría\n"
                    + "3. Editar característica\n"
                    + "4. Editar estado categoría\n"
                    + "5. Editar estado categoría\n"
                    + "6. Mostrar\n"
                    + "7. Regresar");

            switch (opcionCategoria) {
                case "1":
                    // Llamamos al método AgregarUsuarios de Registro_Clientes_Usuarios
                    informacionCatalogos.AgregarInformacionCategoria();

                    break;
                case "2":
                    // Llamamos al método EliminarUsuario de Registro_Clientes_Usuarios

                    break;
                case "3":
                    // Lógica para inactivar usuario

                    break;
                case "4":
                    // Llamamos al método EditarUsuario de Registro_Clientes_Usuarios

                    break;
                case "5":
                    // Llama al método MostrarUsuarios de Registro_Clientes_Usuarios
                    break;
                case "6":
                    // Llama al método MostrarUsuarios de Registro_Clientes_Usuarios
                    informacionCatalogos.MostrarCategoria();
                    break;
                case "7":
                    return; // Regresa al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del menú.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
