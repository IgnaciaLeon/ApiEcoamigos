package com.example.apicomentario.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long usuario_id;

    @Column (name = "nombre")
    @NotNull
    private String usuarioNombre;

    @Column (name = "nickname")
    @NotNull
    private String usuarioNickname;

    @Column (name = "email")
    @NotNull
    @Email
    private String usuarioEmail;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Post> postsUsuario;

   @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
   private List<Comentario> comentariosUsuario;

}
