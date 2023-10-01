package co.edu.uniquindio.subastasUq.viewController;
import co.edu.uniquindio.subastasUq.controller.RegistroCompradorController;
import co.edu.uniquindio.subastasUq.exceptions.CompradorException;
import co.edu.uniquindio.subastasUq.mapping.dto.CompradorDto;
import co.edu.uniquindio.subastasUq.mapping.dto.UsuarioDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegistroCompradorViewController {

    RegistroCompradorController registroCompradorController;
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
    private TextField txtApellido;

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

    @FXML
    private TextField txtCorreo;

    @FXML
    void initialize() {
      registroCompradorController = new RegistroCompradorController();
    }


    @FXML
    void registrarComprador(ActionEvent event) throws CompradorException {
        registar();
    }


    public boolean verificacion () {

        String mensaje = "";
        if (!txtCedula.getText().isBlank());

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


    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEdad.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
    }

    //metodo para crear un compradorDto
    private CompradorDto construirCompradorDto() {
        if (verificacion()) {
            return new CompradorDto(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtCedula.getText(),
                    Integer.parseInt(txtEdad.getText()),
                    txtDireccion.getText(),
                    new UsuarioDto(txtContraseña.getText()
                            , txtCorreo.getText()
                            , txtUsuario.getText()
                    )
            );
        }else {
             return null;
        }
    }

    private boolean datosValidosCompradorDto(CompradorDto compradorDto) {
        String mensaje = "";
        if (compradorDto.nombre() == null || compradorDto.nombre().isBlank())
            mensaje += "el nombre es invalido \n";
        if (compradorDto.apellido() == null || compradorDto.apellido().isBlank())
            mensaje += "el apellido es invalido \n";
        if (compradorDto.cedula() == null || compradorDto.cedula().isBlank())
            mensaje += "la cedula es invalida \n";
        if (compradorDto.edad() == null)
            mensaje += "la edad es invalida \n";
        if (compradorDto.direccion() == null || compradorDto.direccion().isBlank())
            mensaje += "la direccion es invalida \n";
        if (compradorDto.usuarioDto() == null)
            mensaje += "usuario invalid?? \n";
        if (compradorDto.usuarioDto().correo() == null)
            mensaje += "el correo es invalido\n";
        if (compradorDto.usuarioDto().contrasena() == null || compradorDto.usuarioDto().contrasena().isBlank())
            mensaje += "la contraseña es invalida \n";
        if (mensaje == "")
            return true;
        else {
            mostrarMensaje("notificacion comprador", "Datos invalidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }



    private void registar() {
        CompradorDto compradorDto = construirCompradorDto();
        System.out.println(compradorDto);
        if (datosValidosCompradorDto(compradorDto)) {
            if (registroCompradorController.agregarComprador(compradorDto)) {
                    mostrarMensaje("Notificación comprador", "Comprador creado", "El comprador se ha creado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCampos();
            } else {
                    mostrarMensaje("Notificacion comprador", "Comprador no creado", "los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }
        } else{
            mostrarMensaje("Notificacion comprador", "Comprador no creado", "los datos ingresados son invalidos", Alert.AlertType.ERROR);
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
