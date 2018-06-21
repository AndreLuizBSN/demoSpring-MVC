package com.mballem.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.mballem.curso.boot.domain.Usuario;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario, Long> implements UsuarioDao {

	@Override
	public Usuario findByLoginESenha(String login, String senha) {
		return createQuery("select f from Usuario f where f.login = ?1 and f.senha = ?2", login, senha).get(0);
	}


}
