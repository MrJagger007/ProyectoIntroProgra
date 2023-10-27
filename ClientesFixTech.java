package proyectointroprogra;
import javax.swing.JOptionPane;

public class ClientesFixTech {

    
    private String name;
    private String lastname;
    private char status;
  
    
    public ClientesFixTech (){
        
        this.name = "";
        this.lastname = "";
        this.status = 0;
                
                
    }
    public void ClientesFixTexch (){
        name=JOptionPane.showInputDialog(null,"Ingrese el nombre del cliente: ");
        lastname=JOptionPane.showInputDialog(null,"Ingrese el apellido del cliente: ");
        status=(char) JOptionPane.showInputDialog(null,"Seleccione el estado en el que se encuentra su equipo\nA)Ingresado\n B)En reparación\n C)Listo\n D)Entregado").length();
            JOptionPane.showMessageDialog(null,"Nombre completo del cliente: "+name+" "+lastname+"\nEl estado del equipo actualmente es "+status);
        }        
}
