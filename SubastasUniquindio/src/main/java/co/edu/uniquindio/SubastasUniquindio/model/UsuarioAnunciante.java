package co.edu.uniquindio.SubastasUniquindio.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAnunciante extends Usuario{
    private  List<Anuncio> anuncioList=new ArrayList<>();

    public UsuarioAnunciante(String nombre, String cedula, String correo, String contraseña, LocalDate fechaNacimiento, int edad, int numeroAnuncios, List<Anuncio> anuncioList) {
        super(nombre, cedula, correo, contraseña, fechaNacimiento, edad);
        this.anuncioList = anuncioList;
    }



    public void añadirAnuncio(Anuncio anuncio){
        if(anuncioList.size()<3){
            anuncioList.add(anuncio);
        }else {
            throw new RuntimeException("solo se pueden tener tres anuncios al tiempo");
        }
    }

    public void eleminarAnuncio(Anuncio anuncio){
        Articulo articulo= obtenerArticulo(anuncio.getArticulo().getId());
        anuncioList.remove(articulo);
    }

    public Articulo obtenerArticulo(BigInteger id){
        return anuncioList.stream().filter(anuncio -> anuncio.getArticulo().getId()==id).findFirst().get().getArticulo();
    }
}
