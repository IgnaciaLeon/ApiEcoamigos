package com.example.apicomentario.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Like {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long like_id;

    @Column(name = "like post")
    @NotNull
    private Number postLike;


    @Column(name = "like comentario")
    @NotNull
    private Number comentarioLike;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "postsId")
    private Post post;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "comentariosId")
    private Comentario comentario;
}
