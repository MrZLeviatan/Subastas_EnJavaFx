package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.controller.service.IAutentifacionController;

public class AutentificacionController implements IAutentifacionController {

    ModelFactoryController modelFactoryController;

    public AutentificacionController(){
        modelFactoryController=ModelFactoryController.getInstance();
    }

    @Override
    public boolean auntetificarAnunciante(String correo, String contraseña) {
        return modelFactoryController.autentificacionAnunciante(correo,contraseña);
    }

    @Override
    public boolean autentificarComprador(String correo, String contraseña) {
        return modelFactoryController.autentificacionComprador(correo,contraseña);
    }
}
