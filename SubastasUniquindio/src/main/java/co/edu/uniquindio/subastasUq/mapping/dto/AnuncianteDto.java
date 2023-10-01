package co.edu.uniquindio.subastasUq.mapping.dto;

import java.util.List;

public record AnuncianteDto(
        String nombre,
        String apellido,
        String cedula,
        Integer edad,
        List<AnuncioDto> anuncios,
        List<ProductoDto>productos,
        UsuarioDto usuarioDto ) {

    @Override
    public String toString(){
        return "Anunciante{" +
                "nombre:" + nombre+ '\''+
                "apellido: "+ apellido + '\''+
                "cedula: "+ cedula+ '\''+
                "edad" + edad + '\''+
                "usuario: "+ usuarioDto+ '\''+
                "}"
                ;
    }



}
