package proyectointroprogra;
import javax.swing.JOptionPane;

public class UsuariosFixTech {

    private String name;
    private String lastname;
    private String username;
    private String password;
    private char status;

    public UsuariosFixTech() {

        this.name = "";
        this.lastname = "";
        this.status = 0;
        this.password= "";
        this.username= "";
        
    }
    public void UsuariosFixTech (){
        name= JOptionPane.showInputDialog(null,"Introduzca su nombre: ");
        lastname=JOptionPane.showInputDialog(null,"Introduzca su apellido: ");
        username=JOptionPane.showInputDialog(null,"Introduzca su nombre de usuario: ");
        password=JOptionPane.showInputDialog(null,"Introduzca su contraseña: ");
        JOptionPane.showMessageDialog(null,"Bienvenido "+username);
    }
}
