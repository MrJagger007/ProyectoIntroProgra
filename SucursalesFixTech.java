package proyectointroprogra;
import javax.swing.JOptionPane;

public class SucursalesFixTech {

    private String nameBranch;
    private String cityBranch;
    private String branchAdress;
    private String branchTelephone;
    private String email;
    private String branchStatus;

    public SucursalesFixTech() {
        this.nameBranch = "";
        this.cityBranch = "";
        this.branchAdress = "";
        this.branchTelephone = "";
        this.email = "";
        this.branchStatus = "";
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public void setCityBranch(String cityBranch) {
        this.cityBranch = cityBranch;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public void setBranchTelephone(String branchTelephone) {
        this.branchTelephone = branchTelephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBranchStatus(String branchStatus) {
        this.branchStatus = branchStatus;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public String getCityBranch() {
        return cityBranch;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public String getBranchTelephone() {
        return branchTelephone;
    }

    public String getEmail() {
        return email;
    }

    public String getBranchStatus() {
        return branchStatus;
    }

    // Método para mostrar un mensaje de bienvenida
    public void showWelcomeMessage() {
        JOptionPane.showMessageDialog(null, "Bienvenido a la sucursal " + nameBranch);
    }

//arreglos de agregar
//editar
//inactivar información
/*Al agregar un equipo, por ejemplo, debe verificar que
la categoría a la que corresponde exista en el respectivo medio de
almacenamiento. Además, verificará que el equipo no se encuentre
registrado. En caso de que exista, deberá mostrar un mensaje
informativo.*/

    public void FixTechInformation() {
        nameBranch = JOptionPane.showInputDialog(null, "Introduzca el nombre de la sucursal: ");
        cityBranch = JOptionPane.showInputDialog(null,"Introduzca la ciudad de la sucursal: ");
        branchAdress = JOptionPane.showInputDialog(null,"Introduzca la dirección de la sucursal: ");
        branchTelephone = JOptionPane.showInputDialog(null,"Introduzca el número de teléfono de la sucursal: ");
        email=JOptionPane.showInputDialog(null,"Ingrese el correo electronico de la sucursal: ");
        branchStatus = JOptionPane.showInputDialog(null,"¿La sucursal se encuentra abierta o cerrada? ");
        JOptionPane.showMessageDialog(null, "El nombre de la sucursal es "+nameBranch+" esta se encuentra en la ciudad de "+cityBranch+ ". ademas la direccion de la misma es "+branchAdress+".\nTelefono: " +branchTelephone+"\nDireccion de correo electronico: "+email+"\nActualmente la tienda se encuentra "+branchStatus);
        
    }

}
