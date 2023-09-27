package co.edu.uniquindio.subastasUq.mapping.dto;

public record CompradorDto(
        String nombre,
        String apellido,
        String cedula,
        Integer edad,
        String direccion,

        UsuarioDto usuarioDto
) {
}
