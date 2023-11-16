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
    
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    //ARREGLO USUARIOS
    UsuariosFixTech[] usuarios = new UsuariosFixTech[10]

//agregar
    public void UsuariosFixTech (){
        for (int i = 0; i < usuarios.length; i++) {
        name= JOptionPane.showInputDialog(null,"Introduzca su nombre: ");
        lastname=JOptionPane.showInputDialog(null,"Introduzca su apellido: ");
        username=JOptionPane.showInputDialog(null,"Introduzca su nombre de usuario: ");
        password=JOptionPane.showInputDialog(null,"Introduzca su contraseña: ");
        JOptionPane.showMessageDialog(null,"Bienvenido "+username);
        usuarios[i] = new UsuariosFixTech(name, lastname, 0, password, username); //buscar entrega de pescera ahí está lo de agregar usuario

    }
//consultar

public void consultarUsuario(){




    
}


//inactivar usuario


}
