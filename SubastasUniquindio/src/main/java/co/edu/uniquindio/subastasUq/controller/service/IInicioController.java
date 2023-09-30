package co.edu.uniquindio.subastasUq.controller.service;

import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;

import java.util.List;

public interface IInicioController {
    List<AnuncioDto> obtenerAnuncios();

    List<AnuncioDto> filtrarAnuncios(String codigo,String nombreAnunciate,String nombreProducto);
}
