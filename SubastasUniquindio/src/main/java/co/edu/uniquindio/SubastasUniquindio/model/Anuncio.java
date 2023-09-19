package co.edu.uniquindio.SubastasUniquindio.model;

import java.time.LocalDate;

public class Anuncio {
    private Articulo articulo;
    private TipoArticulo tipoArticulo;
    private String nombreAnunciante;
    private String nombreArticulo;

    private String descripción;

    private Byte foto;

    private LocalDate fechaPublicacion;
    private LocalDate fechaFinalizacionPublicacion;

    private float valorInicial;

    public Anuncio(Articulo articulo, TipoArticulo tipoArticulo, String nombreAnunciante, String nombreArticulo, String descripción, Byte foto, LocalDate fechaPublicacion, LocalDate fechaFinalizacionPublicacion, float valorInicial) {
        this.articulo = articulo;
        this.tipoArticulo = tipoArticulo;
        this.nombreAnunciante = nombreAnunciante;
        this.nombreArticulo = nombreArticulo;
        this.descripción = descripción;
        this.foto = foto;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaFinalizacionPublicacion = fechaFinalizacionPublicacion;
        this.valorInicial = valorInicial;
    }
    public Articulo getArticulo() {
        return articulo;
    }

    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public String getNombreAnunciante() {
        return nombreAnunciante;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public String getDescripción() {
        return descripción;
    }

    public Byte getFoto() {
        return foto;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public LocalDate getFechaFinalizacionPublicacion() {
        return fechaFinalizacionPublicacion;
    }

    public float getValorInicial() {
        return valorInicial;
    }

}
