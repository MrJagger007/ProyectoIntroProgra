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
