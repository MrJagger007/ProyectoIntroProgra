package proyectofixtech;

public class Facturacion {

    private String clientName, hour, date, fixDescription;
    private double totalToPay;

    public Facturacion() {

        this.clientName = "";
        this.hour = "";
        this.date = "";
        this.fixDescription = "";
        this.totalToPay = 0.00;

    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFixDescription() {
        return fixDescription;
    }

    public void setFixDescription(String fixDescription) {
        this.fixDescription = fixDescription;
    }

    public double getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(double totalToPay) {
        this.totalToPay = totalToPay;
    }

    
    // Método para validar la existencia de un cliente en el arreglo de Clientes_FixTech
public boolean existeCliente(String nombreCliente, Clientes_FixTech[] datosClientes) {
    int i;
    for (i = 0; i < datosClientes.length; i++) {
        Clientes_FixTech cliente = datosClientes[i];
        if (cliente != null && cliente.getName().equals(nombreCliente)) {
            return true; // Cliente encontrado
        }
    }
    return false; // Cliente no encontrado
}
    
public boolean existeFecha(String fechaFactura, Facturacion[] datosFacturacion) {
    int i= 0;
    for (i = 0; i < datosFacturacion.length; i++) {
        Facturacion factura = datosFacturacion[i];
        if (factura != null && factura.getDate().equals(fechaFactura)) {
            return true; // Fecha encontrada
        }
    }
    return false; // Fecha no encontrada
}
}
