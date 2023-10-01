package co.edu.uniquindio.subastasUq.viewController;

import co.edu.uniquindio.subastasUq.controller.RegistroAnuncianteController;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;
import co.edu.uniquindio.subastasUq.mapping.dto.UsuarioDto;
import co.edu.uniquindio.subastasUq.model.Anunciante;
import co.edu.uniquindio.subastasUq.model.Anuncio;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.util.List;

public class RegistroAnuncianteViewController {

    ObservableList<AnuncianteDto>anunciantesDto= FXCollections.observableArrayList();

    RegistroAnuncianteController registroAnuncianteService;

    SubastaViewController subastaViewController;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Text textRegistro;

    @FXML
    private Text textRegistro1;

    @FXML
    private Text textRegistro11;

    @FXML
    private Text textRegistro12;

    @FXML
    private Text textRegistro13;

    @FXML
    private Text textRegistro14;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtApellido;


    @FXML
    public void initialize(){
       registroAnuncianteService=new RegistroAnuncianteController();
       limpiarCampos();
       subastaViewController=new SubastaViewController();
    }


    public boolean verificacion () {

        String mensaje = "";
        if (!txtCedula.getText().isEmpty());

        try {
            Integer.parseInt(txtCedula.getText());
        }catch (NumberFormatException e){
            mensaje += "El campo cedula debe ser numerico \n";
            mostrarMensaje("notificacion comprador", "Datos invalidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }

        if (!txtEdad.getText().isEmpty());

        try {
            Integer.parseInt(txtEdad.getText());
        }catch (NumberFormatException e){
            mensaje += "El campo edad debe ser numerico \n";
            mostrarMensaje("notificacion comprador", "Datos invalidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }


        return true;
    }


    @FXML
    void registrarAnunciante(ActionEvent event) {
        registrar();
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEdad.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");
        txtCorreo.setText("");
    }


    private void registrar() {
        AnuncianteDto anuncianteDto= construirAnuncianteDto();
        if(datosValidosAnuniante(anuncianteDto)) {
            if (verificacion()) {
                if (registroAnuncianteService.addAnunciante(anuncianteDto)) {
                    mostrarMensaje("Notificación anunciante", "Anunciante creado", "El anunciante se ha creado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCampos();
                } else {
                    mostrarMensaje("Notificacion anunciante", "anunciante no creado", "los datos ingresados son invalidos", Alert.AlertType.ERROR);
                }

            } else {
                mostrarMensaje("Notificacion anunciante", "anunciante no creado", "los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }
        }



    }


    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private AnuncianteDto construirAnuncianteDto() {
        if (verificacion()) {
            return new AnuncianteDto(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtCedula.getText(),
                    Integer.parseInt(txtEdad.getText()),
                    null,
                    null,
                    new UsuarioDto(
                            txtContraseña.getText(),
                            txtCorreo.getText(), txtUsuario.getText()
                    )
            );
        }else {
            return null;
        }
    }

    private boolean datosValidosAnuniante(AnuncianteDto anuncianteDto) {
        String mensaje = "";
        if(anuncianteDto.nombre() == null || anuncianteDto.nombre().isBlank())
            mensaje += "El nombre es invalido \n" ;
        if(anuncianteDto.apellido() == null || anuncianteDto.apellido().isBlank())
            mensaje += "El apellido es invalido \n" ;
        if(anuncianteDto.cedula() == null || anuncianteDto.cedula().isBlank())
            mensaje += "El documento es invalido \n" ;
        if(anuncianteDto.edad() == null)
            mensaje += "La edad es invalida \n" ;
        if(anuncianteDto.usuarioDto()==null)
            mensaje+= "el usario es invalido \n";
        if(anuncianteDto.usuarioDto().Usuario()==null||anuncianteDto.usuarioDto().Usuario().isBlank())
            mensaje+= "el nombre de usario es invalido  \n";
        if(anuncianteDto.usuarioDto().correo()==null||anuncianteDto.usuarioDto().correo().isBlank())
            mensaje+=" el correo es invalido \n";
        if(anuncianteDto.usuarioDto().contrasena()==null||anuncianteDto.usuarioDto().contrasena().isBlank())
            mensaje+= " la contraseña es invalida \n";
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación anunciante","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

}
