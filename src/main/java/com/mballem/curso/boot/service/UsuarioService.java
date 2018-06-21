package com.mballem.curso.boot.service;

import java.util.List;

import com.mballem.curso.boot.domain.Usuario;

public interface UsuarioService {

	void salvar(Usuario usuario);
	
	void editar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario buscarPorId(Long id);
	
	List<Usuario> buscarTodos();

	Usuario buscarPorLoginESenha(String login, String senha);
}
