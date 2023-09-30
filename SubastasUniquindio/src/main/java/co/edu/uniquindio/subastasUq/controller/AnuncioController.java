package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;
import co.edu.uniquindio.subastasUq.mapping.dto.ProductoDto;
import co.edu.uniquindio.subastasUq.model.Anuncio;

import java.util.List;

public class AnuncioController {

    ModelFactoryController modelFactoryController;

    public AnuncioController(){
        modelFactoryController=ModelFactoryController.getInstance();
    }

    public List<ProductoDto> obtenerProductos() {
        return modelFactoryController.obtenerProductos();
    }

    public boolean addAnuncio(AnuncioDto anuncioDto) {
        return modelFactoryController.addAnuncio(anuncioDto);
    }
}
