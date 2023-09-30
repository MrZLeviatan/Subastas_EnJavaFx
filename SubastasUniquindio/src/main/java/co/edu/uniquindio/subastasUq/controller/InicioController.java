package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;

public class InicioController {
    ModelFactoryController modelFactoryController;

    public InicioController(){
        modelFactoryController=ModelFactoryController.getInstance();
    }

    public AnuncioDto obtenerProductos() {

    }
}
