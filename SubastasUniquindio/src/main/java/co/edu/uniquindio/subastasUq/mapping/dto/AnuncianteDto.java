package co.edu.uniquindio.subastasUq.mapping.dto;

import java.util.List;

public record AnuncianteDto(
        String nombre,
        String apellido,
        String cedula,
        Integer edad,
        UsuarioDto usuarioDto ) {
}
// SE PUEDE USAR USERNAME EN USUARIO
// LOS SERVICE
//