package co.edu.uniquindio.subastasUq.model;

import co.edu.uniquindio.subastasUq.model.services.IAnunciante;

import java.util.ArrayList;

public class Anunciante extends Persona implements IAnunciante {

    private Usuario usuario;
    private ArrayList<Producto> listaProductosAnunciante = new ArrayList<>();
    private ArrayList<Anuncio> listaAnuncioAnunciante = new ArrayList<>();





   public Anunciante(String nombre, String
           apellido, String cedula, Integer edad, Usuario usuario){


       super(nombre, apellido, cedula, edad);
       this.listaAnuncioAnunciante=new ArrayList<>();
       this.listaProductosAnunciante=new ArrayList<>();
       this.usuario = usuario;

   }
    public ArrayList<Producto> getListaProductoAnunciante() {
        return listaProductosAnunciante;
    }

    public ArrayList<Anuncio> getListaAnunciosAnunciante() {
        return listaAnuncioAnunciante;
    }



    public Usuario getUsuario() {
        return usuario;
    }


    public void addProducto(Producto producto){
       listaProductosAnunciante.add(producto);
    }
    public void eleminarProducto(Producto producto){
       listaProductosAnunciante.remove(producto);
    }


    public void addAnuncioAnunciante(Anuncio anuncio){
       listaAnuncioAnunciante.add(anuncio);
    }

    public void eliminarAnuncio(Anuncio anuncio){
       listaAnuncioAnunciante.remove(anuncio);
    }



}
