package com.example.apicomentario.controllers;

import com.example.apicomentario.models.Post;
import com.example.apicomentario.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestController {

    @Autowired
    PostServiceImpl postService;

    @GetMapping("/lista")
    public List<Post> listaPost() {
        List<Post> mostrarListaPost = postService.listaDePosts();
        return mostrarListaPost;
    }

    @PostMapping("/guardar")
    public Post guardarPost(@RequestBody Post nuevoPost) {
        Post postGuardar = postService.guardarPost(nuevoPost);
        return postGuardar;
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarPostPorId(@PathVariable Long id){
        postService.borrarPost(id);
        return "El post ha sido borrado";
    }

    @PutMapping("/editar/{id}")
    public Post editarPostPorId(@PathVariable Long id, @RequestBody Post postActualizado){
        Post postEditado = postService.editarPostPorId(id, postActualizado);
        return postEditado;
    }

    @GetMapping("/buscar/{id}")
    public Post postPorId(@PathVariable Long id){
        Post postMostrar = postService.buscarPostPorId(id);
        return postMostrar;
    }

}