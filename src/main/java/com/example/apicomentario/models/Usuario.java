package com.example.apicomentario.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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

    @Column (name = "token")
    private String usuarioToken;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Post> postsUsuario;

   @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
   private List<Comentario> comentariosUsuario;

   @JsonIgnore
    @CreationTimestamp
    private LocalDateTime UsuarioFechaCreado;

   @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime UsuarioFechaActualizado;

}
