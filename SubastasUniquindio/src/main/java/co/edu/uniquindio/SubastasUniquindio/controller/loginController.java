package co.edu.uniquindio.SubastasUniquindio.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class loginController {
    public DatePicker fechaNacimientoDato;
    public TextField edadDato;
    public TextField correoDato;
    public TextField cedulaDato;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}