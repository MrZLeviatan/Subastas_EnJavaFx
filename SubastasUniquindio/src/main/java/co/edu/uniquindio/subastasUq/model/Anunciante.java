package co.edu.uniquindio.subastasUq.model;

import java.util.ArrayList;

public class Anunciante extends Persona {

    private Usuario usuario;
    ArrayList<Producto> listaProductoAnunciante = new ArrayList<>();
    ArrayList<Anuncios> listaAnunciosAnunciante = new ArrayList<>();


   public Anunciante(String nombre, String apellido, String cedula, Integer edad, Usuario usuario){
       super(nombre, apellido, cedula, edad);
       this.usuario = usuario;

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
