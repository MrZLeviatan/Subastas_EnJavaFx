package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.controller.service.ISubastaController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SubastaController implements ISubastaController {
    ModelFactoryController modelFactoryController;

    public SubastaController(){
        modelFactoryController= ModelFactoryController.getInstance();
    }


}
