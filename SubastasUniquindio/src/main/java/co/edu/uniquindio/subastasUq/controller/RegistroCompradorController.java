package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.controller.service.IRegistroCompradorController;
import co.edu.uniquindio.subastasUq.mapping.dto.CompradorDto;

public class RegistroCompradorController implements IRegistroCompradorController {


    ModelFactoryController modelFactoryController;
    public RegistroCompradorController(){
        modelFactoryController=ModelFactoryController.getInstance();
    }

    @Override
    public boolean agregarComprador(CompradorDto compradorDto){
        return modelFactoryController.addComprador(compradorDto);
    }

}
