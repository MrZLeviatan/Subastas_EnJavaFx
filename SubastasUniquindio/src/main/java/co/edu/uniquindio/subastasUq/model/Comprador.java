package co.edu.uniquindio.subastasUq.model;

public class Comprador extends Persona{

    private String direccion;

    private Usuario usuario;


    public Comprador() {

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
