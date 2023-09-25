package co.edu.uniquindio.SubastasUniquindio.mapping.dto;

import co.edu.uniquindio.SubastasUniquindio.model.Usuario;

public record UsuarioDto(
        String nombre,
        String apellido,
        String cedula,
        String edad,
        String correo,
        String contraseña,
        Usuario usuario
        ) {
}
