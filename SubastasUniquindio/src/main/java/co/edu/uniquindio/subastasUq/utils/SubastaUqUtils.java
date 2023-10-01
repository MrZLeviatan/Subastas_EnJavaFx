package co.edu.uniquindio.subastasUq.utils;

import co.edu.uniquindio.subastasUq.model.*;

public class SubastaUqUtils {
    public static SubastasUq inicializarDatos() throws Exception {
        SubastasUq subastasUq= new SubastasUq();

        subastasUq.addUsuario(
                new Anunciante(
                        "andrey"
                        ,"tombe"
                        ,"123445"
                        ,12
                        ,new Usuario("andrey3681","1234","andrey3681.ay@gmail.com"))
        );
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
