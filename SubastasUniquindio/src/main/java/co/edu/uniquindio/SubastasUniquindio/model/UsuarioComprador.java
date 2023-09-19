package co.edu.uniquindio.SubastasUniquindio.model;

import java.time.LocalDate;

public class UsuarioComprador extends Usuario{

    public String ubicación;

    public UsuarioComprador(String nombre, String cedula, String correo, String contraseña, LocalDate fechaNacimiento, int edad, String ubicación) {
        super(nombre, cedula, correo, contraseña, fechaNacimiento, edad);
        this.ubicación = ubicación;
    }

    public String getUbicación() {
        return ubicación;
    }
}
