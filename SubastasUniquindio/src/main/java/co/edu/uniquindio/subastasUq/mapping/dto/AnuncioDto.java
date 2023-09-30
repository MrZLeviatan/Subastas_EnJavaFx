package co.edu.uniquindio.subastasUq.mapping.dto;

import co.edu.uniquindio.subastasUq.model.Producto;

import java.time.LocalDate;
import java.util.List;

public record AnuncioDto(
        String codigoAnuncio,
        Producto producto,

        javafx.scene.image.Image foto,
        LocalDate fechaInicio,

        LocalDate fechaFinal,

        String nombreAnunciante,
        double precioInicial,
        List<PujaDto>pujaDtos
) {
}
