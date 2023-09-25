package co.edu.uniquindio.SubastasUniquindio.model;

import co.edu.uniquindio.SubastasUniquindio.exceptions.AnuncioException;

import java.util.ArrayList;
import java.util.List;

public class Anunciante extends Persona{

    private Usuario usuario;
    private List<Producto>listProducts=new ArrayList<>();
    private List<Anuncio>listAnuncios=new ArrayList<>();


    public Anunciante(String nombre, String apellido, String cedula, Integer edad, Usuario usuario) {
        super(nombre, apellido, cedula, edad);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public void agregarAnuncio(Anuncio anuncio) throws AnuncioException {
        if(anuncio!=null) {
            if (listAnuncios.size() <= 3) {
                listAnuncios.add(anuncio);
            } else {
                throw new AnuncioException("el usuario alcanzo el maximo de anuncios permitidos");
            }
        } else {
            throw new AnuncioException("anuncio invalido");
        }
    }

    public void eliminarAnuncio(Anuncio anuncio) throws AnuncioException {
        if(anuncio!=null){
            if(anuncioExiste(anuncio.getCodigo())){
                listAnuncios.remove(anuncio);
            }else {
                throw new AnuncioException("el anuncio no existe");
            }
        }
    }

    public boolean anuncioExiste(String codigo) {
        boolean anuncioExiste= false;
        for (Anuncio anuncio : listAnuncios) {
            if (anuncio.getCodigo().equals(codigo)) {
                anuncioExiste=true;
                break;
            }
        }
        return anuncioExiste;
    }
}
