package co.edu.uniquindio.SubastasUniquindio.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class loginController {
    public DatePicker fechaNacimientoDato;
    public TextField edadDato;
    public TextField correoDato;
    public TextField cedulaDato;
    public Tab interfazAutenticacion;
    public TextField idUsuario;
    public Button ingresarUsuario;
    public Button ingresarUsuario1;
    public PasswordField passawordUsuario;
    public TextField nombreDato;
    public TableColumn nombreListaAnuncios;
    public TableColumn codigoListaAnuncios;
    public TableColumn compradorListaPujas;
    public TableColumn CodigoListaPujas;
    public TableColumn fechaListaPujas;
    public TableView tablaAnuncios;
    public TableColumn ofertaInicalListaPujas;
    public TableColumn AnuncianteListaAnuncios;
    public TableView tablaAnuncios1;
    public Text textPuja;
    public TextField pujaRealizadaDato;
    public TextField codigoPujaDato;
    public TextField fechaInicioPuja;
    public TextField ofertaPuja;
    public Button elegirPujaGanadora;
    public Text text1;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}