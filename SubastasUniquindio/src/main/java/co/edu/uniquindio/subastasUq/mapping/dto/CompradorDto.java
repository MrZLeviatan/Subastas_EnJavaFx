package co.edu.uniquindio.subastasUq.mapping.dto;

public record CompradorDto(
        String nombre,
        String apellido,
        String cedula,
        Integer edad,
        String direccion,

        UsuarioDto usuarioDto
) {

    @Override
    public String toString() { return "CompradorDto{" +  "nombre='" + nombre + '\'' +  ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", usuarioDto=" + usuarioDto +
                '}';
    }
}
