package co.edu.uniquindio.SubastasUniquindio.model;

public class Comprador extends Persona {

    private  Usuario usuario;

    public Comprador(String nombre, String apellido, String cedula, Integer edad,Usuario usuario) {
        super(nombre, apellido, cedula, edad);
        this.usuario=usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
