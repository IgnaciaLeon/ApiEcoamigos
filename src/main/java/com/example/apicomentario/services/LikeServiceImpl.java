package com.example.apicomentario.services;
import com.example.apicomentario.models.Like;
import com.example.apicomentario.repositories.LikeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class LikeServiceImpl implements LikeService {
    @Autowired
    LikeRepository likeRepository;

    @Override
    public Like guardarLike(Like likeNuevo){
       Like likeGuardado = likeRepository.save(likeNuevo);
        return likeGuardado;
    }

    @Override
    public void borrarLike(Long id) {
        likeRepository.deleteById(id);
    }

}

//Listado con PK


