package co.edu.uniquindio.SubastasUniquindio.model;

import co.edu.uniquindio.SubastasUniquindio.exceptions.ValorRequeridoException;
import java.time.LocalDate;
import java.util.Objects;

public class Usuario {
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

    public static Usuario of (String nombre,String cedula, String correo, String contraseña, LocalDate fechaNacimiento, int edad)throws Exception{
        if(Objects.requireNonNull(nombre,"el nombre es requerido").isBlank()){//verifica si es nulo, que no sean solo espacios
            throw new ValorRequeridoException("nombre");
        }
        if(Objects.requireNonNull(cedula,"el numero de cedula es requerida").isBlank()){
            throw new ValorRequeridoException("cedula");
        }
        if(Objects.requireNonNull(correo,"el correo es necesario").isBlank()){
            throw new ValorRequeridoException("correo");
        }
        if(Objects.requireNonNull(contraseña,"la contraseña es requerida").isBlank()){
            throw new ValorRequeridoException("contraseña");
        }
        if(Objects.requireNonNull(fechaNacimiento,"la fecha de nacimiento es requerida").equals(null)){
            throw new ValorRequeridoException( "fecha nacimiento");
        }
        if(Objects.requireNonNull(edad,"la edad es requerida").equals(null)){
            throw new ValorRequeridoException("edad");
        }
        return new Usuario(nombre, cedula, correo, contraseña, fechaNacimiento, edad);
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
