package co.edu.uniquindio.subastasUq.mapping.dto;

import co.edu.uniquindio.subastasUq.model.Producto;
import javafx.scene.image.Image;

import java.time.LocalDate;
import java.util.List;

public record AnuncioDto(
        String codigoAnuncio,
        Producto producto,

        Image foto,
        LocalDate fechaInicio,

        LocalDate fechaFinal,

        String nombreAnunciante,
        double precioInicial,
        List<PujaDto>pujaDtos
) {
}
