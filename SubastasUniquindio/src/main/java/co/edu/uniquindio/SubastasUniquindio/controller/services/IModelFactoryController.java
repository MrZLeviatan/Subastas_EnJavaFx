package co.edu.uniquindio.SubastasUniquindio.controller.services;


import co.edu.uniquindio.SubastasUniquindio.mapping.dto.UsuarioDto;
import co.edu.uniquindio.SubastasUniquindio.model.Persona;

import java.util.List;

public interface IModelFactoryController {
    List<Persona> obtenerPersonas();
    boolean agregarUsuario(UsuarioDto usuarioDto);

    boolean eliminarEmpleado(String cedula);

    //boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto);

}
