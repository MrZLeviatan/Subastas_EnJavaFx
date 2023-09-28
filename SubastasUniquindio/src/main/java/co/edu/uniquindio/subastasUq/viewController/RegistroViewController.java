package co.edu.uniquindio.subastasUq.viewController;

import co.edu.uniquindio.subastasUq.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.subastasUq.mapping.dto.CompradorDto;
import co.edu.uniquindio.subastasUq.mapping.dto.UsuarioDto;
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

    private AnuncianteDto construirEmpleadoDto() {
        return new AnuncianteDto(
                txtNombre.getText(),
                "apellido",
                //txtApellido.getText(),
                txtCedula.getText(),
                12,
                new UsuarioDto(
                        txtUsuario.getText(),
                        txtContraseña.getText(),
                        "correo"
                )
        );
    }

    private CompradorDto construirCompradorDto(){
        return new CompradorDto(
                txtNombre.getText(),
                "apellido",
                txtCedula.getText(),
                12,
                txtDireccion.getText(),
                new UsuarioDto(
                        "nombreUsuari0",
                        txtContraseña.getText(),
                        txtUsuario.getText()
                )
        );
    }

    private boolean datosValidosCompradorDto(CompradorDto compradorDto){
        String mensaje= "";
        if(compradorDto.nombre()==null||compradorDto.nombre().isBlank())
            mensaje+= "el nombre es invalido \n";
        if(compradorDto.apellido()==null||compradorDto.apellido().isBlank())
            mensaje+= "el apellido es invalido \n";
        if(compradorDto.cedula()==null||compradorDto.cedula().isBlank())
            mensaje+= "la cedula es invalida \n";
        if (compradorDto.edad()==null)
            mensaje+= "la edad es invalida \n";
        if(compradorDto.direccion()==null||compradorDto.direccion().isBlank())
            mensaje+= "la direccion es invalida \n";
        if(compradorDto.usuarioDto()==null)
            mensaje+= "usuario invalid?? \n";
        if(compradorDto.usuarioDto().correo()==null)
            mensaje+= "el correo es invalido\n";
        if(compradorDto.usuarioDto().contrasena()==null||compradorDto.usuarioDto().contrasena().isBlank())
            mensaje+= "la contraseña es invalida \n";
        if(compradorDto.usuarioDto().username()==null|| compradorDto.usuarioDto().username().isBlank())
            mensaje+= "la contraseña es invalida \n";
        if(mensaje=="")
            return true;
        else {
            mostrarMensaje("notificacion comprador", "Datos invalidos", mensaje,Alert.AlertType.WARNING);
            return false;
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
        if(anuncianteDto.usuarioDto().username()==null||anuncianteDto.usuarioDto().username().isBlank())
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
