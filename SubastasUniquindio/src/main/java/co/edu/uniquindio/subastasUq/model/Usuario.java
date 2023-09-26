package co.edu.uniquindio.subastasUq.model;

public class Usuario {

    private String username;
    private String constrasenia;
    private String correo;


    public Usuario(String username, String constrasenia,String correo) {
        this.username = username;
        this.constrasenia = constrasenia;
        this.correo=correo;
    }

    //CONSTRUCTOR SIN PARAMETROS
    public Usuario() {
        super();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConstrasenia() {
        return constrasenia;
    }

    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    @Override
    public String toString() {  return "Usuario{" + "username='" + username +  ", constrasenia='" + constrasenia + '}';
    }
}
