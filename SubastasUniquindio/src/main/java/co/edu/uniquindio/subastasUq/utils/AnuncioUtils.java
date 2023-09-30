package co.edu.uniquindio.subastasUq.utils;

import co.edu.uniquindio.subastasUq.model.Anuncio;

import java.util.function.Predicate;

public class AnuncioUtils {

    public static Predicate<Anuncio> buscarPorCodigo(String codigo){
        return anuncio-> anuncio.getCodigoAnuncio().equals(codigo);
    }

    public static Predicate<Anuncio> buscarPorAnunciante(String nombreAnunciante){
        return anuncio -> anuncio.getNombreAnunciante().equals(nombreAnunciante);
    }

    public static Predicate<Anuncio> buscarPorNombreProducto(String nombreProducto){
        return anuncio -> anuncio.getProducto().getNombre().equals(nombreProducto);
    }

    public static Predicate<Anuncio> buscarPorTodo(String codigo,String nombreAnunciante,String nombreProducto) {
        Predicate<Anuncio> predicado = anuncio -> true;
        if( codigo != null && !codigo.isBlank() ){
            predicado = predicado.and(buscarPorCodigo(codigo));
        }
        if( nombreAnunciante != null && !nombreAnunciante.isBlank() ){
            predicado = predicado.and(buscarPorAnunciante(nombreAnunciante));
        }
        if( nombreProducto != null && !nombreProducto.isBlank() ){
            predicado = predicado.and(buscarPorNombreProducto(nombreProducto));
        }
        return predicado;
    }
}
