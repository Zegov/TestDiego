package com.sermaluc.apiusuarios.service;

import com.sermaluc.apiusuarios.model.Telefonos;
import com.sermaluc.apiusuarios.model.Usuario;
import com.sermaluc.apiusuarios.repository.UsuarioRepo;
import com.sermaluc.apiusuarios.util.ValidacionesUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioServicio {
    private final UsuarioRepo usuarioRepo;

    public Usuario registrarUsuario(Usuario usuario) throws Exception {

        /// Validar la estructura del mail
        if (!ValidacionesUtils.validarCorreo(usuario.getCorreo())) {
            throw new Exception("El correo tiene formato invalido, ejemplo: prueba@sermaluc.cl");
        }

        /// Validar que los datos de los telefonos solo sean numeros
        for (Telefonos fono : usuario.getTelefonos()) {
            if (!ValidacionesUtils.esNumerico(fono.getNumero()) ||
                    !ValidacionesUtils.esNumerico(fono.getCodCiudad()) ||
                    !ValidacionesUtils.esNumerico(fono.getCodPais()) ) {
                throw new Exception("Los datos ingresados para telefono deben ser solo numeros");
            }
        }

        ///  Valida la contraseña
        if (!ValidacionesUtils.validarPassword(usuario.getPassword())) {
            throw new Exception("La contraseña no cumple con los requisitos de seguridad minimo(Largo minimo 8, al menos 1 digito y 1 mayuscula " +
                    "ejemplo: Password123");
        }

        /// Validamos si el correo del usuario existe
        Optional<Usuario> existeUsuario = usuarioRepo.findByCorreo(usuario.getCorreo());
        if (existeUsuario.isPresent()) {
            throw new Exception("El correo ya se encuentra registrado");
        }

        /// Datos del usuario
        usuario.setUsuarioFecCreacion(LocalDateTime.now());
        usuario.setUsuarioFecModificacion(LocalDateTime.now());
        usuario.setUltimoIngreso(LocalDateTime.now());
        usuario.setToken(UUID.randomUUID().toString());
        usuario.setActivo(true);

        return usuarioRepo.save(usuario);
    }
}
