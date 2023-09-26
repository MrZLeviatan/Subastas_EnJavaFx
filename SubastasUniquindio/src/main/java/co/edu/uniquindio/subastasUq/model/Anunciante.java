package co.edu.uniquindio.subastasUq.model;

import java.util.ArrayList;

public class Anunciante extends Persona {

    private Usuario usuario;
    ArrayList<Producto> listaProductoAnunciante = new ArrayList<Producto>();
    ArrayList<Anuncios> listaAnunciosAnunciante = new ArrayList<Anuncios>();


   public Anunciante(){

   }

    public ArrayList<Producto> getListaProductoAnunciante() {
        return listaProductoAnunciante;
    }

    public void setListaProductoAnunciante(ArrayList<Producto> listaProductoAnunciante) {
        this.listaProductoAnunciante = listaProductoAnunciante;
    }

    public ArrayList<Anuncios> getListaAnunciosAnunciante() {
        return listaAnunciosAnunciante;
    }

    public void setListaAnunciosAnunciante(ArrayList<Anuncios> listaAnunciosAnunciante) {
        this.listaAnunciosAnunciante = listaAnunciosAnunciante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
