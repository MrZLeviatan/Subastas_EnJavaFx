package co.edu.uniquindio.subastasUq.viewController;

import co.edu.uniquindio.subastasUq.mapping.dto.AnuncianteDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class RegistroViewController {

    @FXML
    private DatePicker DpFechaNacimiento;

    @FXML
    private TextField TxtCorreo;

    @FXML
    private Button btnRegistrar;

    @FXML
    private CheckBox checkBoxComprador;

    @FXML
    private CheckBox chetBoxAnunciante;

    @FXML
    private Text textRegistro;

    @FXML
    private Text textRegistro1;

    @FXML
    private Text textRegistro11;

    @FXML
    private Text textRegistro12;

    @FXML
    private Text textRegistro121;

    @FXML
    private Text textRegistro13;

    @FXML
    private Text textRegistro14;

    @FXML
    private Text textRegistro2;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtUsuario;

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
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, Alert.AlertType.WARNING);
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

    @FXML
    void Registar(ActionEvent event) {



    }

}
