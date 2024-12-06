package com.sermaluc.apiusuarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity //Marco esta clase como una entidad JPA
@Data // etiqueta para que lombok genere los getters y setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // el id lo genero automaticamente
    private Long id;

    private String nombre;

    @Column(unique = true) // por definicion el correo deberia ser unico para la validacion
    private String correo;

    private String password;

    //datos necesarios para la respuesta
    private LocalDateTime usuarioFecCreacion;
    private LocalDateTime usuarioFecModificacion;
    private LocalDateTime ultimoIngreso;
    private String token;
    private boolean activo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Telefonos> telefonos;

}
