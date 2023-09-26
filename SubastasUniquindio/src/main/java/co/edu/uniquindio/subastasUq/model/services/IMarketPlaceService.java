package co.edu.uniquindio.subastasUq.model.services;

import co.edu.uniquindio.subastasUq.exceptions.AnuncianteException;
import co.edu.uniquindio.subastasUq.model.Anunciante;

public interface IMarketPlaceService {
    public Anunciante crearAnunciante(String nombre, String apellido, String cedula, int edad) throws AnuncianteException;
}
