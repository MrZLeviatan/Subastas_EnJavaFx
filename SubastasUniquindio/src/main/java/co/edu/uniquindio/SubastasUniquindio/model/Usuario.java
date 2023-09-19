package co.edu.uniquindio.SubastasUniquindio.model;

import java.time.LocalDate;

public abstract class Usuario {
    private String nombre;
    private String cedula;
    private String correo;
    private String contraseña;
    private LocalDate fechaNacimiento;
    private int edad;

    public Usuario(String nombre, String cedula, String correo, String contraseña, LocalDate fechaNacimiento, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }
}
