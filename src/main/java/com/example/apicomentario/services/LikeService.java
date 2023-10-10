package com.example.apicomentario.services;

import com.example.apicomentario.models.Comentario;
import com.example.apicomentario.models.Like;

public interface LikeService {

    Like guardarLike(Like likeNuevo);
    void borrarLike(Long id);
}
