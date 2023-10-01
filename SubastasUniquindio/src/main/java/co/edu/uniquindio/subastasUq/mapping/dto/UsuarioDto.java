package co.edu.uniquindio.subastasUq.mapping.dto;

public record UsuarioDto(
        String contrasena
        , String correo
        , String Usuario
) {
    @Override
    public String toString(){
        return "UsuarioDto{"+
                "contraseña: "+contrasena +'\''+
                "correo"+ correo+'\''+
                "usuario: "+ Usuario+ '\'';
    }
}
