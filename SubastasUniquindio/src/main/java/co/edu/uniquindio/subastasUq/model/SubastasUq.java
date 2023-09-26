package co.edu.uniquindio.subastasUq.model;

import co.edu.uniquindio.subastasUq.exceptions.AnuncianteException;
import co.edu.uniquindio.subastasUq.exceptions.CompradorException;
import co.edu.uniquindio.subastasUq.exceptions.UsuarioException;
import co.edu.uniquindio.subastasUq.model.services.IMarketPlaceService;

import java.util.ArrayList;

public class SubastasUq  {

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



    public void addUsuario(Persona usuario) throws Exception{
        if(usuario instanceof Anunciante){ //verifica si el usuario que se ingreso es de tipo Anunciante
            Anunciante anuncianteTemporal=(Anunciante) usuario; //transforma al usuario en un anunciante
            if(usuarioExiste(anuncianteTemporal.getCedula())){//verifica si la cedula esta registrada
                throw new  AnuncianteException("el anunciante con la cedula: "+ anuncianteTemporal.getCedula()+" ya existe");
            }else {
                if(correoExistente(anuncianteTemporal.getUsuario().getCorreo())){ //verifica si el correo esta usado tanto en compradores como anunciantes
                    throw new UsuarioException("el correo:"+anuncianteTemporal.getUsuario().getCorreo()+" ya existe");
                }else {
                    listaAnunciantes.add(anuncianteTemporal); //lo añadde ala lista de anunciantes
                }
            }
        }
        else if(usuario instanceof Comprador){ //verifica si el usario que se ingreso es de tipo Comprador
            Comprador compradorTemporal= (Comprador) usuario; //transforma al usuario en un Comprador
            if(usuarioExiste(compradorTemporal.getCedula())){ //verifica si la cedula esta registrada
                throw new CompradorException("el comprador con la cedula:"+compradorTemporal.getCedula()+" ya existe");
            }else {
                if(correoExistente(compradorTemporal.getUsuario().getCorreo())){
                    throw new UsuarioException("el correo:"+compradorTemporal.getUsuario().getCorreo()+" ya existe");
                }else {
                    listaComprador.add(compradorTemporal);//lo añade ala lista de anunciantes
                }
            }
        }
        else {
            System.out.println(" no se detecto nada");
        }
    }

    public boolean correoExistente(String correo){
       if(correoExistenteComprador(correo)){
           return true;
       } else if (correoExistenteAnunciante(correo)) {
           return true;
       }else {
           return false;
       }
    }

    public boolean usuarioExiste(String cedula){
        if(usuarioExisteComprador(cedula)){
            return true;
        } else if (usuarioExisteAnunciante(cedula)) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean usuarioExisteAnunciante(String cedula) {
        boolean existe=false;
        for (Anunciante anunciante:listaAnunciantes){
            if(anunciante.getCedula().equals(cedula)){
                existe=true;
                break;
            }
        }
        return existe;
    }

    private boolean usuarioExisteComprador(String cedula) {
        boolean existe=false;
        for (Comprador comprador:listaComprador){
            if(comprador.getCedula().equals(cedula)){
                existe=true;
                break;
            }
        }
        return existe;
    }

    private boolean correoExistenteAnunciante(String correo) {
        boolean existe=false;
        for (Anunciante anunciante:listaAnunciantes){
            if(anunciante.getUsuario().getCorreo().equals(correo)){
                existe=true;
                break;
            }
        }
        return existe;
    }

    private boolean correoExistenteComprador(String correo) {
        boolean existe=false;
        for (Comprador comprador:listaComprador){
            if(comprador.getUsuario().getCorreo().equals(correo)){
                existe=true;
                break;
            }
        }
        return existe;
    }
}
