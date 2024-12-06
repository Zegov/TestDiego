package com.sermaluc.apiusuarios.service;

import com.sermaluc.apiusuarios.model.Telefonos;
import com.sermaluc.apiusuarios.model.Usuario;
import com.sermaluc.apiusuarios.repository.UsuarioRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServicioTest {

    @Mock
    private UsuarioRepo usuarioRepo;

    @InjectMocks
    private UsuarioServicio usuarioServicio;

    public UsuarioServicioTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarNuevoUsuario() throws Exception{

        /// Datos de telefonos
        Telefonos telefonos = Telefonos.builder()
                                .numero(233565456)
                                .codCiudad(2)
                                .codPais(56)
                                .build();

        /// Datos de prueba
        Usuario usuarioPrueba = Usuario.builder()
                                .nombre("Diego Test")
                                .correo("diego@qweqr.com")
                                .password("Diego1234")
                                .telefonos(Collections.singletonList(telefonos))
                                .build();

        /// Config del mock
        when(usuarioRepo.findByCorreo("diego@qweqr.com")).thenReturn(Optional.empty());
        when(usuarioRepo.save(Mockito.any(Usuario.class))).thenAnswer(invocation -> {
            Usuario usuario = invocation.getArgument(0);
            usuario.setId(UUID.randomUUID());
            usuario.setUsuarioFecCreacion(LocalDateTime.now());
            return usuario;
        });

        /// Ejecuto la prueba
        Usuario resultado = usuarioServicio.registrarUsuario(usuarioPrueba);

        assertNotNull(resultado.getId());
        assertEquals("Diego Test", resultado.getNombre());
        assertEquals("diego@qweqr.com", resultado.getCorreo());
        assertNotNull(resultado.getUsuarioFecCreacion());

        verify(usuarioRepo, times(1)).findByCorreo("diego@qweqr.com");
        verify(usuarioRepo, times(1)).save(Mockito.any(Usuario.class));

    }

}
