package co.edu.uniquindio.subastasUq.controller.service;

import co.edu.uniquindio.subastasUq.mapping.dto.UsuarioDto;
import co.edu.uniquindio.subastasUq.model.Usuario;

public interface IAutentifacionController {
    boolean auntetificarAnunciante(String correo,String contraseña);
    boolean autentificarComprador(String correo,String contraseña);
}
