package co.edu.uniquindio.subastasUq.mapping.dto;

import java.util.List;

public record AnuncianteDto(
        String nombre,
        String apellido,
        String cedula,
        String edad,
        List<AnuncioDto> anuncios,
        List<ProductoDto>productos,
        UsuarioDto usuarioDto ) {
}
// SE PUEDE USAR USERNAME EN USUARIO
// LOS SERVICE
//