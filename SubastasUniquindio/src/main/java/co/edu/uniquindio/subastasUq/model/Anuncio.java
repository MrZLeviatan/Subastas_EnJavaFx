package co.edu.uniquindio.subastasUq.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Anuncio {

    private String codigoAnuncio;
    private Producto producto;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;

    private String nombreAnunciante;

    private double precioInicial;

    ArrayList<Puja> listaPujaProducto = new ArrayList<Puja>();


    public Anuncio(){
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public ArrayList<Puja> getListaPujaProducto() {
        return listaPujaProducto;
    }

    public void setListaPujaProducto(ArrayList<Puja> listaPujaProducto) {
        this.listaPujaProducto = listaPujaProducto;
    }

    public String getCodigo() {
        return codigoAnuncio;
    }

    public void setCodigo(String codigo) {
        this.codigoAnuncio = codigo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getCodigoAnuncio() {
        return codigoAnuncio;
    }

    public void setCodigoAnuncio(String codigoAnuncio) {
        this.codigoAnuncio = codigoAnuncio;
    }

    public String getNombreAnunciante() {
        return nombreAnunciante;
    }

    public void setNombreAnunciante(String nombreAnunciante) {
        this.nombreAnunciante = nombreAnunciante;
    }

    public double getPrecioInicial() {
        return precioInicial;
    }

    public void setPrecioInicial(double precioInicial) {
        this.precioInicial = precioInicial;
    }
}
