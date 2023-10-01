package co.edu.uniquindio.subastasUq.controller;

import co.edu.uniquindio.subastasUq.mapping.dto.AnuncioDto;
import co.edu.uniquindio.subastasUq.mapping.dto.PujaDto;
import co.edu.uniquindio.subastasUq.model.Anuncio;

import java.util.List;

public class PujasController {
    ModelFactoryController modelFactoryController;

    public PujasController(){
        modelFactoryController=ModelFactoryController.getInstance();
    }



    public List<PujaDto> obtenerPújasAnuncio(AnuncioDto anuncioSelecionado) {
     return modelFactoryController.obtenerPujasAnuncio(anuncioSelecionado);
   }

   public List<AnuncioDto> obtenerAnunciosAnuncianteLog() {
       return modelFactoryController.obtenerAnunciosAnunciante();
    }
}
