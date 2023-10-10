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
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @Column(name = "post")
    @NotNull
    private String postContenido;

    @Column(name = "fecha creado")
    @DateTimeFormat
    private Date postFecha;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuariosId")
    private Usuario usuario;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comentario> comentariosPost;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likesPost;

}
