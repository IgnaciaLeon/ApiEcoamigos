package com.example.apicomentario.services;

import com.example.apicomentario.models.Comentario;
import com.example.apicomentario.models.Usuario;

import java.util.List;

public interface ComentarioService {

    Comentario buscarComentarioPorId(Long id);

    //Usuario buscarUsuarioPorToken (Usuario)
    Comentario guardarComentario(Comentario comentarioNuevo);
    void borrarComentario(Long id);
    Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado);
}
