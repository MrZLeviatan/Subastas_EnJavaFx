package co.edu.uniquindio.SubastasUniquindio.util;

import co.edu.uniquindio.SubastasUniquindio.model.Anunciante;
import co.edu.uniquindio.SubastasUniquindio.model.Persona;
import co.edu.uniquindio.SubastasUniquindio.model.SubastasUq;
import co.edu.uniquindio.SubastasUniquindio.model.Usuario;

public class SubastaUtils {

    public static SubastasUq inicializarDatos(){
        SubastasUq subastasUq= new SubastasUq();

        subastasUq.agregarUsuario(
                new Anunciante(
                        "andrey"
                        ,"tombe"
                        ,"123445"
                        ,12
                        ,new Usuario("andrey3681.ay@gmail.com","1234"))
        );

        return subastasUq;
    }

}
