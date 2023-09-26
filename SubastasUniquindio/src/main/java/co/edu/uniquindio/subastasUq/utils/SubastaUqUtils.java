package co.edu.uniquindio.subastasUq.utils;

import co.edu.uniquindio.subastasUq.model.Anunciante;
import co.edu.uniquindio.subastasUq.model.SubastasUq;
import co.edu.uniquindio.subastasUq.model.Usuario;

public class SubastaUqUtils {
    public static SubastasUq inicializarDatos(){
        SubastasUq subastasUq= new SubastasUq();

        subastasUq.agregarUsuario(
                new Anunciante(
                        "andrey"
                        ,"tombe"
                        ,"123445"
                        ,12
                        ,new Usuario("andrey3681.ay@gmail.com","1234","a"))
        );

        return subastasUq;
    }
}
