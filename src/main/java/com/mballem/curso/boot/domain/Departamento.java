package com.mballem.curso.boot.domain;

import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
@Table(name="DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {

	@NotBlank(message = "Informe um nome!")
	@Size(min= 3, max=60, message= "O nome do departamento deve ter entre {min} e {max} caracteres!")
	@Column(name="NOME", nullable=false, unique=true, length=60)
	private String nome;
	
	@OneToMany(mappedBy="departamento")
	private List<Cargo> cargos;

	@Column(name="ATIVO", nullable=false, columnDefinition="BOOLEAN DEFAULT true")
	private boolean ativo;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
}