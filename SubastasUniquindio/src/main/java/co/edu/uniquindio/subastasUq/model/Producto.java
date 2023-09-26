package co.edu.uniquindio.subastasUq.model;

public class Producto {

    private String nombre;
    private String descripcion;
    private Byte imagen;
    private TipoProductos tipoProductos;

    public Producto(String nombre, String descripcion, Byte imagen, TipoProductos tipoProductos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.tipoProductos = tipoProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Byte getImagen() {
        return imagen;
    }

    public void setImagen(Byte imagen) {
        this.imagen = imagen;
    }

    public TipoProductos getTipoProductos() {
        return tipoProductos;
    }

    public void setTipoProductos(TipoProductos tipoProductos) {
        this.tipoProductos = tipoProductos;
    }
}
