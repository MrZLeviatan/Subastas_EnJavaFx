package co.edu.uniquindio.subastasUq.mapping.dto;

import java.time.LocalDateTime;

public record PujaDto(
        String codigo,
        Integer oferta,
        LocalDateTime fecha,
        String nombreOfertante
) {
}
