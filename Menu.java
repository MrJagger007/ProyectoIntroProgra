package proyectofixtech;

import javax.swing.JOptionPane;

public class Menu {

    private ProcesoMetodos procesoMetodos;

    public Menu(ProcesoMetodos procesoMetodos) {
        this.procesoMetodos = procesoMetodos;
    }

    public void mostrarMenu() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(" Menú Principal:\n"
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
                    accionesCategoriasEquipos();
                    break;
                case "5":
                    accionesEquipos();
                    break;
                case "6":
                    accionesFacturacion();
                    break;
                case "7":
                    procesoMetodos.MostraringresosDia();
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
                    // Llamamos al método AgregarClientes de ProcesoMetodos
                    procesoMetodos.AgregarClientes();
                    break;
                case "2":
                    // Llamamos al método EliminarCliente de ProcesoMetodos
                    procesoMetodos.EliminarCliente();
                    break;
                case "3":
                    // Lógica para inactivar cliente
                    procesoMetodos.Estadocliente();
                    break;
                case "4":
                    // Llamamos al método EditarCliente de ProcesoMetodos
                    procesoMetodos.EditarCliente();
                    break;
                case "5":
                    // Llama al método MostrarClientes de ProcesoMetodos
                    procesoMetodos.MostrarClientes();
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
                    // Llamamos al método AgregarUsuarios de ProcesoMetodos
                    procesoMetodos.AgregarUsuarios();
                    break;
                case "2":
                    // Llamamos al método EliminarUsuario de ProcesoMetodos
                    procesoMetodos.EliminarUsuario();
                    break;
                case "3":
                    // Lógica para inactivar usuario
                    procesoMetodos.EstadoUsuario();
                    break;
                case "4":
                    // Llamamos al método EditarUsuario de ProcesoMetodos
                    procesoMetodos.EditarUsuario();
                    break;
                case "5":
                    // Llama al método MostrarUsuarios de ProcesoMetodos
                    procesoMetodos.MostrarUsuarios();
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
                    procesoMetodos.AgregarSucursales();
                    break;
                case "2":
                    // Llamamos al método EliminarSucursal de la clase Catalogos
                    procesoMetodos.EliminarSucursal();
                    break;
                case "3":
                    // Llamamos al método InactivarSucursal de la clase Catalogos
                    procesoMetodos.EstadoSucursal();
                    break;
                case "4":
                    // Llamamos al método EditarSucursal de la clase Catalogos
                    procesoMetodos.EditarSucursal();
                    break;
                case "5":
                    // Llama al método MostrarSucursales de la clase Catalogos
                    procesoMetodos.MostrarSucursales();
                    break;
                case "6":
                    return; // Regresa al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del menú.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void accionesCategoriasEquipos() {
        while (true) {
            String opcionCategoria = JOptionPane.showInputDialog("Acciones categoría de equipos:\n"
                    + "1. Agregar categorías\n"
                    + "2. Editar categoría\n"
                    + "3. Editar característica\n"
                    + "4. Editar estado categoría\n"
                    + "5. Mostrar categorías\n"
                    + "6. Regresar");

            switch (opcionCategoria) {
                case "1":
                    // Llamamos al método AgregarInformacionCategoria de la clase Catalogos
                    procesoMetodos.AgregarInformacionCategoria();
                    break;
                case "2":
                    // Llamamos al método EditarCategoria de la clase Catalogos
                    procesoMetodos.EditarCategoria();
                    break;
                case "3":
                    // Llamamos al método EditarCaracteristicaCategoria de la clase Catalogos
                    procesoMetodos.EditarCaracteristicaCategoria();
                    break;
                case "4":
                    // Llamamos al método EditarEstadoCategoria de la clase Catalogos
                    procesoMetodos.EditarEstadoCategoria();
                    break;
                case "5":
                    // Llamamos al método MostrarCategoria de la clase Catalogos
                    procesoMetodos.MostrarCategoria();
                    break;
                case "6":
                    return; // Regresa al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del menú.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void accionesEquipos() {
        while (true) {
            String opcionCategoria = JOptionPane.showInputDialog("Acciones de equipos:\n"
                    + "1. Agregar nuevo equipo\n"
                    + "2. Editar equipo\n"
                    + "3. Editar categoría del equipo\n"
                    + "4. Editar empleado a cargo del equipo\n"
                    + "5. Editar sucursal de procedencia del equipo\n"
                    + "6. Editar estado del equipo\n"
                    + "7. Mostrar equipos\n"
                    + "8. Regresar");

            switch (opcionCategoria) {
                case "1":
                    // Llamamos al método AgregarNuevoEquipo de la clase Catalogos
                    procesoMetodos.AgregarNuevoEquipo();
                    break;
                case "2":
                    // Llamamos al método EditarEquipo de la clase Catalogos
                    procesoMetodos.EditarEquipo();
                    break;
                case "3":
                    // Llamamos al método EditarCategoriaEquipo de la clase Catalogos
                    procesoMetodos.EditarCategoriaEquipo();
                    break;
                case "4":
                    // Lógica para editar empleado a cargo del equipo
                    procesoMetodos.EditarEmpleado();
                    break;
                case "5":
                    // Llamamos al método EditarSucursalEquipo de la clase Catalogos
                    procesoMetodos.EditarSucursalEquipo();
                    break;
                case "6":
                    // Lógica para editar estado del equipo
                    procesoMetodos.EditarEstadoEquipo();
                    break;
                case "7":
                    // Llamamos al método MostrarEquipos de la clase Catalogos
                    procesoMetodos.MostrarEquipos();
                    break;
                case "8":
                    return; // Regresa al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del menú.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void accionesFacturacion() {
        while (true) {
            String opcionFacturacion = JOptionPane.showInputDialog("Acciones Facturación:\n"
                    + "1. Nueva factura\n"
                    + "2. Editar factura\n"
                    + "3. Anular factura\n"
                    + "4. Mostrar facturas\n"
                    + "5. Regresar");

            switch (opcionFacturacion) {
                case "1":
                    // Lógica para nueva factura
                    procesoMetodos.NuevaFactura();
                    break;
                case "2":
                    // Lógica para editar factura
                    procesoMetodos.EditarFactura();

                    break;
                case "3":
                    // Llamamos al método MostrarFactura de la clase ProcesoMetodos
                    procesoMetodos.AnularFactura();

                    break;
                case "4":
                    // Llamamos al método MostrarFactura de la clase ProcesoMetodos
                    procesoMetodos.mostrarFacturas();
                    break;
                case "5":
                    return; // Regresa al menú principal
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del menú.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        
}
