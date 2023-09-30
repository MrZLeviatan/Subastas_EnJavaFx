package co.edu.uniquindio.subastasUq.viewController;
import co.edu.uniquindio.subastasUq.controller.PujasController;
import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;
import co.edu.uniquindio.subastasUq.mapping.dto.PujaDto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class PujasViewController {

    //Variables globales de la interfas

    PujasController pujasService;
    ObservableList<AnuncioDto>anuncioDtos;
    ObservableList<PujaDto>pujaDtos;
    AnuncioDto anuncioSelecionado;
    PujaDto pujaSelecionada;

    //variables globales final

    //elementos Fxml
    @FXML
    private Button btnElegirPuja;
    @FXML
    private TableView<AnuncioDto> tableAnuncios;
    @FXML
    private TableView<PujaDto> tablePujas;
    @FXML
    private TableColumn<AnuncioDto, String> tcCodigo;
    @FXML
    private TableColumn<AnuncioDto,String> tcNobre;
    @FXML
    private TableColumn<PujaDto, String> tcCodigoPuja;
    @FXML
    private TableColumn<PujaDto, String> tcComprador;
    @FXML
    private TableColumn<PujaDto, String> tcFecha;
    @FXML
    private TableColumn<PujaDto, String> tcFechaInicial;

    @FXML
    private Text text;
    @FXML
    private Text text1;

    //final elementos Fxml


    //EVENTS
    @FXML
    void elegirPuja(ActionEvent event) {

    }
    //FINAL EVENTS


    //METODOS INICIALIZAR

    @FXML
    private void initialize(){
        pujasService= new PujasController();
        listenerSelectionPuja();
        listenerSelectionAnuncio();

    }

    //FINAL METODOS INICIALIZAR


    //METODOS SELECION
    private void listenerSelectionAnuncio() {
        tableAnuncios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            anuncioSelecionado = newSelection;
            System.out.println(anuncioSelecionado.codigoAnuncio());
        });
    }
    private  void listenerSelectionPuja() {
        tablePujas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            pujaSelecionada = newSelection;
            System.out.println(pujaSelecionada);
        });
    }
    //FiNAL METODOS SELECCION


}
