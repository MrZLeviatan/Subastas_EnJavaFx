package co.edu.uniquindio.SubastasUniquindio.exceptions;

public class ValorRequeridoException extends Exception {
    public ValorRequeridoException(String nombre){super(String.format(" el % es requerido", nombre));}
}
