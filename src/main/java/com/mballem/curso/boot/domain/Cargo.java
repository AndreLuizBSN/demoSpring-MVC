package com.mballem.curso.boot.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name="CARGOS")
public class Cargo extends AbstractEntity<Long> {

	@NotBlank(message = "Informe um nome!")
	@Size(min= 3, max=60, message= "O nome do cargo deve ter entre {min} e {max} caracteres!")
	@Column(name="NOME", nullable=false, unique=true, length=60)
	private String nome;
	
	@NotNull(message="Selecione um departamento antes de salvar!")
	@ManyToOne
	@JoinColumn(name = "id_departamento_fk")
	private Departamento departamento;
	
	@OneToMany(mappedBy="cargo")
	private List<Funcionario> funcionarios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
}
