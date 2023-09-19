package co.edu.uniquindio.SubastasUniquindio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAnunciante extends Usuario{
    private int numeroAnuncios;
    private  List<Anuncio> anuncioList=new ArrayList<>();



    public UsuarioAnunciante(String nombre, String cedula, String correo, String contraseña, LocalDate fechaNacimiento, int edad, int numeroAnuncios, List<Anuncio> anuncioList) {
        super(nombre, cedula, correo, contraseña, fechaNacimiento, edad);
        this.numeroAnuncios = numeroAnuncios;
        this.anuncioList = anuncioList;
    }
}
