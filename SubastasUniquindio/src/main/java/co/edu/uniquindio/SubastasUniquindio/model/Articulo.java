package co.edu.uniquindio.SubastasUniquindio.model;

import java.math.BigInteger;

public abstract class Articulo {

    private Float precio;
    private String descripcion;
    private BigInteger id;

    public Float getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigInteger getId() {
        return id;
    }

    public Articulo(Float precio, String descripcion, BigInteger id) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.id = id;
    }
}
