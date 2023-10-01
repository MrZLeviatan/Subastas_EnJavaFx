package co.edu.uniquindio.subastasUq.mapping.dto;

import co.edu.uniquindio.subastasUq.model.Anuncio;
import co.edu.uniquindio.subastasUq.model.Producto;

import java.util.List;

public record AnuncianteDto(
        String nombre,
        String apellido,
        String cedula,
        Integer edad,
        List<AnuncioDto> anuncios,
        List<ProductoDto>productos,
        UsuarioDto usuarioDto ) {
}
// SE PUEDE USAR USERNAME EN USUARIO
// LOS SERVICE
//