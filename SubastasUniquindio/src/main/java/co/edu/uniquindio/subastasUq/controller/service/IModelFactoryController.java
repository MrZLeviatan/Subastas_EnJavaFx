package co.edu.uniquindio.subastasUq.controller.service;

import co.edu.uniquindio.subastasUq.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;
import co.edu.uniquindio.subastasUq.mapping.dto.CompradorDto;
import co.edu.uniquindio.subastasUq.mapping.dto.ProductoDto;

public interface IModelFactoryController {
    boolean addComprador(CompradorDto compradorDto);

    boolean addAnunciante(AnuncianteDto anuncianteDto);

    void addProducto(ProductoDto productoDto, String cc);

    boolean addAnuncio(AnuncioDto anuncioDto, String cedula);


}

