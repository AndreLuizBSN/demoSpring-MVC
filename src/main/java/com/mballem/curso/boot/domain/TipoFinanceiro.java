package com.mballem.curso.boot.domain;


import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
@Table(name="TIPO_FINANCEIRO")
public class TipoFinanceiro extends AbstractEntity<Long> {

	@NotBlank(message = "Informe um nome!")
	@Size(min= 3, max=60, message= "O nome do departamento deve ter entre {min} e {max} caracteres!")
	@Column(name="NOME", nullable=false, unique=true, length=60)
	private String nome;
	
	@NotNull(message = "Informe se é entrada ou saída")
	@Column(name="ENTRADA_SAIDA", nullable=false)
	@Enumerated(EnumType.STRING)
	private EntradaSaida entradaSaida;
		
	@Column(name="ATIVO", nullable=false, columnDefinition="BOOLEAN DEFAULT true")
	private boolean ativo;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public EntradaSaida getEntradaSaida() {
		return entradaSaida;
	}

	public void setEntradaSaida(EntradaSaida entradaSaida) {
		this.entradaSaida = entradaSaida;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
