package co.edu.uniquindio.subastasUq.viewController;

import co.edu.uniquindio.subastasUq.controller.InicioController;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InicioViewController {



    InicioController inicioServices;
    ObservableList<AnuncioDto> listaAnunciosDto= FXCollections.observableArrayList();


    @FXML
    private Button btnBuscar;

    @FXML
    private TableView<AnuncioDto> tableAnuncios;

    @FXML
    private TableColumn<AnuncioDto, String> tcAnunciante;

    @FXML
    private TableColumn<AnuncioDto, String> tcCodigoAnuncio;

    @FXML
    private TableColumn<AnuncioDto, String> tcDescripcion;

    @FXML
    private TableColumn<AnuncioDto, String> tcProducto;

    @FXML
    private TableColumn<AnuncioDto, String> tcValorIncial;

    @FXML
    private TextField txtAnunciante;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtProducto;

    @FXML
    private void initialize(){
        inicioServices=new InicioController();
        initView();
        obtenerAnuncios();
        tableAnuncios.getItems().clear();
        tableAnuncios.setItems(listaAnunciosDto);

    }

    private void initView() {
        initDataBinding();
        obtenerAnuncios();
    }

    private void obtenerAnuncios() {
        listaAnunciosDto.addAll(inicioServices.obtenerAnuncios());
    }

    //propiedad para las tablas
    private void initDataBinding() {
        tcAnunciante.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().nombreAnunciante()));
        tcDescripcion.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().producto().getDescripcion()));
        tcCodigoAnuncio.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().codigoAnuncio()));
        tcProducto.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().producto().getNombre()));
        tcValorIncial.setCellValueFactory(cellData->new SimpleStringProperty(String.valueOf(cellData.getValue().precioInicial())));
    }

    @FXML
    void filtrar(ActionEvent event) {
        filtrarAnuncios();
    }

    private void filtrarAnuncios(){
        listaAnunciosDto.addAll(inicioServices.filtrarAnuncios(txtCodigo.getText(),txtAnunciante.getText(),txtCodigo.getText()));
    }

}
