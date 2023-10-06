package co.edu.uniquindio.subastasUq.viewController;

import co.edu.uniquindio.subastasUq.SubastaAplication;
import co.edu.uniquindio.subastasUq.controller.AutentificacionController;
import co.edu.uniquindio.subastasUq.controller.SubastaController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AutentificacionViewController {

    AutentificacionController autentificacionServices;



    @FXML
    private Button btnIngresar;

    @FXML
    private PasswordField txtContraseña;

    @FXML
    private TextField txtUsario;

    @FXML
    private void initialize(){
       autentificacionServices=new AutentificacionController();
    }

    @FXML
    void ingresarUsario(ActionEvent event) throws IOException {
        ingresar();
    }

    private void ingresar() throws IOException {
        if(verificarCampos())
        if(autentificacionServices.auntetificarAnunciante(txtUsario.getText(),txtContraseña.getText())){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SubastaAplication.class.getResource("PanelAnunciante.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();





        } else if (autentificacionServices.autentificarComprador(txtUsario.getText(),txtContraseña.getText())) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SubastaAplication.class.getResource("PanelComprador.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        }
        else {
            mostrarMensaje("seccion invalida","seccion no iniciada", "datos incorrectos verificar", Alert.AlertType.INFORMATION);
        }
    }

    private boolean verificarCampos() {
        String mensaje="";
        if(txtContraseña.getText().isBlank()||txtContraseña==null)
            mensaje+="ingrese una contraseña valida\n";
        if(txtUsario.getText().isBlank()||txtUsario==null)
            mensaje+=" ingrese un usuario valido\n";
        if(mensaje==""){
            return true;
        }
        else {
            mostrarMensaje("Datos incorrectos","Datos invalidos",mensaje, Alert.AlertType.ERROR);
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    public void cambiarVentana(String nombreFxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreFxml));
        loader.setLocation(getClass().getResource(nombreFxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

    }

}
