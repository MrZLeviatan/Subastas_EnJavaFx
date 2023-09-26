package co.edu.uniquindio.subastasUq.model;

public class Comprador extends Persona{

    private String direccion;

    private Usuario usuario;

    public Comprador(String nombre, String apellido, String cedula, Integer edad, String direccion, Usuario usuario) {
        super(nombre, apellido, cedula, edad);
        this.direccion = direccion;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
