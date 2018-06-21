package com.mballem.curso.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name="USUARIOS")
public class Usuario extends AbstractEntity<Long> {

	@NotBlank(message = "Informe um nome!")
	@Size(min= 3, max=60, message= "O nome do usuário deve ter entre {min} e {max} caracteres!")
	@Column(name="NOME", nullable=false, unique=true, length=60)
	private String nome;
	
	@NotBlank(message = "Informe um login!")
	@Size(min= 3, max=60, message= "O login do usuário deve ter entre {min} e {max} caracteres!")
	@Column(name="LOGIN", nullable=false, unique=true, length=60)
	private String login;
	
	@NotBlank(message = "Informe uma senha!")
	@Size(min= 3, max=60, message= "A senha do usuário deve ter entre {min} e {max} caracteres!")
	@Column(name="SENHA", nullable=false, unique=true, length=60)
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}
