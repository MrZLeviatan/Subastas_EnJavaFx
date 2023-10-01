package co.edu.uniquindio.subastasUq.viewController;

import co.edu.uniquindio.subastasUq.controller.RegistroAnuncianteController;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.subastasUq.mapping.dto.UsuarioDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class RegistroAnuncianteViewController {

    ObservableList<AnuncianteDto>anunciantesDto;

    RegistroAnuncianteController registroAnuncianteService;

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
    private TableView<AnuncianteDto> tableUsuario;

    @FXML
    private TableColumn<AnuncianteDto, String> tcApellido;

    @FXML
    private TableColumn<AnuncianteDto, String> tcCedula;

    @FXML
    private TableColumn<UsuarioDto, String> tcContraseña;

    @FXML
    private TableColumn<UsuarioDto,String> tcCorreo;

    @FXML
    private TableColumn<AnuncianteDto, String> tcEdad;

    @FXML
    private TableColumn<AnuncianteDto, String> tcNobre;

    @FXML
    private TableColumn<UsuarioDto, String> tcUsario;

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
       initDataBinding();
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

    private void initDataBinding(){
        tcNobre.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().apellido()));
        tcCedula.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().cedula()));
        tcEdad.setCellValueFactory(cellData->new SimpleStringProperty(String.valueOf(cellData.getValue().edad())));
        tcContraseña.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().contrasena()));
        tcCorreo.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().correo()));
        tcUsario.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().Usuario()));
    }

    private void registrar() {
        AnuncianteDto anuncianteDto= construirAnuncianteDto();
        if(datosValidosAnuniante(anuncianteDto)){
            if(registroAnuncianteService.addAnunciante(anuncianteDto)){
                anunciantesDto.add(anuncianteDto);
                mostrarMensaje("Notificación anunciante", "Anunciante creado", "El anunciante se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }
            else {
                mostrarMensaje("Notificacion anunciante", "anunciante no creado", "los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }else {
            mostrarMensaje("Notificacion anunciante", "anunciante no creado", "los datos ingresados son invalidos", Alert.AlertType.ERROR);
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
        return new AnuncianteDto(
                txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                Integer.parseInt(txtEdad.getText()),
                new UsuarioDto(
                        txtContraseña.getText(),
                        txtCorreo.getText(),txtUsuario.getText()
                )
        );
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
