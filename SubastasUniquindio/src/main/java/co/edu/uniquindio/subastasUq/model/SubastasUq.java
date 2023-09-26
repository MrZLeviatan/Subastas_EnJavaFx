package co.edu.uniquindio.subastasUq.model;

import co.edu.uniquindio.subastasUq.exceptions.AnuncianteException;
import co.edu.uniquindio.subastasUq.model.services.ISubastasService;

import java.util.ArrayList;

public class SubastasUq implements ISubastasService {

    ArrayList<Anunciante> listaAnunciantes = new ArrayList<>();
    ArrayList<Comprador> listaComprador = new ArrayList<>();
    ArrayList<Anuncios> listaAnuncios = new ArrayList<>();

    // ?? ArrayList<Puja> listaPuja = new ArrayList<>();

    public SubastasUq() {

    }

    public ArrayList<Anunciante> getListaAnunciantes() {
        return listaAnunciantes;
    }

    public void setListaAnunciantes(ArrayList<Anunciante> listaAnunciantes) {
        this.listaAnunciantes = listaAnunciantes;
    }

    public ArrayList<Comprador> getListaComprador() {
        return listaComprador;
    }

    public void setListaComprador(ArrayList<Comprador> listaComprador) {
        this.listaComprador = listaComprador;
    }

    public ArrayList<Anuncios> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(ArrayList<Anuncios> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }


    @Override
    public Anunciante crearAnunciante(String nombre, String apellido, String cedula, int edad) throws AnuncianteException {

        Anunciante nuevoAnunciante = null;
        boolean anuncianteExistente = anuncianteExiste(cedula);
        if(anuncianteExistente) {
            throw new AnuncianteException("El empleado con cedula: " + cedula + "Ya Existe");

        }else {
            nuevoAnunciante = new Anunciante();
            nuevoAnunciante.setNombre(nombre);
            nuevoAnunciante.setApellido(apellido);
            nuevoAnunciante.setCedula(cedula);
            nuevoAnunciante.setEdad(edad);
        }
        return nuevoAnunciante;
    }


    public boolean anuncianteExiste(String cedula) {
        boolean anuncianteEncontrado = false;
        for (Anunciante anunciante : getListaAnunciantes()) {
            if (anunciante.getCedula().equalsIgnoreCase(cedula)) {
                anuncianteEncontrado = true;
                break;
            }
        }
        return anuncianteEncontrado;

    }
}
