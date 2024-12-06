package com.sermaluc.apiusuarios.repository;

import com.sermaluc.apiusuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepo extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByCorreo(String correo); // metodo para buscar los usuario por correo
}
