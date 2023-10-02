package co.edu.uniquindio.subastasUq.model;

import co.edu.uniquindio.subastasUq.exceptions.AnuncianteException;
import co.edu.uniquindio.subastasUq.model.services.ISubasta;
import co.edu.uniquindio.subastasUq.utils.AnuncioUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubastasUq implements ISubasta {

    ArrayList<Anunciante> listaAnunciantes = new ArrayList<>();
    ArrayList<Comprador> listaComprador = new ArrayList<>();
    ArrayList<Anuncio> listaAnuncios = new ArrayList<>();



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

    public ArrayList<Anuncio> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(ArrayList<Anuncio> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }



    public void addUsuario(Persona usuario){
        if(usuario instanceof Anunciante){ //verifica si el usuario que se ingreso es de tipo Anunciante
            Anunciante anuncianteTemporal=(Anunciante) usuario; //transforma al usuario en un anunciante
            listaAnunciantes.add(anuncianteTemporal); //lo añadde ala lista de anunciantes
        }
        else if(usuario instanceof Comprador){ //verifica si el usario que se ingreso es de tipo Comprador
            Comprador compradorTemporal= (Comprador) usuario; //transforma al usuario en un Comprador
            listaComprador.add(compradorTemporal);//lo añade ala lista de anunciantes
        }else {
            if(usuario==null){
                throw new NullPointerException("el usuario es nulo");
            }
        }
    }

    public void deleteUsuario(Persona usuario){
        if(usuario instanceof Anunciante){
            Anunciante anuncianteTemporal=(Anunciante) usuario;
            listaAnunciantes.remove(anuncianteTemporal);
        }
        if (usuario instanceof Comprador) {
            Comprador compradorTemporal = (Comprador) usuario;
            listaComprador.remove(compradorTemporal);
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

    public Anunciante obtenerAnunciante(String cedula) {
        return listaAnunciantes
                .stream()
                .filter(anunciante -> anunciante.getCedula().equals(cedula))
                .findFirst()
                .get();
    }

    public Comprador obtenerComprador(String cedula){
        return listaComprador.stream().filter(comprador -> comprador.getCedula().equals(cedula)).findFirst().get();
    }

    public void addAnuncio(Anuncio anuncio,String cedula) {
        Anunciante anunciante=obtenerAnunciante(cedula);
        anunciante.addAnuncioAnunciante(anuncio);
        listaAnuncios.add(anuncio);
    }

    public void addProductoAnunciante(Producto producto,String cedula) {
        Anunciante anunciante= obtenerAnunciante(cedula);
        anunciante.addProducto(producto);
    }

    public boolean autetificarComprador(String correo, String contraseña) {
        boolean correcto=false;
        for (Comprador comprador:listaComprador){
            if(comprador.getUsuario().getCorreo().equals(correo)&&comprador.getUsuario().getConstrasenia().equals(contraseña)){
                correcto= true;
                break;
            }
        }
        return correcto;
    }

    public boolean autentificarAnunciante(String correo, String contraseña){
        boolean correcto=false;
        for (Anunciante anunciante:listaAnunciantes){
            if(anunciante.getUsuario().getCorreo().equals(correo)&&anunciante.getUsuario().getConstrasenia().equals(contraseña)){
                correcto=true;
                break;
            }
        }
        return correcto;
    }
    //metodo para filtrar la lista
    public List<Anuncio> filtrarProductos(String codigo,String nombreAnunciante, String nombreProducto){
        return listaAnuncios
                .stream()
                .filter(AnuncioUtils.buscarPorTodo(codigo,nombreAnunciante,nombreProducto))
                .collect(Collectors.toList());
    }


    //metodo para obtener el anunciante utilizando el correo
    public Anunciante obtenerAnuncianteCorreo(String correo) {
        return listaAnunciantes.stream().filter(anunciante -> anunciante.getUsuario().getCorreo().equals(correo)).findFirst().get();
    }

    //metodoPara obtener el comprador utilizando el correo

    public Comprador obtenerCompradorCorreo(String correo) {
        return listaComprador.stream().filter(comprador -> comprador.getUsuario().getCorreo().equals(correo)).findFirst().get();
    }
}
