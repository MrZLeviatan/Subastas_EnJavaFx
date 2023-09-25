package co.edu.uniquindio.SubastasUniquindio.model;

import java.io.CharArrayReader;
import java.util.ArrayList;

public class Anuncio {
    private String codigo;
    ArrayList<Puja>pujalist= new ArrayList<>();

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
