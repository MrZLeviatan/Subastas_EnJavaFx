package co.edu.uniquindio.SubastasUniquindio.model;

public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private Integer edad;

    public Persona(String nombre, String apellido, String cedula, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public Integer getEdad() {
        return edad;
    }
}
