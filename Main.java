package proyectofinal;

public class Main {

    public static void main(String[] args) {

        Registro_Clientes_Usuarios informacion = new Registro_Clientes_Usuarios();
        Catalogos informacionCatalogos = new Catalogos();
        Menu menu = new Menu(informacion, informacionCatalogos);
        menu.mostrarMenu();

    }

}
