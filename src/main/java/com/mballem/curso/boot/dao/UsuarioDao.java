package com.mballem.curso.boot.dao;

import java.util.List;

import com.mballem.curso.boot.domain.Usuario;

public interface UsuarioDao {

    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(Long id);

    Usuario findById(Long id);
    
    Usuario findByLoginESenha(String login, String senha);

    List<Usuario> findAll();
}
