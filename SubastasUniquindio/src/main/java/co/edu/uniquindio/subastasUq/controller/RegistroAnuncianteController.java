package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.controller.service.IRegistroAnuncianteController;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncianteDto;

public class RegistroAnuncianteController  implements IRegistroAnuncianteController {
    ModelFactoryController modelFactoryController;

    public RegistroAnuncianteController(){
        modelFactoryController=ModelFactoryController.getInstance();
    }

    @Override
    public boolean addAnunciante(AnuncianteDto anuncianteDto) {
        return modelFactoryController.addAnunciante(anuncianteDto);
    }
}
