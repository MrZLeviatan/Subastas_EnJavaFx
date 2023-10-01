package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.controller.service.IInicioController;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;

import java.util.List;

public class InicioController implements IInicioController {
    ModelFactoryController modelFactoryController;

    public InicioController(){

        modelFactoryController=ModelFactoryController.getInstance();
    }

    @Override
    public List<AnuncioDto> obtenerAnuncios() {
        return modelFactoryController.obtenerAnuncios();
    }

    @Override
    public List<AnuncioDto> filtrarAnuncios(String codigo,String nombreAnunciate,String nombreProducto) {
        return modelFactoryController.filtrarAnuncio(codigo,nombreAnunciate,nombreProducto);
    }
}
