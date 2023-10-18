package com.example.apicomentario.services;
import com.example.apicomentario.models.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listaDeUsuarios();

    Usuario buscarUsuarioPorId(Long id);
    Usuario guardarUsuario(Usuario usuarioNuevo);
    void borrarUsuario(Long id);
    Usuario findByEmail(String usuarioEmail);
  //  void deleteByToken(String usuarioToken);

}
