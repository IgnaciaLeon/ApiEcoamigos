package com.example.apicomentario.controllers;
import com.example.apicomentario.models.Usuario;
import com.example.apicomentario.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/lista")
    public List<Usuario> listaUsuario() {
        List<Usuario> mostrarListaUsuario = usuarioService.listaDeUsuarios();
        return mostrarListaUsuario;
    }

    @PostMapping("/guardar")
    public Usuario guardarUsuario(@RequestBody Usuario nuevoUsuario) {
        Usuario usuarioGuardar = usuarioService.guardarUsuario(nuevoUsuario);
        return usuarioGuardar;
    }

    @DeleteMapping("/borrar/id/{id}")
    public String borrarUsuarioPorId(@PathVariable Long id){
        usuarioService.borrarUsuario(id);
        return "El usuario ha sido borrado";
    }

  /*  @DeleteMapping("/borrar/token/{usuarioToken}")
    public String deleteByToken (@PathVariable String usuarioToken){
        usuarioService.deleteByToken(usuarioToken);
        return "El usuario ha sido borrado";
    }
    @PutMapping("/editar/{id}")
    public Usuario editarUsuarioPorId(@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        Usuario usuarioEditado = usuarioService.editarUsuarioPorId(id, usuarioActualizado);
        return usuarioEditado;
    }

 */

    @GetMapping("/buscar/id/{id}")
    public Usuario usuarioPorId(@PathVariable Long id){
        Usuario usuarioMostrar = usuarioService.buscarUsuarioPorId(id);
        return usuarioMostrar;
    }

  /*  @GetMapping("/buscar/{token}")
    public Usuario buscarUsuarioPorToken(@RequestParam String token) {
        Usuario usuario = usuarioService.findByToken(token);

        if (usuario != null) {
            return (usuario);
        } else {
            return Usuario.notFound().build();
        }
    }

   */

    @GetMapping("/buscar/email") //localhost:8080/usuario/buscar/email?usuarioEmail=i.lyon.graf@gmail.com
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String usuarioEmail) {
        Usuario usuario = usuarioService.findByEmail(usuarioEmail);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
         return ResponseEntity.notFound().build();
        }
    }



}
