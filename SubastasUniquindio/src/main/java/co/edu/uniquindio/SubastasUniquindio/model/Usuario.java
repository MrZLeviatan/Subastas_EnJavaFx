package co.edu.uniquindio.SubastasUniquindio.model;

public class Usuario {
    private String correo;
    private String contraseña;

    public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }
}
