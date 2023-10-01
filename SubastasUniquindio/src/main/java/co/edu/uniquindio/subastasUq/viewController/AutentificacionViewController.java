package co.edu.uniquindio.subastasUq.viewController;

import co.edu.uniquindio.subastasUq.controller.AutentificacionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
            //aca carga la ventana de anunciante
        } else if (autentificacionServices.autentificarComprador(txtUsario.getText(),txtContraseña.getText())) {
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClass().getResource("panelAnunciante,fxml"));
            Scene scene= new Scene(fxmlLoader.load());

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

}
