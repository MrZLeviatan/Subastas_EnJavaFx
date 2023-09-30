package co.edu.uniquindio.subastasUq.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class AnuncioViewController {


    @FXML
    private Button botonImagen;
    ImageView imageView = new ImageView();



    @FXML
    public void actionoEvento(ActionEvent event) {


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a file");
        fileChooser.setInitialDirectory(new File("C:\\Users\\MrZ Leviatan\\Documents\\Programacion\\Trabajos Github\\Subastas_EnJavaFx\\SubastasUniquindio\\src\\main\\resources\\public.imagenes"));
        fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("JPEG Image","*.jpg"),
                new FileChooser.ExtensionFilter("PNG image","*.png"), new FileChooser.ExtensionFilter("All Image files","*.jpg,","*.png"));
        File seletedFile = fileChooser.showOpenDialog(null);
        Stage stage = (Stage) botonImagen.getScene().getWindow();
        File selecdFile = fileChooser.showOpenDialog(stage);

        if (seletedFile != null){

            Image image = new Image(selecdFile.getPath());
            imageView.setImage(image);


        }else{

            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Texto no recibido oh no encontrado");
            mensaje.setContentText("Finalizacion");
            mensaje.show();
        }



    }





}