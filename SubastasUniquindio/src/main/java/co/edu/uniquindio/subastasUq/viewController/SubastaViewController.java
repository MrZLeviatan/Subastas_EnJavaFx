package co.edu.uniquindio.subastasUq.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SubastaViewController {

    @FXML
    private Tab interfasRegistro;

    @FXML
    private Tab interfazAutenticacion;
    @FXML
    private TabPane tapSubasta;
    @FXML
    private Tab tapAutentificacion;



    @FXML
    private Tab tapRegistro;

    @FXML
    private Tab tapRegistroComprador;
    AutentificacionViewController anuncioViewController;
    RegistroAnuncianteViewController registroAnuncianteViewController;
    RegistroCompradorViewController registroCompradorViewController;


    @FXML
    private void initialize(){
       // tabPaneLogin.getTabs().remove(tapRegistro);
    }


    public SubastaViewController(){

    }









}
