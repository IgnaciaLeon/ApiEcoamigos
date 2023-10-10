package com.example.apicomentario.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentario_id;

    @Column(name = "comentario")
    @NotNull
    private String comentarioTexto;

    @Column(name = "fecha creado")
    @DateTimeFormat
    private Date comentarioFecha;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuariosId")
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "postsId")
    private Post post;

    @OneToMany(mappedBy = "comentario", cascade = CascadeType.ALL)
    private List<Like> likesComentario;


}
