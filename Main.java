package proyectofixtech;


public class Main {

 
    public static void main(String[] args) {

        ProcesoMetodos procesoMetodos = new ProcesoMetodos();
        Menu menu = new Menu(procesoMetodos);
        menu.mostrarMenu();
        
    }
    
}
