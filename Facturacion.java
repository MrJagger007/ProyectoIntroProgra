package proyectointroprogra;

import javax.swing.JOptionPane;

public class Facturacion {

    private String date;
    private String hour;
    private String description;
    private int total_payment;

    public Facturacion() {

        this.date = "";
        this.hour = "";
        this.description = "";
        this.total_payment = 0;
    }
    
    public void Facturacion(){
        date=JOptionPane.showInputDialog(null,"Ingrese la fecha actual: ");
        hour=JOptionPane.showInputDialog(null,"ingrese la hora actual: ");
        description=JOptionPane.showInputDialog(null,"Ingrese la descripcion de la compra: ");
        JOptionPane.showMessageDialog(null,"La fecha de la compra es: "+date+"\nLa hora de la compra fue: "+hour+"El precio total de la compra es de: "+total_payment);
    }
}