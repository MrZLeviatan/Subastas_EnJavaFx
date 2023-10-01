package co.edu.uniquindio.subastasUq.viewController;

import co.edu.uniquindio.subastasUq.controller.AnuncioController;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;
import co.edu.uniquindio.subastasUq.mapping.dto.ProductoDto;
import co.edu.uniquindio.subastasUq.mapping.dto.PujaDto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AnuncioViewController {
    //-----variables globales


    AnuncioController anuncioServices;
    ObservableList<ProductoDto>productoDtos;
    ImageView imageView = new ImageView();
    //---------------------------------------


    // elementos Fxml
    @FXML
    private Button btnImagen;
    @FXML
    private ComboBox<ProductoDto> comboxProductos;
    @FXML
    private DatePicker dPFechaFinal;
    @FXML
    private DatePicker dPFechaPublicacion;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtNombreAnunciante;
    @FXML
    private TextField txtNombreProducto;
    @FXML
    private TextField valorInicial;
    @FXML
    private Button btnCrearAnuncio;

    @FXML
    private Button botonImagen;
    //final elementos Fxml


    //inicializar metodos
    @FXML
    private void initialize(){
        anuncioServices=new AnuncioController();
        iniciarCombox();
    }
    private void iniciarCombox(){
        obtenerProductos();
        comboxProductos.setItems(productoDtos);
    }
    private void obtenerProductos(){
        productoDtos.addAll(anuncioServices.obtenerProductos());
    }
    //final inicializar




    //metodos para crear

    private void crear() {
        AnuncioDto anuncioDto=crearAnuncioDto();
        anuncioServices.addAnuncio(anuncioDto);
    }
    private AnuncioDto crearAnuncioDto() {
        List<PujaDto>pujaDtos=new ArrayList<>();
        return new AnuncioDto(
                "codigo",
                null,
                imageView.getImage(), //cambiar bite por imagen???
                dPFechaPublicacion.getValue(),
                dPFechaFinal.getValue(),
                "nombre anunciante",
                Double.parseDouble(valorInicial.getText()),
                pujaDtos
        );
    }

    //final metodos crear


    //eventos-----------------------------------------------------------------------------------------------
    @FXML
    void CrearAnuncio(ActionEvent event) {
        crear();
    }

    @FXML
    public void agregarFoto(ActionEvent event) {


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

    //final eventos-----------------------------------------------------------------------

}