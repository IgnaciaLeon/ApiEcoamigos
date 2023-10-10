package com.example.apicomentario.services;

import com.example.apicomentario.models.Comentario;
import com.example.apicomentario.models.Post;
import com.example.apicomentario.repositories.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> listaDePosts(){
        List<Post> listaPost = postRepository.findAll();
        return listaPost;
    }
    @Override
    public Post buscarPostPorId(Long id){
        Boolean existePost = postRepository.existsById(id);
        if (existePost){
            Post postEscogido = postRepository.findById(id).get();
            return postEscogido;
        }else {
            System.out.println("post invalido o inexistente");
            return null;
        }
    }
    @Override
    public Post guardarPost(Post postNuevo){
        Post postGuardado = postRepository.save(postNuevo);
        return postGuardado;
    }

    @Override
    public void borrarPost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post editarPostPorId(Long id, Post postActualizado) {
        Boolean existeComentario = postRepository.existsById(id);
        if (existeComentario){
            Post postEscogido = postRepository.findById(id).get();
            postEscogido.setPostFecha(postActualizado.getPostFecha());
            postEscogido.setPostContenido(postActualizado.getPostContenido());
            System.out.println("post actualizado");
            return postRepository.save(postEscogido);
        }else {
            System.out.println("post inexistente o invalido");
            return null;
        }
    }

}
