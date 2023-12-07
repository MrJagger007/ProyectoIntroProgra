package proyectofinal;

public class Main {

    public static void main(String[] args) {

        Registro_Clientes_Usuarios informacion = new Registro_Clientes_Usuarios();
        Catalogos informacionCatalogos = new Catalogos();
        Proceso_Facturacion_Cajas informacionMonetaria = new Proceso_Facturacion_Cajas();
        Menu menu = new Menu(informacion, informacionCatalogos, informacionMonetaria);
        menu.mostrarMenu();

    }

}
