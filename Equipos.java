package proyectofinal;

public class Equipos {

    private String nombre;
    private String marca;
    private String modelo;
    private String estado;

    public Equipos() {
        this.nombre = "";
        this.marca = "";
        this.modelo = "";
        this.estado = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
