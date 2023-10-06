package co.edu.uniquindio.subastasUq.utils;

import co.edu.uniquindio.subastasUq.model.*;

public class SubastaUqUtils {
    public static SubastasUq inicializarDatos() throws Exception {
        SubastasUq subastasUq= new SubastasUq();
        Anunciante anunciante= new Anunciante(
                        "andrey"
                        ,"tombe"
                        ,"123445"
                        ,12
                        ,new Usuario("andrey3681","1234","1234"));

        anunciante.addAnuncioAnunciante(new Anuncio());
        Producto producto=new Producto();
        producto.setNombre("hola");
        Anuncio anuncio=new Anuncio();
        anuncio.setCodigo("jjjj");
        anunciante.getListaProductoAnunciante().add(producto);
        anunciante.getListaAnunciosAnunciante().add(anuncio);

        subastasUq.addUsuario(anunciante);

        subastasUq.addUsuario(
                new Comprador(
                        "luis",
                        "fernando",
                        "12345",
                        13,
                        "addsadada",
                        new Usuario("luis123","12345","12345")
                )
        );

        return subastasUq;
    }
}
