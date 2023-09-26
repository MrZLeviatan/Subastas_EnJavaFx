package co.edu.uniquindio.subastasUq.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Puja {

    private String codigo;
    private Integer oferta;
    private LocalDateTime fecha;

    public Puja(String codigo, Integer oferta, LocalDateTime fecha) {
        this.codigo = codigo;
        this.oferta = oferta;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getOferta() {
        return oferta;
    }

    public void setOferta(Integer oferta) {
        this.oferta = oferta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
