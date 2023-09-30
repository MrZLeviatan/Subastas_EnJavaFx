package co.edu.uniquindio.subastasUq.controller.service;

import co.edu.uniquindio.subastasUq.exceptions.AnuncianteException;
import co.edu.uniquindio.subastasUq.exceptions.CompradorException;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;
import co.edu.uniquindio.subastasUq.mapping.dto.CompradorDto;
import co.edu.uniquindio.subastasUq.mapping.dto.ProductoDto;

public interface IModelFactoryController {
    boolean addComprador(CompradorDto compradorDto);

    boolean deleteComprador(String cc) throws CompradorException;

    boolean deleteAnunciante(String cedula) throws AnuncianteException;

    boolean addAnunciante(AnuncianteDto anuncianteDto);
    void addProducto(ProductoDto productoDto);

    boolean addAnuncio(AnuncioDto anuncioDto);

    boolean autentificacionAnunciante(String correo, String contraseña);

    boolean autentificacionComprador(String correo, String contraseña);

}

