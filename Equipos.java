package proyectofinal;
import javax.swing.JOptionPane;

public class Equipos {

    private String name, description, user, sucursal, category, statusName;
    private int totalEquipos = 0;

    public Equipos() {

        this.name = "";
        this.description = "";
        this.user = "";
        this.sucursal = "";
        this.category = "";
        this.statusName = "";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    // Realizar revisión a esta parte dado que no se logra llamar a datosUsuarios en la clase Catálogos
    public boolean existeUsuario(String nombreUsuario, Usuarios_FixTech[] datosUsuarios) {
        for (Usuarios_FixTech usuario : datosUsuarios) {
            if (usuario != null && usuario.getUsername().equals(nombreUsuario)) {
                return true; // Usuario encontrado
            }
        }
        return false; // Usuario no encontrado
    }

    // Método para validar la existencia de una categoría en el arreglo de Categorias_Equipos
    public boolean existeCategoria(String nombreCategoria, Categorias_Equipos[] datosCategorias) {
        for (Categorias_Equipos categoria : datosCategorias) {
            if (categoria != null && categoria.getCategoryName().equals(nombreCategoria)) {
                return true; // Categoría encontrada
            }
        }
        return false; // Categoría no encontrada
    }

    // Método para validar la existencia de una sucursal en el arreglo de Sucursales
    public boolean existeSucursal(String nombreSucursal, Sucursales[] datosSucursales) {
        for (Sucursales sucursal : datosSucursales) {
            if (sucursal != null && sucursal.getName().equals(nombreSucursal)) {
                return true; // Sucursal encontrada
            }
        }
        return false; // Sucursal no encontrada
    }
    
}
