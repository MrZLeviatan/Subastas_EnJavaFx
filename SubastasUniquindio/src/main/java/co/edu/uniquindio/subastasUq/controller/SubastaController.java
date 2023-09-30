package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.controller.service.ISubastaController;

public class SubastaController implements ISubastaController {
    ModelFactoryController modelFactoryController;

    public SubastaController(){
        modelFactoryController= ModelFactoryController.getInstance();
    }
}
