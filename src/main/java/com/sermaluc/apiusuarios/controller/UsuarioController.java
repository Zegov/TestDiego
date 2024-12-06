package com.sermaluc.apiusuarios.controller;

import com.sermaluc.apiusuarios.model.Usuario;
import com.sermaluc.apiusuarios.service.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/usuario") // aca mapeo la ruta principal de la api
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;
    @PostMapping("/registro")// aca creo el endpoint para poder crear los usuarios.
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioRegistrado = usuarioServicio.registrarUsuario(usuario);
            return ResponseEntity.ok(usuarioRegistrado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", e.getMessage()));
        }
    }
}
