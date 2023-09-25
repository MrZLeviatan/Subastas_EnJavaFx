package co.edu.uniquindio.SubastasUniquindio.model;

import co.edu.uniquindio.SubastasUniquindio.mapping.dto.PersonaDto;
import co.edu.uniquindio.SubastasUniquindio.model.service.ISubastasUq;

import java.util.ArrayList;
import java.util.List;

public class SubastasUq implements ISubastasUq {

    List<Persona>personas=new ArrayList<>();

    List<Anunciante>anuncianteList;
    List<Comprador>compradorList;

    public SubastasUq(){

    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void agregarUsuario(Persona persona) {
        getPersonas().add(persona);
    }


    public boolean personaExiste(String cedula){
        boolean existe= false;
        for (Persona persona: personas){
            if(persona.getCedula().equals(cedula)){
                existe=true;
                break;
            }
        }
        return existe;
    }
}
